package com.pigeon.framework.webapi.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pigeon.framework.model.Todo;
import com.pigeon.framework.webapi.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService service;

	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodosListPage(ModelMap model) {
		String name = (String) model.get("name");
		model.put("todos", service.getTodos(name));
		return "list-todos";
	}

	@RequestMapping(value="/todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		String name = (String) model.get("name");
		model.addAttribute("todo", new Todo(0, name, "", new Date(), false));
		model.put("todos", service.getTodos(name));
		return "todo";
	}

	@RequestMapping(value="/todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()){
			return "todo";
		}
		service.addTodo((String) model.get("name"), todo.desc, new Date(), false);
		//model.put("todos", service.getTodos(name));
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
		Todo todo = service.getTodo(id);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value="/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()){
			return "todo";
		}
		todo.setUser((String) model.get("name"));
		service.updateTodo(todo);
		return "redirect:/list-todos";
	}
	
}
