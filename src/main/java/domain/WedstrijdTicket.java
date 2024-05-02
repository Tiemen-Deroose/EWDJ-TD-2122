package domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name="WedstrijdTicket.getWedstrijdTicketsByStadium", 
       query = "SELECT wt FROM WedstrijdTicket wt"
       		+ " WHERE wt.stadium.naam = :stadium")
})
public class WedstrijdTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    private Stadium stadium;
    
	@OneToOne
    private Wedstrijd wedstrijd;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column
    private int tickets; //aantal tickets beschikbaar
	
	public WedstrijdTicket() {
    }

    public WedstrijdTicket(Wedstrijd wedstrijd, int tickets) {
        this(wedstrijd, null, tickets);
    }
    
    public WedstrijdTicket(Wedstrijd wedstrijd, Stadium stadium, int tickets) {
    	this.wedstrijd = wedstrijd;
    	this.stadium = stadium;
        this.tickets = tickets;
    }

    public Long getId() {
        return id;
    }

    public int getTickets() {
        return tickets;
    }
    
    public Wedstrijd getWedstrijd() {
        return wedstrijd;
    }
    
    public Stadium getStadium() {
        return stadium;
    }
    
    //We willen 'aantal' tickets kopen
    public int ticketsKopen(int aantal) {
        if (aantal <= 0) {
            return -1;
        }
        
        //Nog voldoende tickets
        if (tickets >= aantal) {
            tickets -= aantal;
            return aantal;
        }

        //Niet meer voldoende tickets
        int gekocht = tickets;
        tickets = 0;
        return gekocht;
    }

    public boolean uitverkocht() {
        return tickets == 0;
    }
}
