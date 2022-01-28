package com.ekartei.entitaeten;
import java.util.*;


public class Kartei {
	Integer fcounter = 0;
	ArrayList<Freund> freunde = new ArrayList<Freund>();

	
	public void anlegen() {
		
		Freund newFreund = new Freund();
		freunde.add(newFreund);
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("\nVorname: ");
		String input = scanner.nextLine();
		newFreund.setVorname(input);
		
		System.out.println("\nNachname: ");
		input = scanner.nextLine();
		newFreund.setNachname(input);
		
		System.out.println("\nGeburtsdatum:");
		input = scanner.nextLine();
		newFreund.setGeburtsdatum(input);
		
		newFreund.setID(fcounter + 1);
		
		fcounter++;

		//Abfrage der Adresse/n und Speichern in Arraylist/Freund
		ArrayList<Adresse> adressen = new ArrayList<Adresse>();
		
			while(true) {
			Adresse newAdresse = new Adresse();
			adressen.add(newAdresse);
			
			System.out.println("\nStrasse und Hausnr.: ");
			input = scanner.nextLine();
			newAdresse.setStr(input);
			
			System.out.println("\nPostleitzahl: ");
			input = scanner.nextLine();
			newAdresse.setPlz(input);
			
			System.out.println("\nOrt: ");
			input = scanner.nextLine();
			newAdresse.setOrt(input);
			
									
			System.out.println("\nSoll eine weitere Adresse angelegt werden? (j/n)");
			input = scanner.nextLine();
						
			if (input.equals("n")) {
				//Uebergebe Arraylist an aktuelles Freund-Objekt
				newFreund.setAdressen(adressen);
				break;			
			
			}
		}
		
		System.out.println("\nNutzer wurde angelegt: ID: "+newFreund.getID()+" | Name: "+newFreund.getVorname()+" "+newFreund.getNachname()+" | Geburtsdatum: "+newFreund.getGeburtsdatum());
		
	}
	
	public void aendern() {
		
		for (Freund freund : freunde) {
			System.out.println("["+freund.getID()+"] Name: "+freund.getVorname()+" "+freund.getNachname()+" | Geburtsdatum: "+freund.getGeburtsdatum());
		}
		
		System.out.println("\nWelcher Datensatz soll geaendert werden?");
		Scanner sc = new Scanner(System.in);
		
		//Pruefen, ob Auswahl ausserhalb der Arraylist liegt
		while(!sc.hasNextInt() || !(sc.nextInt() >=0 && sc.nextInt() <= freunde.size())) {
			
			System.err.println("\nBitte eine gültige ID wählen.\n");
			sc.nextLine();
			
			//Integer input = sc.nextInt();
				
		}
	
	}
	
	public void alleAnzeigen() {
		
		for (Freund freund : freunde) {
			System.out.println("____________________________________________________________________");
			System.out.println("\nID: "+freund.getID());
			System.out.println("Name: "+freund.getVorname()+" "+freund.getNachname()+" | Geburtsdatum: "+freund.getGeburtsdatum());
			System.out.println("\n  Adresse/n:\n ");
			
			for (Adresse adresse : freund.adressen) {
				System.out.println("  ["+freund.adressen.indexOf(adresse)+1+"]"+"Strasse: "+adresse.str+" | Ort: "+adresse.plz+" "+adresse.ort);
			}
			
			
		}
		
	}
	
}
