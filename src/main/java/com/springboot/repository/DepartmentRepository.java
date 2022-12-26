package com.springboot.repository;

import com.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    // Defining method for find by Name
    public Department findByDepartmentName(String departmentName);

}
