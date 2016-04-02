package de.szut.ProjectZer0.model;

	import java.sql.Date;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "WARENAUSGANG")
	public class Warenausgang {
		
		@Id
		@GeneratedValue
		@Column(name = "WARENAUSGANG_ID")
		private double warenausgangId;
		
		@Column(name = "LIEFERADRESSE")
		private String Lieferadresse;
		
		@Column(name = "BESTANDSARTIKEL")
		private String Bestandsartikel;
		
		@Column(name ="ANZAHL")
		private Integer Anzahl;
		
		@Column(name ="AUSGANGS_DATUM")
		private Date Ausgangs_Datum;
		
		public Warenausgang() {}

		public double getWarenausgangId() {
			return warenausgangId;
		}

		public void setWarenausgangId(Integer warenausgangId) {
			this.warenausgangId = warenausgangId;
		}

		public String getLieferadresse() {
			return Lieferadresse;
		}

		public void setLieferadresse(String lieferadresse) {
			Lieferadresse = lieferadresse;
		}

		public String getBestandsartikel() {
			return Bestandsartikel;
		}

		public void setBestandsartikel(String bestandsartikel) {
			Bestandsartikel = bestandsartikel;
		}

		public Integer getAnzahl() {
			return Anzahl;
		}

		public void setAnzahl(Integer anzahl) {
			Anzahl = anzahl;
		}

		public Date getAusgangs_Datum() {
			return Ausgangs_Datum;
		}

		public void setAusgangs_Datum(Date ausgangs_Datum) {
			Ausgangs_Datum = ausgangs_Datum;
		}


}
