package com.example.APIGateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        //Definicion de usuario como David y contraseña
        UserDetails david = User.withUsername("david")
                .password(passwordEncoder().encode("7803"))
                //Se asigna el rol de admin al usuario
                .roles("ADMIN")
                .build();
        //Definicion de otro usuario
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("1234"))
                //Se asigna el rol de usuario normal
                .roles("USER")
                .build();

        //Devuelve una instancia de MapReactiveUserDetailsService con los usuarios definidos
        return new MapReactiveUserDetailsService(david, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                //Deshabilita la protección CSRF
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchange -> exchange
                        //Permite el acceso sin autenticación a rutas de autenticación y monitoreo
                        .pathMatchers("/auth/**", "/actuator/**").permitAll()
                        //Restringe el acceso a las rutas de hoteles, vuelos y reservas solo a ADMIN
                        .pathMatchers("/hoteles/**", "/vuelos/**", "/reservas/**").hasRole("ADMIN")
                        .anyExchange().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
                .build();
    }
}
