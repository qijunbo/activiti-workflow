
启动本应用后, 控制台有个监控程序, 不停的输出log, 看看当前有什么任务卡住了.  用这个可以来看执行的效果.

1. 第一件事情, 部署一个工作流 
---
DeploymentController

POST
http://localhost/deployment    不用带参数, 系统自动部署供学习用的工作流.
返回id   1

GET
http://localhost/deployment/1

返回 (看来返回的也真是没啥有用的东西.)
```
{
"name": null,
"id": "1",
"deploymentTime": 1503037813534,
"tenantId": "",
"category": null
}
```
GET
http://localhost/deployment/
返回所有, (看来返回的也真是没啥有用的东西.)

2.   ProcessDefinitionController
---
GET
http://localhost/processDefinition/1
返回了一点看起来有那么点卵用的东西.
```
{
"name": "Onboarding",
"key": "onboarding",
"id": "onboarding:1:4",
"version": 1,
"suspended": false,
"description": null,
"resourceName": "onboarding.bpmn20.xml",
"tenantId": "",
"deploymentId": "1",
"category": "http://www.activiti.org/processdef",
"diagramResourceName": "onboarding.onboarding.png"
}
```
3. 启动一个工作流 ProcessInstanceController
---
POST
http://localhost/processInstance/onboarding
返回id   2501 
这个工作流就这么启动了.

GET
http://localhost/processInstance/onboarding

返回key是 onboarding的 过程,
```
{
"name": null,
"id": "2501",
"localizedName": null,
"suspended": false,
"description": null,
"activityId": "enterOnboardingData",
"tenantId": "",
"deploymentId": "1",
"businessKey": null,
"ended": false,
"parentId": null,
"processInstanceId": "2501",
"processDefinitionId": "onboarding:1:4",
"processVariables": {},
"processDefinitionKey": "onboarding",
"superExecutionId": null,
"localizedDescription": null,
"processDefinitionVersion": 1,
"processDefinitionName": "Onboarding"
}
```

用 IdentityController  这个可以查看用户 和 组.
传入上面消息里面的 processDefinitionId 

GET

http://localhost/group/onboarding:1:4
http://localhost/user/onboarding:1:4

啥都没有返回,  我肯定上当了, MLGB的.


4. TaskController  获得可执行的任务.
---

GET
http://localhost/task/group/managers
获取group是managers的任务, 等一等, 我怎么知道有个group名字叫manager?
返回  信息里面有task  id, 马上用得上.
```
{
"name": "Enter Data",
"priority": 50,
"id": "2505",
"owner": null,
"suspended": false,
"description": null,
"assignee": null,
"dueDate": null,
"tenantId": "",
"category": null,
"formKey": null,
"executionId": "2501",
"parentTaskId": null,
"createTime": 1503038750641,
"processInstanceId": "2501",
"processDefinitionId": "onboarding:1:4",
"processVariables": null,
"taskDefinitionKey": "enterOnboardingData",
"taskLocalVariables": {},
"delegationState": null
}
```

POST
http://localhost/task/2505
这个是用来完成当前任务,  id我是从上面的消息里找到了, 可是报文格式怎么办呢?
请看下节:

5. FormController  获取指定任务的表单样式
---
GET
http://localhost/form/task/2505
返回上面那个id是 2505的任务的表单格式. 但是不能直接拿来用, 需要构造成一个 map,  不要问我为什么, 我就是知道.
```
{
"deploymentId": "1",
"formKey": null,
"formProperties": [
  {
"id": "fullName",
"name": "Full Name",
"type": {
"name": "string",
"mimeType": "text/plain"
},
"value": null,
"readable": true,
"writable": true,
"required": false
},
  {
"id": "yearsOfExperience",
"name": "Years of Experience",
"type": {
"name": "long",
"mimeType": "plain/text"
},
"value": null,
"readable": true,
"writable": true,
"required": true
}
],
}

```
构造好的请求报文,用来完成一个task
```
{
	"fullName": "tony",
	"yearsOfExperience": 12,
}
```

POST
http://localhost/task/2505
```
{
	"fullName": "tony",
	"yearsOfExperience": 12
}
```
返回内容: true

**这时候,你会发现控制台有新任务了.**

6.  重新回去看任务. TaskController
---
GET
http://localhost/task/group/managers
这次返回的任务id变了
```
{
"name": "Personalized Introduction and Data Entry",
"priority": 50,
"id": "2511",
"owner": null,
"suspended": false,
"description": null,
"assignee": null,
"dueDate": null,
"tenantId": "",
"category": null,
"formKey": null,
"executionId": "2501",
"parentTaskId": null,
"createTime": 1503039801369,
"processInstanceId": "2501",
"processDefinitionId": "onboarding:1:4",
"processVariables": null,
"taskDefinitionKey": "personalizedIntro",
"taskLocalVariables": {},
"delegationState": null
}
```

GET
http://localhost/form/task/2511

看看表单格式
```
{
"deploymentId": "1",
"formKey": null,
"formProperties": [
  {
"id": "personalWelcomeTime",
"name": "Personal Welcome Time",
"type": {
"name": "date"
},
"value": null,
"readable": true,
"writable": true,
"required": false
}
],
}
```
构造完成task的 map

{
	"personalWelcomeTime": "2/14/17"
}

再完成任务吧:

POST
http://localhost/task/2511
```
{
	"personalWelcomeTime": "2/14/17"
}
```
返回: true

**这时候,你会发现控制台没什么卡住的任务了.**



7. 查看历史 ,  党经常教育某岛国人民要尊重历史, 我们来看看
---

GET
http://localhost/history/processInstance/2501

历史出来了:

自己看吧, 我是看不大懂. :) 


