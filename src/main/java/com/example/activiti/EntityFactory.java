package com.example.activiti;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.activiti.engine.form.FormData;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.DelegationState;
import org.activiti.engine.task.Task;

public class EntityFactory {

	public static User createUser(User entiy) {

		return new User() {

			@Override
			public String getId() {
				return entiy.getId();
			}

			@Override
			public void setId(String id) {
				// TODO Auto-generated method stub

			}

			@Override
			public String getFirstName() {

				return entiy.getFirstName();
			}

			@Override
			public void setFirstName(String firstName) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setLastName(String lastName) {
				// TODO Auto-generated method stub

			}

			@Override
			public String getLastName() {
				return entiy.getLastName();
			}

			@Override
			public void setEmail(String email) {
				// TODO Auto-generated method stub

			}

			@Override
			public String getEmail() {
				return entiy.getEmail();
			}

			@Override
			public String getPassword() {
				return entiy.getPassword();
			}

			@Override
			public void setPassword(String string) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean isPictureSet() {
				return entiy.isPictureSet();
			}

		};

	}

	public static Group createGroup(Group entity) {
		return new Group() {

			@Override
			public String getId() {

				return entity.getId();
			}

			@Override
			public void setId(String id) {
				// TODO Auto-generated method stub

			}

			@Override
			public String getName() {
				return entity.getName();
			}

			@Override
			public void setName(String name) {
				// TODO Auto-generated method stub

			}

			@Override
			public String getType() {
				return entity.getType();
			}

			@Override
			public void setType(String string) {
				// TODO Auto-generated method stub

			}

		};
	}

	public static HistoricActivityInstance createHistoricActivityInstance(HistoricActivityInstance entity) {

		return new HistoricActivityInstance() {

			@Override
			public Date getTime() {

				return entity.getTime();
			}

			@Override
			public String getId() {
				return entity.getId();
			}

			@Override
			public String getActivityId() {
				return entity.getActivityId();
			}

			@Override
			public String getActivityName() {
				return entity.getActivityName();
			}

			@Override
			public String getActivityType() {
				return entity.getActivityType();
			}

			@Override
			public String getProcessDefinitionId() {
				return entity.getProcessDefinitionId();
			}

			@Override
			public String getProcessInstanceId() {
				return entity.getProcessInstanceId();
			}

			@Override
			public String getExecutionId() {
				return entity.getExecutionId();
			}

			@Override
			public String getTaskId() {
				return entity.getTaskId();
			}

			@Override
			public String getCalledProcessInstanceId() {
				return entity.getCalledProcessInstanceId();
			}

			@Override
			public String getAssignee() {
				return entity.getAssignee();
			}

			@Override
			public Date getStartTime() {
				return entity.getStartTime();
			}

			@Override
			public Date getEndTime() {
				return entity.getEndTime();
			}

			@Override
			public Long getDurationInMillis() {
				return entity.getDurationInMillis();
			}

			@Override
			public String getTenantId() {
				return entity.getTenantId();
			}

		};
	}

	public static ProcessDefinition createProcessDefinition(final ProcessDefinition entiy) {

		return new ProcessDefinition() {

			@Override
			public String getId() {

				return entiy.getId();
			}

			@Override
			public String getCategory() {
				return entiy.getCategory();
			}

			@Override
			public String getName() {
				return entiy.getName();
			}

			@Override
			public String getKey() {
				return entiy.getKey();
			}

			@Override
			public String getDescription() {
				return entiy.getDescription();
			}

			@Override
			public int getVersion() {
				return entiy.getVersion();
			}

			@Override
			public String getResourceName() {
				return entiy.getResourceName();
			}

			@Override
			public String getDeploymentId() {
				return entiy.getDeploymentId();
			}

			@Override
			public String getDiagramResourceName() {
				return entiy.getDiagramResourceName();
			}

			@Override
			public boolean hasStartFormKey() {
				return entiy.hasStartFormKey();
			}

			@Override
			public boolean hasGraphicalNotation() {
				return entiy.hasGraphicalNotation();
			}

			@Override
			public boolean isSuspended() {
				return entiy.isSuspended();
			}

			@Override
			public String getTenantId() {

				return entiy.getTenantId();
			}

		};
	}

	public static FormData createFormData(FormData form) {
		return new FormData() {

			@Override
			public String getFormKey() {

				return form.getFormKey();
			}

			@Override
			public String getDeploymentId() {
				return form.getDeploymentId();
			}

			@Override
			public List<FormProperty> getFormProperties() {

				return form.getFormProperties();
			}

		};
	}

	public static ProcessInstance createProcessInstance(final ProcessInstance entiy) {
		return new ProcessInstance() {

			@Override
			public String getId() {
				return entiy.getId();
			}

			@Override
			public boolean isEnded() {

				return entiy.isEnded();
			}

			@Override
			public String getActivityId() {
				return entiy.getActivityId();
			}

			@Override
			public String getProcessInstanceId() {
				return entiy.getProcessInstanceId();
			}

			@Override
			public String getParentId() {
				return entiy.getParentId();
			}

			@Override
			public String getSuperExecutionId() {
				return entiy.getSuperExecutionId();
			}

			@Override
			public String getProcessDefinitionId() {
				return entiy.getProcessDefinitionId();
			}

			@Override
			public String getProcessDefinitionName() {
				return entiy.getProcessDefinitionName();
			}

			@Override
			public String getProcessDefinitionKey() {
				return entiy.getProcessDefinitionKey();
			}

			@Override
			public Integer getProcessDefinitionVersion() {
				return entiy.getProcessDefinitionVersion();
			}

			@Override
			public String getDeploymentId() {
				return entiy.getDeploymentId();
			}

			@Override
			public String getBusinessKey() {
				return entiy.getBusinessKey();
			}

			@Override
			public boolean isSuspended() {
				return entiy.isSuspended();
			}

			@Override
			public Map<String, Object> getProcessVariables() {
				return entiy.getProcessVariables();
			}

			@Override
			public String getTenantId() {
				return entiy.getTenantId();
			}

			@Override
			public String getName() {
				return entiy.getName();
			}

			@Override
			public String getDescription() {
				return entiy.getDescription();
			}

			@Override
			public String getLocalizedName() {
				return entiy.getLocalizedName();
			}

			@Override
			public String getLocalizedDescription() {
				return entiy.getLocalizedDescription();
			}

		};
	}

	public static Task createTask(final Task entity) {

		return new Task() {

			@Override
			public String getId() {

				return entity.getId();
			}

			@Override
			public String getName() {

				return entity.getName();
			}

			@Override
			public String getDescription() {

				return entity.getDescription();
			}

			@Override
			public int getPriority() {

				return entity.getPriority();
			}

			@Override
			public String getOwner() {

				return entity.getOwner();
			}

			@Override
			public String getAssignee() {

				return entity.getAssignee();
			}

			@Override
			public String getProcessInstanceId() {

				return entity.getProcessInstanceId();
			}

			@Override
			public String getExecutionId() {
				return entity.getExecutionId();
			}

			@Override
			public String getProcessDefinitionId() {
				return entity.getProcessDefinitionId();
			}

			@Override
			public Date getCreateTime() {
				return entity.getCreateTime();
			}

			@Override
			public String getTaskDefinitionKey() {
				return entity.getTaskDefinitionKey();
			}

			@Override
			public Date getDueDate() {
				return entity.getDueDate();
			}

			@Override
			public String getCategory() {
				return entity.getCategory();
			}

			@Override
			public String getParentTaskId() {
				return entity.getParentTaskId();
			}

			@Override
			public String getTenantId() {
				return entity.getTenantId();
			}

			@Override
			public String getFormKey() {
				return entity.getFormKey();
			}

			@Override
			public Map<String, Object> getTaskLocalVariables() {
				return entity.getTaskLocalVariables();
			}

			@Override
			public DelegationState getDelegationState() {
				return entity.getDelegationState();
			}

			@Override
			public boolean isSuspended() {
				return entity.isSuspended();
			}

			@Override
			public Map<String, Object> getProcessVariables() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void setName(String name) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setLocalizedName(String name) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setDescription(String description) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setLocalizedDescription(String description) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setPriority(int priority) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setOwner(String owner) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setAssignee(String assignee) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setDelegationState(DelegationState delegationState) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setDueDate(Date dueDate) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setCategory(String category) {
				// TODO Auto-generated method stub

			}

			@Override
			public void delegate(String userId) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setParentTaskId(String parentTaskId) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setTenantId(String tenantId) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setFormKey(String formKey) {
				// TODO Auto-generated method stub

			}

		};
	}

	public static Deployment createDeployment(final Deployment entity) {

		return new Deployment() {

			@Override
			public String getId() {

				return entity.getId();
			}

			@Override
			public String getName() {

				return entity.getName();
			}

			@Override
			public Date getDeploymentTime() {

				return entity.getDeploymentTime();
			}

			@Override
			public String getCategory() {

				return entity.getCategory();
			}

			@Override
			public String getTenantId() {

				return entity.getTenantId();
			}
		};
	}

}
