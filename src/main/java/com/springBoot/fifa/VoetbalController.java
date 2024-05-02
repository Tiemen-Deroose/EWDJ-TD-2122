package com.springBoot.fifa;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import domain.Aankoop;
import domain.Stadium;
import domain.WedstrijdTicket;
import service.VoetbalService;
import validator.AankoopValidation;

@Controller
@SessionAttributes({"stadium","wedstrijdTicket"})
public class VoetbalController {

	@Autowired
    private VoetbalService voetbalService;
	
	@Autowired
    private AankoopValidation aankoopValidation;

    @GetMapping("/fifa")
    public String showStadiumFormPage(Model model) {
        model.addAttribute("stadiumList", voetbalService.getStadiumList());
        model.addAttribute("stadium", new Stadium());
        return "stadiumForm";
    }

    @PostMapping("/fifa")
    public String onSubmit(@ModelAttribute Stadium stadium, Model model) {
    	
    	List<WedstrijdTicket> wedstrijdList = voetbalService.getWedstrijdenByStadium(stadium.getNaam());
    	
    	if (wedstrijdList == null)
    		return "redirect:/fifa";
    	    	
    	model.addAttribute("wedstrijdList", wedstrijdList);
    	
        return "wedstrijdLijst";
    }
    
    @GetMapping("/fifa/{id}")
    public String showTicketFormPage(@PathVariable("id") Long id, Model model) {
    	
    	WedstrijdTicket wedstrijdTicket = voetbalService.getWedstrijdTicket(id);
    	
        if (wedstrijdTicket == null)
			return "redirect:/fifa";
        
        if (wedstrijdTicket.uitverkocht())
        	return "redirect:/fifa?uitverkocht";
        
        model.addAttribute("wedstrijdTicket", wedstrijdTicket);
        model.addAttribute("aankoop", new Aankoop());
        model.addAttribute("stadium", wedstrijdTicket.getStadium());
        
        return "ticketForm";
    }
    
    @PostMapping("/fifa/{id}")
    public String onSubmit(@PathVariable("id") Long id, @Valid Aankoop aankoop, BindingResult result, Model model) {   	
    	aankoopValidation.validate(aankoop, result);
    	
    	if (result.hasErrors()) {
    		return "ticketForm";
    	}
    	
    	int aantalTickets = voetbalService.bestelTickets(id, aankoop.getAantalTickets());
    	
        return String.format("redirect:/fifa?ticketsAangekocht=%s", aantalTickets);
    }
}	