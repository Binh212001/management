package com.example.management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping({"/overtime"})
public class OvertimeController {
    @GetMapping({ "/", ""})
    public  String  getViewOvertime(){
        return "overtime/Overtime";
    }

}
