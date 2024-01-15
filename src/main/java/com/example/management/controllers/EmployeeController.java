package com.example.management.controllers;

import com.example.management.models.Employee;
import com.example.management.sevices.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/"})
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping({ "/employee"})
    public  String  getViewEmployee(){
        return "employee/Employee";
    }

    @GetMapping({"/employee/create"})
    public  String  getViewAddEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee/AddEmployee";
    }
    @PostMapping({"/employee/create/save"})
    public  String  saveEmployee(@ModelAttribute Employee employee , Model model){
        boolean isSuccess = employeeService.saveEmployee(employee);
        if (isSuccess == true){
        return "redirect:/employee";
        }

        Employee emp = new Employee();
        model.addAttribute("employee", emp);
        model.addAttribute("userExist" , "Email is available");
        return "employee/AddEmployee";
    }
}
