package com.ekartei;
import java.util.ArrayList;
import java.util.Scanner;
import com.ekartei.entitaeten.*;


public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Kartei kartei = new Kartei();
		Scanner sc = new Scanner(System.in);
		int input;


		Freund freund1 = new Freund();
		Freund freund2 = new Freund();
		Freund freund3 = new Freund();
		Freund freund4 = new Freund();
		Freund freund5 = new Freund();

		freund1.setNachname("Wolters");
		freund2.setNachname("Pan");
		freund3.setNachname("Mueller");
		freund4.setNachname("Kleber");
		freund5.setNachname("Kalibowski");
		
		freund1.setVorname("Konstantin");
		freund2.setVorname("Peter");
		freund3.setVorname("Barbara");
		freund4.setVorname("Klaus");
		freund5.setVorname("Werner");

		freund1.setGeburtsdatum("01.08.1986");
		freund2.setGeburtsdatum("02.08.1986");
		freund3.setGeburtsdatum("03.08.1986");
		freund4.setGeburtsdatum("04.08.1986");
		freund5.setGeburtsdatum("05.08.1986");
		
		freund1.setID(0);
		freund2.setID(1);
		freund3.setID(2);
		freund4.setID(3);
		freund5.setID(4);

		ArrayList<Adresse> adressen1 = new ArrayList<>();
		ArrayList<Adresse> adressen2 = new ArrayList<>();
		ArrayList<Adresse> adressen3 = new ArrayList<>();
		ArrayList<Adresse> adressen4 = new ArrayList<>();
		ArrayList<Adresse> adressen5 = new ArrayList<>();

		Adresse adresse1 = new Adresse();
		Adresse adresse2 = new Adresse();
		Adresse adresse3 = new Adresse();
		Adresse adresse4 = new Adresse();
		Adresse adresse5 = new Adresse();

		adresse1.setOrt("Aachen");
		adresse2.setOrt("Aachen");
		adresse3.setOrt("Aachen");
		adresse4.setOrt("Aachen");
		adresse5.setOrt("Aachen");

		adresse1.setPlz("41460");
		adresse2.setPlz("41460");
		adresse3.setPlz("52223");
		adresse4.setPlz("76234");
		adresse5.setPlz("234234");

		adresse1.setStr("Nordstrasse");
		adresse2.setStr("Nordstrasse");
		adresse3.setStr("Nordstrasse");
		adresse4.setStr("Nordstrasse");
		adresse5.setStr("Nordstrasse");

		adressen1.add(adresse1);
		adressen2.add(adresse2);
		adressen3.add(adresse3);
		adressen4.add(adresse4);
		adressen5.add(adresse5);

		freund1.setAdressen(adressen1);
		freund2.setAdressen(adressen2);
		freund3.setAdressen(adressen3);
		freund4.setAdressen(adressen4);
		freund5.setAdressen(adressen5);

		ArrayList<Freund> freunde = new ArrayList<Freund>();

		freunde.add(freund1);
		freunde.add(freund2);
		freunde.add(freund3);
		freunde.add(freund4);
		freunde.add(freund5);

		kartei.setFreunde(freunde);		
		
		while(true){	
			//Prüfung, ob Nutzerauswahl gueltig ist (1-4 & Zahl)
			System.out.print("\n\n[1] Neuen Freund anlegen \n[2] Daten aendern \n[3] Freund loeschen \n[4] Freund suchen \n[5] Alle anzeigen \n[6] Programm beenden\n\n");
			do{
				while(!sc.hasNextInt()){
					System.err.println("\nBitte eine gueltige Aktion waehlen.\n");
					sc.next();
				}
				input = sc.nextInt();
			}while(input <= 0 || input > 6);
			
			
			if (input == 1) {
				kartei.anlegen();
				
			}else if (input == 2) {
				kartei.aendern();
			
			}else if (input == 3) {
				kartei.loeschen();
			
			}else if (input == 4) {
				kartei.suchen();

			}else if (input == 5) {
				kartei.alleAnzeigen();
				
			}else if (input == 6){
				sc.close();
				System.exit(0);
			}
		}
	}
}
