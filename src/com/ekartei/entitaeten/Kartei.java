package com.ekartei.entitaeten;
import java.util.*;

public class Kartei {
	private Integer freundSchluessel = 0;
	private ArrayList<Freund> freunde = new ArrayList<Freund>(); //Zum Speichern der Freunde
	
		
	public void freundAnlegen(String vorname, String nachname, String geburtsdatum, String strasse, String ort, String postleitzahl) {
		
		Freund neuerFreund = new Freund(vorname, nachname, geburtsdatum, freundSchluessel, strasse, ort, postleitzahl);
		freunde.add(neuerFreund);
		freundSchluessel++;
	}

	
	public void freundAendern(Integer schluesselFreund, String vorname, String nachname, String geburtsdatum) {

		Freund freundGefunden = null;
		for (Freund freund : freunde) {
			if(freund.getSchluessel() == schluesselFreund){
				freundGefunden = freund;
			}
		}

		if(freundGefunden == null){
			System.out.println("Freund nicht gefunden.");
			return;
		}
		
		freundGefunden.setVorname(vorname);
		freundGefunden.setNachname(nachname);
		freundGefunden.setGeburtsdatum(geburtsdatum);

	}
	
	public void adresseAendern (Integer schluesselFreund, Integer indexAdresse, String strasse, String postleitzahl, String ort){

		Freund freundGefunden = null;
		for (Freund freund : freunde) {
			if(freund.getSchluessel() == schluesselFreund){
				freundGefunden = freund;
			}
		}

		if(freundGefunden == null){
			System.out.println("Freund nicht gefunden.");
			return;
		}

		if(indexAdresse < 0 || indexAdresse + 1 > freundGefunden.getAdressen().size()){
			System.out.println("Index Adresse ungueltig.");
			return;
		}

		freundGefunden.getAdressen().get(indexAdresse).setStrasse(strasse);
		freundGefunden.getAdressen().get(indexAdresse).setPostleitzahl(postleitzahl);
		freundGefunden.getAdressen().get(indexAdresse).setOrt(ort);

	}

	public void neueAdresse(Integer schluesselFreund, String strasse, String postleitzahl, String ort){
		
		Freund freundGefunden = null;
		for (Freund freund : freunde) {
			if(freund.getSchluessel() == schluesselFreund){
				freundGefunden = freund;
			}
		}

		if(freundGefunden == null){
			System.out.println("Freund nicht gefunden.");
			return;
		}

		Adresse neueAdresse = new Adresse(strasse, postleitzahl, ort);
		freundGefunden.getAdressen().add(neueAdresse);
	}

	public void freundLoeschen(Integer schluesselFreund){

		Freund freundGefunden = null;
		for (Freund freund : freunde) {
			if(freund.getSchluessel() == schluesselFreund){
				freundGefunden = freund;
			}
		}

		if(freundGefunden == null){
			System.out.println("Freund nicht gefunden.");
			return;
		}
			
		freunde.remove(freundGefunden);
	}


	public void freundSuchen(String suchwort) {
		
		ArrayList<Freund> suchergebnisse = new ArrayList<Freund>();
		
		for (Freund freund : freunde) {
			if(freund.getNachname().equalsIgnoreCase(suchwort) 
				|| freund.getVorname().equalsIgnoreCase(suchwort)
				|| freund.getSchluessel().toString().equalsIgnoreCase(suchwort) 
				|| freund.getGeburtsdatum().equalsIgnoreCase(suchwort)){
				suchergebnisse.add(freund);
			}
			
			for (Adresse adresse : freund.getAdressen()) {
				if(adresse.getOrt().equalsIgnoreCase(suchwort) 
					|| adresse.getStrasse().equalsIgnoreCase(suchwort) 
					|| adresse.getPostleitzahl().equalsIgnoreCase(suchwort)){
					suchergebnisse.add(freund);
				}
			}
		}

		if (suchergebnisse.size() == 0){
			System.out.println("Die Suche war erfolglos.");
			return;
		}

		for (Freund freund : suchergebnisse) {
			System.out.println("____________________________________________________________________");
			System.out.println("\nID: "+freund.getSchluessel()
								+" | Name: "+freund.getVorname()+" "+freund.getNachname()
								+" | Geburtsdatum: "
								+freund.getGeburtsdatum());
			System.out.println("\n  Adresse/n:\n ");
			
			for (Adresse adresse : freund.getAdressen()) {
				System.out.println("	Strasse: "+adresse.getStrasse()
									+" | Ort: "+adresse.getPostleitzahl()+" "+adresse.getOrt());
			}
		}
	}


	public void anzahlFreunde(){

		System.out.println("Anzahl Freunde: " + freunde.size());
	}


	public void adressenAusgeben() {

		for (Freund freund : freunde) {
			System.out.println("____________________________________________________________________");
			System.out.println("\nID: "+freund.getSchluessel()
								+" | Name: "+freund.getVorname()+" "+freund.getNachname()
								+" | Geburtsdatum: "+freund.getGeburtsdatum());
			System.out.println("\n  Adresse/n:\n ");
			
			for (Adresse adresse : freund.getAdressen()) {
				System.out.println("	Strasse: "+adresse.getStrasse()
									+" | Ort: "+adresse.getPostleitzahl()+" "+adresse.getOrt());
			}
		}
	}
}
