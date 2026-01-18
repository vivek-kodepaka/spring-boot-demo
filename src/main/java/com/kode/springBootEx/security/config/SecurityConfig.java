package com.kode.springBootEx.security.config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Qualifier("myUserDetailsService")
    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

        security.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->
                          auth.requestMatchers("/test").hasRole("TEST")
                                  .requestMatchers("/customExp").hasRole("EXP")
                                  .requestMatchers("/info").hasAnyRole("TEST","EXP")
                                  .requestMatchers("register").permitAll()
                                  .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return security.build();
    }

    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return authenticationProvider;
    }

  /* @Bean
    public InMemoryUserDetailsManager userdetails(){

        UserDetails userDetails = User.withUsername("kode").roles("TEST").password("{noop}kode").build();
       UserDetails userDetails1 = User.withUsername("kode1").roles("EXP").password("{noop}kode1").build();
        return new InMemoryUserDetailsManager(userDetails,userDetails1);
    }*/
}
