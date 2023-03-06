package com.zkteco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zkteco.entity.Department;
import com.zkteco.service.DepartmentService;

import jakarta.transaction.Transactional;

@RestController
public class Controller {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/dep")
	public Department saveDepartmentController(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments/{Id}")
	public Department getDepartmentById(@PathVariable("Id") Long departmentId){
		return departmentService.getDepartmentById(departmentId);
	}
	
	@GetMapping("/departments")
	public List<Department> getDepartmentList(){
		return departmentService.getDepartmentList();
	}
	
	@DeleteMapping("/departments/{Id}")
	public String deleteDepartmentController(@PathVariable("Id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Department is deleted";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long departmentId,
										   @RequestBody Department department ) {
		return departmentService.updateDepartementById(departmentId,department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String deptName) {
		return departmentService.fetchDepartementByName(deptName);
	}
	
//	@Transactional
	@DeleteMapping("/departments/name/{name}")
	public String deleteDepartmentByName(@PathVariable("name") String deptName) {
		departmentService.deleteDepartementByName(deptName);
		return "deleted successfully";
	}
	
}
