package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TodoDAO;
import com.model.Todo;
import com.service.TodoService;

@Service
@Transactional
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoDAO todoDAO;
	
	@Override
	public List<Todo> findAll() {
		return todoDAO.findAll();
	}
	
	@Override
	public Todo getTodoById(int id){
		return todoDAO.getTodoById(id);
	}

	@Override
	public List<Todo> getTodoByName(String description){
		return todoDAO.getTodoByName(description);
	}
	
	@Override
	public void delete(int id){
		todoDAO.delete(id);
	}
	
	@Override
	public Todo saveOrUpdate(Todo todo){
		return todoDAO.saveOrUpdate(todo);
	}
}
