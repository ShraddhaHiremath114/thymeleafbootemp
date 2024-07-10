package com.thymeleafbootemp.empcrud.service;

import java.util.List;

import com.thymeleafbootemp.empcrud.entity.Employee;

public interface EmpService {

    List<Employee> getAllEmployees();
    Employee getById(int id);
    void save(Employee employee);
    void deleteById(int id);
}
