package com.example.Mezzi.Securite;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigurationSecuriteApplication {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Désactiver CSRF si non nécessaire pour cette configuration
            .authorizeHttpRequests(authorize -> 
                authorize.requestMatchers("/activation").permitAll()
                         .anyRequest().authenticated()
            );
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return(new BCryptPasswordEncoder());
    }
}
