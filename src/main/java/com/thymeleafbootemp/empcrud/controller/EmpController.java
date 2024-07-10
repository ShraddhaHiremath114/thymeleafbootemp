package com.thymeleafbootemp.empcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.thymeleafbootemp.empcrud.entity.Employee;
import com.thymeleafbootemp.empcrud.service.EmpService;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("emplist", empService.getAllEmployees());
        return "index";
    }

    @GetMapping("/add")
    public String addemp(){
        return "addemp";
    }

    @PostMapping("/save")
    public String saveemp(@ModelAttribute("employee") Employee emplyee){
        empService.save(emplyee);
        return "redirect:/";
    }

    @GetMapping("/updatedEmp/{id}")
    public String updateemp(@PathVariable("id") int id,Model model){
        Employee employee=empService.getById(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") int id){
        empService.deleteById(id);
        return "redirect:/";
    }
}
