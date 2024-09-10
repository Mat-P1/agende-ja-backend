package br.edu.unifametro.aluno.agendeja.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.POST, "/users/sign-up").permitAll()
        );

        // use HTTP Basic Authentication
        http.httpBasic(Customizer.withDefaults());

        // Disable Cross Site Request Forgery (CSRF)
        // Generally not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}