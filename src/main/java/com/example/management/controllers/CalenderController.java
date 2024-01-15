package com.example.management.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping({"/calendar"})
public class CalenderController {
    @GetMapping({ "/",""})
    public  String  getViewCalender(){
        return "calendar/Calendar";
    }

}
