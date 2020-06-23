package com;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Todo;
import com.service.TodoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoController {
	
	private Logger logger = LoggerFactory.getLogger(TodoController.class);

	@Autowired
	TodoService todoService;

	@GetMapping(path = "/todos")
	public ResponseEntity<List<Todo>> listTodos() {
		List<Todo> todos = todoService.findAll();
		return new ResponseEntity<List<Todo>>(todos, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(path = "/todos/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable int id) {
		Todo todo = todoService.getTodoById(id);
		return new ResponseEntity<Todo>(todo, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/todos/{id}")
	public HttpStatus deleteById(@PathVariable int id) {
		todoService.delete(id);
		return HttpStatus.FORBIDDEN;
	}

	@PutMapping(path = "/todos")
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
		logger.info("INSIDE updateTodo(@RequestBody Todo todo) :: TodoController");
		Todo updatedTodo = todoService.saveOrUpdate(todo);
		return new ResponseEntity<Todo>(updatedTodo, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/todos")
	public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
		logger.info("INSIDE saveTodo(@RequestBody Todo todo) :: TodoController");
		todo = todoService.saveOrUpdate(todo);
		return new ResponseEntity<Todo>(todo, new HttpHeaders(), HttpStatus.CREATED);
	}
}
