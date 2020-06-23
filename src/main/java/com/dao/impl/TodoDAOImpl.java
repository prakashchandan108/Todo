package com.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.TodoDAO;
import com.model.Todo;

@Repository
public class TodoDAOImpl implements TodoDAO{

	@Autowired
	EntityManager em;
	
	@Override
	public List<Todo> findAll() {
		TypedQuery<Todo> todos = em.createQuery("Select t from Todo t", Todo.class);
		return todos.getResultList();
	}

	@Override
	public Todo getTodoById(int id){
		return em.find(Todo.class, id);
	}
	
	@Override
	public List<Todo> getTodoByName(String description){
		TypedQuery<Todo> todos = em.createQuery("Select t from Todo t where t.description=:description", Todo.class).setParameter("description", description);
		return todos.getResultList();
	}
	
	@Override
	public void delete(int id){
		Todo todo = this.getTodoById(id);
		if(todo != null){
			em.remove(todo);
		}
	}
	
	@Override
	public Todo saveOrUpdate(Todo todo){
		return em.merge(todo);
	}
}
