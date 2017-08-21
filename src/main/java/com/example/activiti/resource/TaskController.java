package com.example.activiti.resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PATCH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.activiti.EntityFactory;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/{id}", method = GET)
	public @ResponseBody Task getTask(@PathVariable String id) {
		return EntityFactory.convertTask(taskService.createTaskQuery().taskId(id).singleResult());
	}

	@RequestMapping(value = "/{id}", method = PATCH)
	public @ResponseBody boolean complete(@PathVariable String id, @RequestBody Map variables) {
		taskService.complete(id, variables);
		return true;
	}

	@RequestMapping(method = GET)
	public @ResponseBody Iterable<Task> getTasks() {
		List<Task> list = new ArrayList<>();
		taskService.createTaskQuery().list().forEach(t -> list.add(EntityFactory.convertTask(t)));
		return list;
	}

	/**
	 * @return all the tasks of the specified group.
	 */
	@RequestMapping(value = "/group/{group}", method = GET)
	public @ResponseBody Iterable<Task> getTaskOfGroup(@PathVariable String group) {
		List<Task> list = new ArrayList<>();
		taskService.createTaskQuery().taskCandidateGroup(group).list()
				.forEach(t -> list.add(EntityFactory.convertTask(t)));
		return list;
	}

	@RequestMapping(value = "/user/{user}", method = GET)
	public @ResponseBody Iterable<Task> getTaskOfUser(@PathVariable String user) {
		List<Task> list = new ArrayList<>();
		taskService.createTaskQuery().taskCandidateUser(user).list()
				.forEach(t -> list.add(EntityFactory.convertTask(t)));
		return list;

	}

	@RequestMapping(value = "/{taskId}/group/{groupId}", method = POST)
	public @ResponseBody void addCandidateGroup(@PathVariable String taskId, @PathVariable String groupId) {
		taskService.addCandidateGroup(taskId, groupId);
	}

	@RequestMapping(value = "/{taskId}/user/{userId}", method = POST)
	public @ResponseBody void addCandidateUser(@PathVariable String taskId, @PathVariable String userId) {
		taskService.addCandidateUser(taskId, userId);
	}

	/**
	 * @return all the tasks of the specified group.
	 */
	@RequestMapping(value = "/complete/example", method = GET)
	public @ResponseBody Map example() {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("1", "tony");
		variables.put("2", 12);
		variables.put("fac", "4/12/19");

		return variables;
	}

}
