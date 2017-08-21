package com.example.activiti.resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.activiti.EntityFactory;

@Controller
@RequestMapping("/history")
public class HistoryController {

	@Autowired
	private HistoryService historyService;

	/**
	 * @return all the tasks of the specified group.
	 */
	@RequestMapping(value = "/processInstance/{id}", method = GET)
	public @ResponseBody Iterable<HistoricActivityInstance> getHistory(@PathVariable String id) {

		List<HistoricActivityInstance> list = new ArrayList<>();

		historyService.createHistoricActivityInstanceQuery().processInstanceId(id).finished()
				.orderByHistoricActivityInstanceEndTime().asc().list()
				.forEach(h -> list.add(EntityFactory.convertHistoricActivityInstance(h)));

		return list;
	}

}
