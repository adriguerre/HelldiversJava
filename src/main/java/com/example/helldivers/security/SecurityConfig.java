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

    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;

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
                        .requestMatchers(HttpMethod.GET, "/planets/**").permitAll()
                        //.requestMatchers(HttpMethod.POST, "/planets/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.PUT, "/planets/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.DELETE, "/planets/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/planets/**").permitAll() //Admin
                        .requestMatchers(HttpMethod.PUT, "/planets/**").permitAll() //Admin
                        .requestMatchers(HttpMethod.DELETE, "/planets/**").permitAll() //Admin
                        .requestMatchers(HttpMethod.GET, "/helldivers/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/helldivers/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/helldivers/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/helldivers/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/accounts/register").permitAll()
                        //.requestMatchers(HttpMethod.GET, "/accounts/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/accounts/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/accounts/**").permitAll()
                        //.requestMatchers(HttpMethod.DELETE, "/accounts/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/accounts/**").permitAll() //Admin
                        .requestMatchers(HttpMethod.GET, "/weapons/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/weapons/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/weapons/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/weapons/**").permitAll()
                        //.requestMatchers(HttpMethod.POST, "/weapons/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.DELETE, "/weapons/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.PUT, "/weapons/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/armor/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/armor/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/armor/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/armor/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/stratagems/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/stratagems/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/stratagems/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/stratagems/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/missions/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/missions/**").permitAll() //Admin
                        .requestMatchers(HttpMethod.DELETE, "/missions/**").permitAll() //Admin
                        .requestMatchers(HttpMethod.PUT, "/missions/**").permitAll() //Admin
                        //.requestMatchers(HttpMethod.POST, "/missions/create").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.DELETE, "/missions/create").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.PUT, "/missions/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/mstats/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/ammo/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/ammo/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/ammo/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/ammo/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/attachments/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/attachments/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/attachments/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/attachments/**").permitAll()
                        //.requestMatchers(HttpMethod.POST, "/ammo/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.DELETE, "/ammo/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.PUT, "/ammo/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .exceptionHandling(ex -> ex
                        .accessDeniedHandler(accessDeniedHandler)
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setStatus(403);
                            response.setContentType("application/json");
                            response.getWriter().write("""
                                    {
                                      "status": 403,
                                      "error": "Forbidden",
                                      "message": "This endpoint is not permitted. Add it to SecurityConfig to allow access.",
                                      "path": "%s"
                                    }
                                    """.formatted(request.getRequestURI()));
                        })
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
