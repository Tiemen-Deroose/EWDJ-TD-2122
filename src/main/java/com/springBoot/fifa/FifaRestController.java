package com.springBoot.fifa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import domain.Wedstrijd;
import service.VoetbalService;

@RestController
@RequestMapping(value = "/fifaDetail")
public class FifaRestController {
	
	@Autowired
	VoetbalService voetbalService;
	
	@GetMapping(value = "/{id}") 
    public String[] getWedstrijdLanden(@PathVariable("id") long id) {
		Wedstrijd wedstrijd = voetbalService.getWedstrijd(id);
		
		if (wedstrijd == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
        return wedstrijd.getLanden();
    }
}
