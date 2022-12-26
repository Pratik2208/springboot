package com.springboot.repository;

import com.springboot.entity.Department;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    public void setUp(){
        Department department =
                Department.builder()
                        .departmentName("mechanical")
                        .departmentAddress("Amity")
                        .build();

        // It will hold down the object and store into database as a mocking before method is completed
        // After that object department will be flushed out from memory
        entityManager.persist(department);
    }

    @Test
    public void checking(){
        Department dept = repository.findById(1).get();
        assertEquals(dept.getDepartmentName(),"mechanical");
    }
}