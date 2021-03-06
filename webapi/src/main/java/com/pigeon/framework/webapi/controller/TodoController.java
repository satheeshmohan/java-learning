package com.pigeon.framework.webapi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodosListPage(ModelMap model) {
		String name = getLoggedinUserName(model);
		model.put("todos", service.getTodos(name));
		return "list-todos";
	}

	private String getLoggedinUserName(ModelMap model) {
		return (String) model.get("name");
	}

	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		String name = getLoggedinUserName(model);
		model.addAttribute("todo", new Todo(0, name, "", new Date(), false));
		model.put("todos", service.getTodos(name));
		return "todo";
	}

	@RequestMapping(value = "/todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		service.addTodo(getLoggedinUserName(model), todo.desc, todo.targetDate, false);
		// model.put("todos", service.getTodos(name));
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
		Todo todo = service.getTodo(id);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todo.setUser(getLoggedinUserName(model));
		service.updateTodo(todo);
		return "redirect:/list-todos";
	}

}
