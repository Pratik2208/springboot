package com.springboot.service;

import com.springboot.entity.Department;
import com.springboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
// We use mockito library and mocking concept
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp(){

        Department department = Department.builder()
                .departmentName("CE")
                .departmentAddress("Hyderabad")
                .departmentId(0)
                .build();

        Mockito.when(departmentRepository.findByDepartmentName("CE")).
                thenReturn(department);
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "CE";
        // when below method is called then use upper rules Mockito when use
        Department found  = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}