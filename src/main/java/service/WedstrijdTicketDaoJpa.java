package service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.WedstrijdTicket;

@Repository("wedstrijdTicketDao")
public class WedstrijdTicketDaoJpa extends GenericDaoJpa<WedstrijdTicket> implements WedstrijdTicketDao {
	
	public WedstrijdTicketDaoJpa() {
		super(WedstrijdTicket.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<WedstrijdTicket> getWedstrijdenByStadium(String stadium) {
		TypedQuery<WedstrijdTicket> query = em.createNamedQuery("WedstrijdTicket.getWedstrijdTicketsByStadium", WedstrijdTicket.class);
        query.setParameter("stadium", stadium);
        return query.getResultList();
	}
}
