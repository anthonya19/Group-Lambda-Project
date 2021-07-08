package com.sg.FoodDelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class WebController {

    @GetMapping("login")
    public String loginPage(){
        return "Login";
    }
}
