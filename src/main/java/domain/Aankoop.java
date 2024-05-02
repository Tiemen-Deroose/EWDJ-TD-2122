package domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Aankoop {
	
	@NotEmpty
	@Pattern(regexp = ".*@.*", message="{validation.Reservatie.email.Pattern.message}")
	private String email;
	
	@NotNull
	@Min(value = 1, message="{validation.Reservatie.aantalTickets.Min.message}")
	@Max(value = 25, message="{validation.Reservatie.aantalTickets.Max.message}")
	private Integer aantalTickets;
	
	@NotNull
	private Integer voetbalCode1;
	
	@NotNull
	private Integer voetbalCode2;
	
	public Aankoop() {
		setAantalTickets(1);
		setVoetbalCode1(10);
		setVoetbalCode2(20);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAantalTickets() {
		return aantalTickets;
	}
	public void setAantalTickets(Integer aantalTickets) {
		this.aantalTickets = aantalTickets;
	}
	public Integer getVoetbalCode1() {
		return voetbalCode1;
	}
	public void setVoetbalCode1(Integer voetbalCode1) {
		this.voetbalCode1 = voetbalCode1;
	}
	public Integer getVoetbalCode2() {
		return voetbalCode2;
	}
	public void setVoetbalCode2(Integer voetbalCode2) {
		this.voetbalCode2 = voetbalCode2;
	}
	
}
