package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.Principal;

@Controller
public class LoginController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/a").setViewName("results");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/access-denied").setViewName("accessDenied");
    }

    @GetMapping()
    public String goToHome(Principal principal){
        if(principal.getName().equalsIgnoreCase("admin"))
        return "Homepage";
        else return "start";

    }

}
