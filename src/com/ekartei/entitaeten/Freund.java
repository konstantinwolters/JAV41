package com.ekartei.entitaeten;
import java.util.ArrayList;

public class Freund {
	
	private String vorname;
	private String nachname;
	private String geburtsdatum;
	private Integer schluessel;
	private ArrayList<Adresse> adressen = new ArrayList<Adresse>();
	
	public Freund(String vorname, String nachname, String geburtsdatum, Integer schluessel, String strasse, String postleitzahl, String ort){
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsdatum = geburtsdatum;
		this.schluessel = schluessel;
		
		Adresse ersteAdresse = new Adresse(strasse, postleitzahl, ort);
		adressen.add(ersteAdresse);
	}
	
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public Integer getSchluessel() {
		return schluessel;
	}

	public void setSchluessel(Integer schluessel) {
		this.schluessel = schluessel;
	}
	
	public ArrayList<Adresse> getAdressen() {
		return adressen;
	}

	public void setAdressen(ArrayList<Adresse> adressen) {
		this.adressen = adressen;
	}

	public void neueAdresse (String strasse, String postleitzahl, String ort){

		Adresse neueAdresse = new Adresse(strasse, postleitzahl, ort);
		adressen.add(neueAdresse);

	}

}
