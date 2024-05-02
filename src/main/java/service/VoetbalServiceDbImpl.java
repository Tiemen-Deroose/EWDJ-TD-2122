package service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import domain.Stadium;
import domain.Wedstrijd;
import domain.WedstrijdTicket;

public class VoetbalServiceDbImpl implements VoetbalService {
	
	@Autowired
	private WedstrijdTicketDao wedstrijdTicketDao;
	
	@Autowired
	private GenericDao<Wedstrijd> wedstrijdDao;
	
	@Autowired
	private GenericDao<Stadium> stadiumDao;
	
	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public List<String> getStadiumList() {
		return stadiumDao.findAll().stream().map(Stadium::getNaam).collect(Collectors.toList());
	}

	@Override
	public List<WedstrijdTicket> getWedstrijdenByStadium(String stadium) {
		return wedstrijdTicketDao.getWedstrijdenByStadium(stadium);
	}

	@Override
	public WedstrijdTicket getWedstrijdTicket(Long id) {
		return wedstrijdTicketDao.get(id);
	}
	
	@Override
	public Wedstrijd getWedstrijd(Long id) {
		return wedstrijdDao.get(id);
	}

	@Override
	public int bestelTickets(Long id, int teBestellen) {
		WedstrijdTicket wedstrijdTicket = wedstrijdTicketDao.get(id);
        int aantal = wedstrijdTicket.ticketsKopen(teBestellen);
        wedstrijdTicketDao.update(wedstrijdTicket);
        return aantal;
	}
}
