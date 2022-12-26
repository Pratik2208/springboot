package com.springboot.service;

import com.springboot.entity.Department;
import com.springboot.error.DepartmentNotfoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

   public List<Department> fetchAllDepartment();

    public Department getDepartmentById(int departmentId) throws DepartmentNotfoundException;

    public void deleteDepartmentById(int departmentId);

    public Department updateDepartment(int departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
