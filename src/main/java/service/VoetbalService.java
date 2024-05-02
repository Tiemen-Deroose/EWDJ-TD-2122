package service;

import java.util.List;

import domain.Wedstrijd;
import domain.WedstrijdTicket;

public interface VoetbalService {

	public List<String> getStadiumList();

	public List<WedstrijdTicket> getWedstrijdenByStadium(String stadium);

	public WedstrijdTicket getWedstrijdTicket(Long id);
	
	public Wedstrijd getWedstrijd(Long id);

	public int bestelTickets(Long id, int teBestellen);

}