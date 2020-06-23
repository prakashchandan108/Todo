package com.dao;

import java.util.List;
import com.model.Todo;

public interface TodoDAO {
	public List<Todo> findAll();

	public Todo getTodoById(int id);

	public List<Todo> getTodoByName(String description);
	public void delete(int id);
	public Todo saveOrUpdate(Todo todo);
}
