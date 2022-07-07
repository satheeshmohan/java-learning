package com.pigeon.framework.webapi.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pigeon.framework.webapi.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService service;

	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodosList(ModelMap model) {
		String name = (String) model.get("name");
		model.put("todos", service.getTodos(name));
		return "list-todos";
	}

	@RequestMapping(value="/todo", method = RequestMethod.GET)
	public String showAddTodo(ModelMap model) {
		String name = (String) model.get("name");
		model.put("todos", service.getTodos(name));
		return "todo";
	}

	@RequestMapping(value="/todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @RequestParam String desc) {
		String name = (String) model.get("name");
		service.addTodo(name, desc, new Date(), false);
		//model.put("todos", service.getTodos(name));
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
}
