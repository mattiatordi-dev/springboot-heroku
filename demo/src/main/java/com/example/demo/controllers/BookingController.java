package com.example.demo.controllers;

import com.example.demo.model.Mezzo;
import com.example.demo.model.Prenotazione;
import com.example.demo.model.Utente;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    VehiclesRepository vehiclesRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/Books")
    public String showBooking(Model model){
        List<Prenotazione> lista = bookingRepository.findAll();

        model.addAttribute("lista", lista);

        return "Bookings";
    }


    @GetMapping("/bookVehicle/{cognome}")
    public String goToBookCar(@PathVariable("cognome")String cognome,Model model){

        model.addAttribute("cognome",cognome);

        List<Mezzo> lista = vehiclesRepository.findAll();
        model.addAttribute("lista", lista);

        return "Vehicles";
    }

    @GetMapping("/bookVehicleAtUser/{cognome}/vehicle/{targa}")
    public String bookVehicleAtUser(@PathVariable("cognome")String cognome,
                                    @PathVariable("targa")String targa,
                                    Model model){

        Mezzo mezzo = vehiclesRepository.findByTarga(targa);
        Utente utente = userRepository.findByCognome(cognome);

        Prenotazione pren = new Prenotazione(0,utente,mezzo, LocalDate.now());

        bookingRepository.save(pren);

        List<Prenotazione> lista = bookingRepository.findAll();

        model.addAttribute("lista", lista);

        return "Bookings";

    }
}
