package com.example.activiti.resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.activiti.EntityFactory;

@Controller
public class IdentityController {

	@Autowired
	private IdentityService identityService;

	/**
	 * @return all the tasks of the specified group.
	 */
	@RequestMapping(value = "/group/{procDefId}", method = GET)
	public @ResponseBody Iterable<Group> getGroup(@PathVariable String procDefId) {
		List<Group> list = new ArrayList<>();
		identityService.createGroupQuery().potentialStarter(procDefId).list()
				.forEach(h -> list.add(EntityFactory.createGroup(h)));
		return list;
	}

	/**
	 * @return all the tasks of the specified group.
	 */
	@RequestMapping(value = "/user/{procDefId}", method = GET)
	public @ResponseBody Iterable<User> getUser(@PathVariable String procDefId) {
		List<User> list = new ArrayList<>();
		identityService.createUserQuery().potentialStarter(procDefId).list()
				.forEach(h -> list.add(EntityFactory.createUser(h)));
		return list;
	}
}
