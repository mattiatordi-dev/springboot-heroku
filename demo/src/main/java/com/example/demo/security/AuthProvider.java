package com.example.demo.security;

import com.example.demo.model.Utente;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.models.UserRoleModel;
import org.apache.catalina.UserDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class AuthProvider implements AuthenticationProvider {

    private static Logger _logger =  LogManager.getLogger(AuthProvider.class);

    @Autowired
    private SecurityUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException
    {
        Authentication retVal = null;
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (name == null || name.length() <= 0)
        {
            _logger.error("Authentication failed. User name is null or empty.");
            return retVal;
        }

        if (password == null || password.length() <= 0)
        {
            _logger.error("Authentication failed. User password is null or empty.");
            return retVal;
        }

        Utente authenticatedUser = this.authenticateUser(name);
        _logger.info("UserDetail creato:  " + authenticatedUser);

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        if(!authenticatedUser.isRuolo_admin()) {
            UserDetails user = new User(authenticatedUser.getCognome(), authenticatedUser.getPassword(), authorities);

            //

            if (password.equals(user.getPassword())) {
                authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else return retVal;

            _logger.info("Utente autenticato:  " + authentication);


            return authentication;
        }
        return null;
    }

    private Utente authenticateUser(String userName)
    {
        Utente user = (Utente) userDetailsService.loadUserByUsername(userName);
        if (user != null)
        {
                _logger.debug("Authentication Successful.");
                return user;
            }
        return null;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }











}
