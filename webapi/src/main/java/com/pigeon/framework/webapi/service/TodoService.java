package com.pigeon.framework.webapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pigeon.framework.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "saan", "Learn Spring in MVC", new Date(), false));
		todos.add(new Todo(2, "saan", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "saan", "Learn Hibernate", new Date(), false));
	}

	public List<Todo> getTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}

	public Todo getTodo(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}

	public void addTodo(String user, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, user, desc, targetDate, isDone));
	}

	public void deleteTodo(int id) {
		/*
		 * for(Todo todo : todos) { if(todo.getId() == id) { todos.remove(todo); } }
		 */
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
		/*
		 * Iterator<Todo> iterator = todos.iterator(); while(iterator.hasNext()) { Todo
		 * todo = iterator.next(); if(todo.getId() == todo.id) { iterator.remove(); } }
		 */

	}

	public void updateTodo(Todo todo) {
		// delete
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo t = iterator.next();
			if (t.getId() == todo.id) {
				iterator.remove();
				// t.desc=todo.desc;
				// t.targetDate=todo.targetDate;
				// t.isDone=todo.isDone;
			}
		}
		// add
		todos.add(todo);
	}
}
