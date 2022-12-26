package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int departmentId;

    // Adding Validator for Name of Department
    @NotBlank(message = "Department Name can't be Blank")
    private String departmentName;

    private String departmentAddress;

    // We will use lombok plugin(Dependency) that will have all getter setter and constructor as well as toString method


}
