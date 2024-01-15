package com.example.management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping({"/time-off"})
public class TimeOffController {
    @GetMapping({ "/",""})
    public  String  getViewTimeOff(){
        int i=1;
        return "timeoff/TimeOff";
    }

}
