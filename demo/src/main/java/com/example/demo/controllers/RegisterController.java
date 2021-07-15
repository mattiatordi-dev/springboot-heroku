package com.example.demo.controllers;

import com.example.demo.bean.PersonForm;
import com.example.demo.model.Utente;
import com.example.demo.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class RegisterController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @Autowired
    RegisterRepository registerRepository;

    @GetMapping(value = "/register")
    public String showForm(PersonForm personForm) {
        return "userFormRegister";
    }

    @PostMapping(value = "/register")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult,
                                  Model model,
                                  @RequestParam(value = "nome") String nome,
                                  @RequestParam(value = "cognome") String cognome,
                                  @RequestParam(value = "dataNascita") String dataNascita,
                                  @RequestParam(value = "password") String password) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("personForm",personForm);
            return "userFormRegister";
        } else if (registerRepository.findByCognome(cognome) == null) {
            Utente utente = new Utente(0, nome, cognome, LocalDate.parse(dataNascita), false, password);
            registerRepository.save(utente);

            return "results";
        }
        else return "errorRegisterPerson";
    }

    @PostMapping(value = "/results")
    public String returnResults(){
        return "results";
    }
}

