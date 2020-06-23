package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@GetMapping(path = "/employees/{name}")
	public String getEmployeeName(@PathVariable String name){
		return name;
	}
}
