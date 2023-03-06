package com.zkteco.service;

import java.util.List;

import com.zkteco.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);
	
	public Department getDepartmentById(Long departmentId);
	
	public List<Department> getDepartmentList();
	
	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartementById(Long departmentId, Department department);

	public Department fetchDepartementByName(String name);

	public void deleteDepartementByName(String deptName);
	
	
}
