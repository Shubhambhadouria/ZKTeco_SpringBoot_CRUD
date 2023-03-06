package com.zkteco.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkteco.entity.Department;
import com.zkteco.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartmentById(Long departmentId) {
		Optional<Department> opt = departmentRepository.findById(departmentId);
		return opt.get();
	}
	
	@Override
	public List<Department> getDepartmentList() {
		return departmentRepository.findAll();
	}
	
	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartementById(Long departmentId, Department department) {
		
		Department dept = departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName()) && 
		!"".equalsIgnoreCase(department.getDepartmentName())) {
			dept.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentCode()) && 
				!"".equalsIgnoreCase(department.getDepartmentCode())) {
					dept.setDepartmentCode(department.getDepartmentCode());	
		}
		
		if(Objects.nonNull(department.getDepartmentAddresss()) && 
				!"".equalsIgnoreCase(department.getDepartmentAddresss())) {
					dept.setDepartmentAddresss(department.getDepartmentAddresss());;
		}
		
		return departmentRepository.save(dept);
	}

	@Override
	public Department fetchDepartementByName(String name) {
		return departmentRepository.findByDepartmentNameIgnoreCase(name);
	}

	
	@Override
	public void deleteDepartementByName(String deptName) {
		departmentRepository.deleteByDepartmentName(deptName);
	}

}
