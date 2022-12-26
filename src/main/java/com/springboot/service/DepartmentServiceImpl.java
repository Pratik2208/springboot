package com.springboot.service;

import com.springboot.entity.Department;
import com.springboot.error.DepartmentNotfoundException;
import com.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(int departmentId) throws DepartmentNotfoundException {
       Optional<Department> department =  departmentRepository.findById(departmentId);

       if(!department.isPresent()){
           throw new DepartmentNotfoundException("Department is Not Available");
       }

       return department.get();
    }

    @Override
    public void deleteDepartmentById(int departmentId) {
         departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(int departmentId, Department department) {
        Department depDb = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            depDb.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
        !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDb);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        //return departmentRepository.findByDepartmentName(departmentName);
        return departmentRepository.findByDepartmentName(departmentName);
    }
}
