package com.example.demo.controllers;

import com.example.demo.model.Mezzo;
import com.example.demo.model.Prenotazione;
import com.example.demo.model.Utente;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class VehiclesController {

    @Autowired
    VehiclesRepository vehiclesRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping(value = "/Vehicles")
    public String showVehiclesDB(Model model){
        List<Mezzo> lista = vehiclesRepository.findAll();
        model.addAttribute("lista", lista);


        return "Vehicles";
}

    @GetMapping(value = "/searchVehicles")
    public String searchVehiclesForName(@RequestParam(value = "name")String nome, Model model){
        List<Mezzo> lista = Collections.singletonList(vehiclesRepository.findByModello(nome));
        model.addAttribute("lista", lista);

        return "Users";
    }

    @GetMapping(value = "/modified/{targa}")
    public String showTarga(@PathVariable("targa")String targa, Model model){

        model.addAttribute("oldTarga",targa);

        return "VehicleProfile";
    }

    @PostMapping(value = "/changeVehicleTarga/{vecchiaTarga}")
    public String changeTarga(@PathVariable("vecchiaTarga")String oldTarga,@RequestParam(value = "targa")String targa,
                            Model model){
        vehiclesRepository.setVehicleTarga(targa,oldTarga);

        List<Mezzo> lista = vehiclesRepository.findAll();
        model.addAttribute("lista", lista);

        return "Vehicles";
    }

    @PostMapping(value = "/addVehicle")
    public String addVehicle(@RequestParam(value = "modello")String modello,
                             @RequestParam(value = "casaCostr")String casaCostr,
                             @RequestParam(value = "tipologia")String tipologia,
                             @RequestParam(value = "targa")String targa,
                             @RequestParam(value = "annoImm")int annoImm,
                             Model model){

        Mezzo mezzo = new Mezzo(0,targa,modello,casaCostr,tipologia,annoImm);
        vehiclesRepository.save(mezzo);

        List<Mezzo> lista = vehiclesRepository.findAll();
        model.addAttribute("lista", lista);

        return "Vehicles";

    }

}
