package io.github.swarnaka.userauthservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for development purposes
            .authorizeRequests(authz -> authz
                .antMatchers("/auth/login").permitAll() // Allow all requests to /auth/login
                .anyRequest().authenticated()) // All other requests should be authenticated
            .httpBasic(withDefaults()); // You can use basic auth for other secured endpoints
        return http.build();
    }
}
