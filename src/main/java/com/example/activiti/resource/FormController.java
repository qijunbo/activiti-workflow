package com.example.activiti.resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.activiti.engine.FormService;
import org.activiti.engine.form.FormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.activiti.EntityFactory;

@Controller
@RequestMapping("/form")
public class FormController {

	@Autowired
	private FormService formService;

	/**
	 * @return all the tasks of the specified group.
	 */
	@RequestMapping(value = "/task/{id}", method = GET)
	public @ResponseBody FormData getTaskOfGroup(@PathVariable String id) {
		return EntityFactory.createFormData(formService.getTaskFormData(id));
	}

}
