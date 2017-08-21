package com.example.activiti.resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.activiti.EntityFactory;
import com.example.activiti.entity.GroupProxy;
import com.example.activiti.entity.UserProxy;

@Controller
public class IdentityController {

	@Autowired
	private IdentityService identityService;

	@RequestMapping(value = "/group/proc/{procDefId}", method = GET)
	public @ResponseBody Iterable<Group> getGroupByProcDefId(@PathVariable String procDefId) {
		List<Group> list = new ArrayList<>();
		identityService.createGroupQuery().potentialStarter(procDefId).list()
				.forEach(h -> list.add(EntityFactory.convertGroup(h)));
		return list;
	}

	@RequestMapping(value = "/group/{id}", method = GET)
	public @ResponseBody Group getGroup(@PathVariable String id) {
		return EntityFactory.convertGroup(identityService.createGroupQuery().groupId(id).singleResult());
	}

	@RequestMapping(value = "/group", method = POST)
	public @ResponseBody void createGroup(@RequestBody GroupProxy group) {
		identityService.saveGroup(EntityFactory.createGroup(identityService, group));
	}

	@RequestMapping(value = "/group", method = GET)
	public @ResponseBody Iterable<Group> getGroups() {
		List<Group> list = new ArrayList<>();
		identityService.createGroupQuery().list().forEach(h -> list.add(EntityFactory.convertGroup(h)));
		return list;
	}

	@RequestMapping(value = "/user/proc/{procDefId}", method = GET)
	public @ResponseBody Iterable<User> getUserByProcDefId(@PathVariable String procDefId) {
		List<User> list = new ArrayList<>();
		identityService.createUserQuery().potentialStarter(procDefId).list()
				.forEach(h -> list.add(EntityFactory.convertUser(h)));
		return list;
	}

	@RequestMapping(value = "/user/{id}", method = GET)
	public @ResponseBody User getUser(@PathVariable String id) {
		return EntityFactory.convertUser(identityService.createUserQuery().userId(id).singleResult());
	}

	@RequestMapping(value = "/user", method = GET)
	public @ResponseBody Iterable<User> getUsers() {
		List<User> list = new ArrayList<>();
		identityService.createUserQuery().list().forEach(h -> list.add(EntityFactory.convertUser(h)));
		return list;
	}

	@RequestMapping(value = "/user", method = POST)
	public @ResponseBody void createUser(@RequestBody UserProxy user) {
		identityService.saveUser(EntityFactory.createUser(identityService, user));
	}

}
