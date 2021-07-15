package com.example.demo.security;

import com.example.demo.model.Utente;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String cognome)
            throws UsernameNotFoundException {
        Utente utente = userRepository.findUserByCognome(cognome)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non presente"));
        return utente;

/*
        List<Utente> lista = userRepository.findAll();
        Utente utenteVal = null;

        if(!StringUtils.isEmpty(cognome)){
            if(lista != null && lista.size() > 0){
                utenteVal = lista.stream().filter(utente -> utente.getCognome().equalsIgnoreCase(cognome))
                        .collect(Collectors.toList()).get(0);
            }
        }

 */

    }
}