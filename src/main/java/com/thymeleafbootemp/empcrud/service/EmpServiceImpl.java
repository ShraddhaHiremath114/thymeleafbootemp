package com.thymeleafbootemp.empcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thymeleafbootemp.empcrud.dao.EmpRepo;
import com.thymeleafbootemp.empcrud.entity.Employee;

@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    private EmpRepo empRepo;

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public Employee getById(int id) {
        Optional<Employee> optional=empRepo.findById(id);
        Employee employee=null;
        if(optional.isPresent()){
employee=optional.get();
        }else{
            throw new RuntimeException("Employee Id not found"+ id);
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        empRepo.save(employee);
    }

    @Override
    public void deleteById(int id) {
        empRepo.deleteById(id);
    }

}
