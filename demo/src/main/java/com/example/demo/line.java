package com.example.demo;

import com.example.demo.model.Prenotazione;
import com.example.demo.model.Utente;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.RegisterRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehiclesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class line implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(line.class);

@Autowired
UserRepository userRepository;

@Autowired
BookingRepository bookingRepository;


    @Override
    public void run(String... args) throws Exception {



        }

        }



