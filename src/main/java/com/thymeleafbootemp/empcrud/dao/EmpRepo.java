package com.thymeleafbootemp.empcrud.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.thymeleafbootemp.empcrud.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee,Integer>{

}
