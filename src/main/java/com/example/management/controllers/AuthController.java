package com.example.management.controllers;

import com.example.management.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping({"/auth"})
public class AuthController {
    @GetMapping({ "/login"})
    public  String  getViewCalender(Model model){

        Employee e = new Employee();
        model.addAttribute("employee",e);

        return "auth/Login";
    }

}
