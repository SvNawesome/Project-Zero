package de.szut.ProjectZer0.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LAGER")
public class Lager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LAGER_ID")
	private int LagerID;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "ORT")
	private String Ort;
	
	@Column(name = "KAPAZIT�T")
	private int Kapazit�t; 
	
	@Column(name ="AUSLASTUNG")
	private int Auslastung;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "lagerZuweisung",cascade = CascadeType.ALL)
	private Set<Mitarbeiter> mitarbeiter;
	
	public Set<Mitarbeiter> getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(Set<Mitarbeiter> mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public Lager() {}

	public int getLagerID() {
		return LagerID;
	}

	public void setLagerID(int lagerID) {
		LagerID = lagerID;
	}

	public String getName(){
		return name;
	}
	
	public void setName(String Name){
		name = Name;
	}
	
	public String getOrt() {
		return Ort;
	}

	public void setOrt(String ort) {
		Ort = ort;
	}

	public int getKapazit�t() {
		return Kapazit�t;
	}

	public void setKapazit�t(Integer integer) {
		Kapazit�t = integer;
	}

	public int getAuslastung() {
		return Auslastung;
	}

	public void setAuslastung(Integer auslastung) {
		Auslastung = auslastung;
	}



}
