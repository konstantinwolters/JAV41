package com.ekartei.entitaeten;

import java.util.ArrayList;

public class Freund {
	
	String vorname;
	String nachname;
	String geburtsdatum;
	Integer id;
	ArrayList<Adresse> adressen;
	
	
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

	
	public Integer getID() {
		return id;
	}

	public void setID(Integer id) {
		this.id = id;
	}
	
	
	public ArrayList<Adresse> getAdressen() {
		return adressen;
	}

	public void setAdressen(ArrayList<Adresse> adressen) {
		this.adressen = adressen;
	}


}
