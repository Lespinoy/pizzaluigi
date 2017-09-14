package be.vdab.entities;

import java.math.BigDecimal;

public class Pizza {
	private long id;
	private String naam;
	private BigDecimal prijs;
	private boolean pikant;
	
	public Pizza(String naam, BigDecimal prijs, boolean pikant) throws Exception {
		setNaam(naam);
		setPrijs(prijs);
		setPikant(pikant);
	}
	
	public Pizza(long id, String naam, BigDecimal prijs, boolean pikant) throws Exception {
		this(naam, prijs, pikant);
		setId(id);
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setPikant(boolean pikant) {
		this.pikant = pikant;
	}
	
	public void setNaam(String naam) throws Exception {
		if (isNaamValid(naam)){
			this.naam = naam;
		} else throw new IllegalArgumentException();
	}
	
	public void setPrijs(BigDecimal prijs) throws Exception {
		if (isPrijsValid(prijs)){
			this.prijs = prijs;
		} else throw new IllegalArgumentException();
	}
		
	private static boolean isPrijsValid(BigDecimal prijs){
		return(prijs != null && prijs.compareTo(BigDecimal.ZERO) >= 0);
	}
		
	public static boolean isNaamValid(String naam){
		return (naam != null && !naam.isEmpty());
	}
	
	public boolean isPikant() {
		return pikant;
	}
	
	public long getId() {
		return id;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public BigDecimal getPrijs() {
		return prijs;
	}
	
}
