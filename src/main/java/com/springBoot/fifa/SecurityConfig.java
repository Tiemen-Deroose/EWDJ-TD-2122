package com.springBoot.fifa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    DataSource dataSource;
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	http.authorizeRequests()
		        .antMatchers("/*").hasRole("USER")
		        .antMatchers("/fifa/*").hasRole("ADMIN")
		        .antMatchers("/fifaDetail/*").permitAll() //maak rest service altijd beschikbaar
		        .and()
		        .csrf();

        http.formLogin()
        		.defaultSuccessUrl("/fifa", true)
        		.loginPage("/login").permitAll()
        		.and()
                .exceptionHandling().accessDeniedPage("/403") //bij onvoldoende bevoegdheid, stuur naar 403 page
                .and()
                .csrf();        
        
        http.logout().permitAll(); // sta logout requests altijd toe
        
    }
}