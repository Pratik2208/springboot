package com.springboot.controller;

import com.springboot.entity.Department;
import com.springboot.error.DepartmentNotfoundException;
import com.springboot.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchAllDepartment(){
        return departmentService.fetchAllDepartment();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") int departmentId) throws DepartmentNotfoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") int departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") int departmentId,@RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    // Finding data by property Name because JPA repository Only Supports to fetch By ID
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable ("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);

    }
}
