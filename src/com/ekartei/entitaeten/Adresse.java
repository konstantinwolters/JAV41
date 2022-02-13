package com.ekartei.entitaeten;

public class Adresse {
	private String strasse;
	private String ort;
	private String postleitzahl;
	
	public Adresse (String strasse, String postleitzahl, String ort){
		this.strasse = strasse;
		this. postleitzahl = postleitzahl;
		this.ort = ort;
	}
	
	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
	this.strasse = strasse;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPostleitzahl() {
		return postleitzahl;
	}

	public void setPostleitzahl(String postleitzahl) {
		this.postleitzahl = postleitzahl;
	}

	
}
