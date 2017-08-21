package com.example.activiti.resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.activiti.EntityFactory;

@Controller
@RequestMapping("/processInstance")
public class ProcessInstanceController {

	@Autowired
	private RuntimeService runtimeService;

	@RequestMapping(value = "/{key}", method = GET)
	public @ResponseBody Iterable<ProcessInstance> getProcessInstance(@PathVariable String key) {

		List<ProcessInstance> list = new ArrayList<>();
		runtimeService.createProcessInstanceQuery().processDefinitionKey(key).list()
				.forEach(p -> list.add(EntityFactory.convertProcessInstance(p)));
		return list;
	}

	@RequestMapping(method = GET)
	public @ResponseBody Iterable<ProcessInstance> getProcessInstance() {
		List<ProcessInstance> list = new ArrayList<>();
		runtimeService.createProcessInstanceQuery().list()
				.forEach(p -> list.add(EntityFactory.convertProcessInstance(p)));
		return list;
	}

	@RequestMapping(value = "/{key}", method = POST)
	public @ResponseBody String start(@PathVariable String key) {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);
		return processInstance.getId();
	}
}
