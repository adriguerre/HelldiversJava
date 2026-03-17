package com.example.helldivers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //TODO: Cambiar cuando tengamos el JWT
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/accounts/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/planets").permitAll()
                        .requestMatchers(HttpMethod.GET, "/helldivers").permitAll()
                        .requestMatchers(HttpMethod.POST, "/accounts/register").permitAll()
                        .requestMatchers(HttpMethod.GET, "/accounts/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/accounts/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/weapons/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/armor/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
