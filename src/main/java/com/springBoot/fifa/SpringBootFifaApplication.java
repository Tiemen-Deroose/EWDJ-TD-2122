package com.springBoot.fifa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import domain.Stadium;
import domain.Wedstrijd;
import service.GenericDao;
import service.GenericDaoJpa;
import service.VoetbalService;
import service.VoetbalServiceDbImpl;
import service.WedstrijdTicketDao;
import service.WedstrijdTicketDaoJpa;
import validator.AankoopValidation;

@SpringBootApplication
public class SpringBootFifaApplication implements WebMvcConfigurer  {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFifaApplication.class, args);
	}
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
    }

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/403").setViewName("403");
		registry.addViewController("/login").setViewName("login");
	}
	
	@Bean
	public VoetbalService voetbalService() {
		return new VoetbalServiceDbImpl();
	}
	
	@Bean
	public AankoopValidation aankoopValidation() {
		return new AankoopValidation();
	}
	
	@Bean
	public GenericDao<Stadium> stadiumDao() {
		return new GenericDaoJpa<Stadium>(Stadium.class);
	}
	
	@Bean
	public WedstrijdTicketDao wedstrijdTicketDao() {
		return new WedstrijdTicketDaoJpa();
	}
	
	@Bean
	public GenericDao<Wedstrijd> wedstrijdDao() {
		return new GenericDaoJpa<Wedstrijd>(Wedstrijd.class);
	}

}
