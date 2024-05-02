package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Een wedstrijd
@Entity
public class Wedstrijd implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String landA;
    
    @Column
    private String landB;
    
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime datum;

    public Wedstrijd() {
    }
    
    public Wedstrijd(String[] landen, int dag, int uur) {
    	this(landen, LocalDate.now().getYear(), LocalDate.now().getMonth().getValue(), dag, uur, 0);
    }
    
    public Wedstrijd(String[] landen, int jaar, int maand, int dag, int uur, int minuut) {
        this.landA = landen[0];
        this.landB = landen[1];
        
        this.datum = LocalDateTime.of(jaar, maand, dag, uur, minuut);
    }
    
    public Long getId() {
        return id;
    }

    public String[] getLanden() {
        return new String[]{landA, landB};
    }
    
    public String getLandenAsString() {
    	return Arrays.asList(getLanden()).stream().collect(Collectors.joining("-"));
    }
    
	public LocalDateTime getDatum() {
		return datum;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s vs %s op %d-%d", landA, landB, datum.getDayOfMonth(), datum.getMonthValue()); 
    }
}
