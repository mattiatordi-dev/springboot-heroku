package com.example.demo.controllers;

import com.example.demo.model.Utente;
import com.example.demo.repository.RegisterRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.AuthProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    private static final Logger _logger =  LogManager.getLogger(AuthProvider.class);

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String showUserDB(Model model, Authentication authentication){
        model.addAttribute("lista",registerRepository.findAll());

        _logger.info("Autenticazione:  " + authentication);
        return "Users";
    }

    @GetMapping(value = "/Users")
    public String showUsersDB(Model model){
        List<Utente> lista = registerRepository.findAll();
        model.addAttribute("lista", lista);

        return "Users";
    }

    @GetMapping(value = "/searchUser")
    public String searchUserForName(@RequestParam(value = "name")String nome, Model model){
        List<Utente> lista = Collections.singletonList(userRepository.findByCognome(nome));
        model.addAttribute("lista", lista);

        return "Users";
    }

    @PostMapping(value = "/addUser")
    public String addUser(@RequestParam String name,
                          @RequestParam String surname,
                          @RequestParam String date,
                          @RequestParam String password,
                          Model model){

        LocalDate data = LocalDate.parse(date);
        Utente utente = new Utente(0,name,surname,data,false,password);
        registerRepository.save(utente);

        List<Utente> lista = registerRepository.findAll();
        model.addAttribute("lista", lista);

        return "Users";

    }

    @GetMapping(value = "/prova/{isAdmin}/lastname/{cognome}")
    public String show(@PathVariable("isAdmin")boolean isAdmin,@PathVariable("cognome")String cognome, Model model){

        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("cognome", cognome);

        _logger.info("Cognome Utente: " + cognome);
        _logger.info("Value Admin: " + isAdmin);

        return "userProfile";
    }

    @PostMapping(value = "/changeUserPsw/{oldPsw}")
    public String changePsw(@PathVariable("oldPsw")String oldPsw,@RequestParam(value = "password")String password,
                            Model model){
        userRepository.setUserPassword(password,oldPsw);

        List<Utente> lista = registerRepository.findAll();
        model.addAttribute("lista", lista);

        return "Users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("nome")String nome,
                             @RequestParam("cognome")String cognome,
                             @RequestParam("dataNascita")String dataNascita,
                             @RequestParam("password")String password,
                             Model model){

        userRepository.updateUser(cognome,nome,cognome,LocalDate.parse(dataNascita),password);

        return "Users";

    }

    @PostMapping("/makeAdminTrue/{cognome}/valueAdmin/{isAdmin}")
    public String makeAdmin(@PathVariable("cognome")String cognome, @PathVariable("isAdmin") boolean isAdmin,Model model){

        if(!isAdmin){
            userRepository.setUserAdminValue(true,cognome);
        } else
            userRepository.setUserAdminValue(false,cognome);

        List<Utente> lista = registerRepository.findAll();
        model.addAttribute("lista", lista);


        return "Users";
    }
}
