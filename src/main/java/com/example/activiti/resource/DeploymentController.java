package com.example.activiti.resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.activiti.EntityFactory;

@Controller
@RequestMapping("/deployment")
public class DeploymentController {

	@Autowired
	private RepositoryService repositoryService;

	@RequestMapping(value = "/{id}", method = GET)
	public @ResponseBody Deployment getTaskOfGroup(@PathVariable String id) {
		return EntityFactory.convertDeployment(repositoryService.createDeploymentQuery().deploymentId(id).singleResult());
	}

	@RequestMapping(method = GET)
	public @ResponseBody Iterable<Deployment> getDeployment() {
		List<Deployment> list = new ArrayList<>();
		repositoryService.createDeploymentQuery().list().forEach(d -> list.add(EntityFactory.convertDeployment(d)));
		return list;
	}

	@RequestMapping(method = POST)
	public @ResponseBody String deploy() {
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("onboarding.bpmn20.xml")
				.deploy();
		return deployment.getId();
	}
}
