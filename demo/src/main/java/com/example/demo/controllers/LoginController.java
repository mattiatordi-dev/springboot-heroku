package com.example.demo.controllers;

import com.example.demo.repository.RegisterRepository;
import com.example.demo.security.AuthProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class LoginController implements WebMvcConfigurer {

    private static final Logger _logger =  LogManager.getLogger(AuthProvider.class);

    @Autowired
    RegisterRepository registerRepository;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/a").setViewName("results");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/access-denied").setViewName("accessDenied");
        registry.addViewController("/showHomepage").setViewName("Homepage");
        registry.addViewController("/showHomepageUser").setViewName("HomepageUser");
    }

    @GetMapping("/")
    public String showUserDB(Model model, Authentication authentication){
        model.addAttribute("lista",registerRepository.findAll());

        _logger.info("Autenticazione:  " + authentication.getAuthorities());

        if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))){
            return "Homepage";
        }

        model.addAttribute("cognome",authentication.getName());

        return "HomepageUser";
    }

}
