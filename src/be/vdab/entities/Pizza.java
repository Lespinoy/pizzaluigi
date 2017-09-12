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
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	
	public static boolean validName(String naam){
		return (naam != null && !naam.isEmpty());
	}
	
	public void setNaam(String naam) throws Exception {
		if (validName(naam)){
			this.naam = naam;
		} else throw new IllegalArgumentException();
	}
	public BigDecimal getPrijs() {
		return prijs;
	}
	
	private static boolean validPrice(BigDecimal prijs){
		return(prijs != null && prijs.compareTo(BigDecimal.ZERO) >= 0);
	}
	public void setPrijs(BigDecimal prijs) throws Exception {
		if (validPrice(prijs)){
			this.prijs = prijs;
		} else throw new IllegalArgumentException();
	}
	public boolean isPikant() {
		return pikant;
	}
	public void setPikant(boolean pikant) {
		this.pikant = pikant;
	}
	
	
	
}
