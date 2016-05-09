package de.szut.ProjectZer0.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Integer Kapazit�t; 
	
	@Column(name ="AUSLASTUNG")
	private Integer Auslastung;
	
	@ManyToMany(mappedBy="Lager")
	private Bestandsartikel Bestandsartikel;
	
	@OneToMany(mappedBy="Lager")
	private Set<Mitarbeiter> Mitarbeiter;
	
	
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

	public Integer getKapazit�t() {
		return Kapazit�t;
	}

	public void setKapazit�t(Integer integer) {
		Kapazit�t = integer;
	}

	public Integer getAuslastung() {
		return Auslastung;
	}

	public void setAuslastung(Integer auslastung) {
		Auslastung = auslastung;
	}

	public Bestandsartikel getBestandsartikel() {
		return Bestandsartikel;
	}

	public void setBestandsartikel(Bestandsartikel bestandsartikel) {
		Bestandsartikel = bestandsartikel;
	}

	public Set<Mitarbeiter> getMitarbeiter() {
		return Mitarbeiter;
	}

	public void setMitarbeiter(Set<Mitarbeiter> mitarbeiter) {
		Mitarbeiter = mitarbeiter;
	}

}
