package com.example.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.beans.Encoder;

@Configuration
public class SystemConfig extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        PasswordEncoder encoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User.UserBuilder userBuilder=User.builder().passwordEncoder(encoder::encode);
        UserDetails user1= userBuilder.username("Kanhaiyasisteccs@gmail.com").password("Kanhaiya").roles("User").build();
        UserDetails user2= userBuilder.username("Rockstarkanhai@gmail.com").password("Kanhaiya").roles("User","Admin").build();
        return new InMemoryUserDetailsManager(user1,user2);

    }
}
