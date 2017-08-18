package com.example.activiti.resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

	/**
	 * @return all the tasks of the specified group.
	 */
	@RequestMapping(value = "/group/{group}", method = GET)
	public @ResponseBody Iterable<Task> getTaskOfGroup(@PathVariable String group) {
		List<Task> list = new ArrayList<>();
		taskService.createTaskQuery().taskCandidateGroup(group).list()
				.forEach(t -> list.add(EntityFactory.createTask(t)));
		return list;
	}

	/**
	 * @return all the tasks of the specified group.
	 */
	@RequestMapping(value = "/user/{user}", method = GET)
	public @ResponseBody Iterable<Task> getTaskOfUser(@PathVariable String user) {
		List<Task> list = new ArrayList<>();
		taskService.createTaskQuery().taskCandidateUser(user).list()
				.forEach(t -> list.add(EntityFactory.createTask(t)));
		return list;

	}

	/**
	 * @return all the tasks of the specified group.
	 */
	@RequestMapping(value = "/{id}", method = POST)
	public @ResponseBody boolean complete(@PathVariable String id, @RequestBody Map variables) {
		taskService.complete(id, variables);
		return true;
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
