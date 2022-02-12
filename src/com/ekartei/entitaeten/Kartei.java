package com.ekartei.entitaeten;
import java.util.*;

public class Kartei {
	Integer freundCounter = 0;
	private ArrayList<Freund> freunde = new ArrayList<Freund>(); //Zum Speichern der Freunde
	
	public void setFreunde (ArrayList<Freund> freunde){
		this.freunde = freunde;
	}
	
	public void anlegen() {
		
		Freund neuerFreund = new Freund();
		freunde.add(neuerFreund);
		
		Scanner sc = new Scanner(System.in);

		System.out.println("\nVorname: ");
		String input = sc.nextLine();
		neuerFreund.setVorname(input);
		
		System.out.println("\nNachname: ");
		input = sc.nextLine();
		neuerFreund.setNachname(input);
		
		System.out.println("\nGeburtsdatum:");
		input = sc.nextLine();
		neuerFreund.setGeburtsdatum(input);
		
		neuerFreund.setID(freundCounter + 1);
		
		freundCounter++;

		//Abfrage der Adresse/n und Speichern in Arraylist pro Freund
		ArrayList<Adresse> adressen = new ArrayList<Adresse>();
		
		while(true) {
			Adresse neueAdresse = new Adresse();
			adressen.add(neueAdresse);
			
			System.out.println("\nStrasse und Hausnr.: ");
			input = sc.nextLine();
			neueAdresse.setStr(input);
			
			System.out.println("\nPostleitzahl: ");
			input = sc.nextLine();
			neueAdresse.setPlz(input);
			
			System.out.println("\nOrt: ");
			input = sc.nextLine();
			neueAdresse.setOrt(input);
			
			//Abfrage, ob weitere Adresse angelegt werden soll									
			input = sc.nextLine();
			while( !input.equalsIgnoreCase("j") && !input.equalsIgnoreCase("n") ){
				System.out.println("\nSoll eine weitere Adresse angelegt werden? (j/n)");
				input = sc.nextLine();
			}

			if (input.equals("n")) {
				neuerFreund.setAdressen(adressen);
				break;			
			}
		}
		
		System.out.println("\nNutzer wurde angelegt: ID: "+neuerFreund.getID()
							+" | Name: "+neuerFreund.getVorname()+" "+neuerFreund.getNachname()
							+" | Geburtsdatum: "+neuerFreund.getGeburtsdatum());
	}

	
	public void aendern() {
		int auswahlDatensatz;
		int auswahlMenueAendern;
		int auswahlAdresse;
		String neuerEintrag;
		Freund freundAendern;

		Scanner sc = new Scanner(System.in);

		for (Freund freund : freunde) {
			System.out.println("["+freunde.indexOf(freund)
								+"] Name: "+freund.getVorname()+" "+freund.getNachname()
								+" | Geburtsdatum: "+freund.getGeburtsdatum());
		}
		
		System.out.println("\nWelcher Datensatz soll geaendert werden?");

		//Pruefung, ob Eingabe Integer ist und ob innerhalb der Arraylist liegt
		do{
			while(!sc.hasNextInt()){
				System.err.println("\nBitte eine gueltigen Datensatz waehlen.");
				sc.next();
			}
			auswahlDatensatz = sc.nextInt();
		}while(auswahlDatensatz < 0 || auswahlDatensatz > freunde.size()-1);

		freundAendern = freunde.get(auswahlDatensatz);
		
		while(true){
			
			System.out.println("\n[1] Vornamen aendern2"+
								"\n[2] Nachnamen aendern"+
								"\n[3] Geburtsdatum aendern"+
								"\n[4] Adresse aendern"+
								"\n[5] Adresse hinzufuegen"+
								"\n[6] zurueck zum Hauptmenue");
			
			//Pruefung, ob Eingabe Integer ist und ob innerhalb der Arraylist liegt
			do{
				while(!sc.hasNextInt()){
					System.err.println("\nBitte eine gueltige Aktion waehlen.");
					sc.next();
				}
				auswahlMenueAendern = sc.nextInt();
			}while(auswahlMenueAendern <= 0 || auswahlMenueAendern > 6);

			if(auswahlMenueAendern == 1){
				System.out.println("\nNeuer Vorname:");
				neuerEintrag = sc.next();
				freundAendern.setVorname(neuerEintrag);

			}else if(auswahlMenueAendern == 2){
				System.out.println("\nNeuer Nachname:");
				neuerEintrag = sc.next();
				freundAendern.setNachname(neuerEintrag);
				
			}else if(auswahlMenueAendern == 3){
				System.out.println("\nNeues Geburtsdatum:");
				neuerEintrag = sc.next();
				freundAendern.setGeburtsdatum(neuerEintrag);

			}else if(auswahlMenueAendern == 4){
				for (Adresse adresse : freundAendern.adressen) {
					System.err.println("["+freundAendern.adressen.indexOf(adresse)+"] "+adresse.str+" "+adresse.plz+" "+adresse.ort);
				}

				System.out.println("\nWelche Adresse soll geaendert werden?");

				//Pruefung, ob Eingabe Integer ist und ob innerhalb der Arraylist liegt
				do{
					while(!sc.hasNextInt()){
						System.err.println("\nBitte eine gueltige Adresse waehlen.");
						sc.nextInt();
					}
					auswahlAdresse = sc.nextInt();
				}while(auswahlAdresse < 0 || auswahlAdresse > freundAendern.adressen.size()-1);

					System.out.println("\nNeue Strasse und Hausnr.:");
					sc.nextLine();
					neuerEintrag = sc.nextLine();
					freundAendern.adressen.get(auswahlAdresse).setStr(neuerEintrag);

					System.out.println("\nNeue Postleitzahl:");
					neuerEintrag = sc.nextLine();
					freundAendern.adressen.get(auswahlAdresse).setPlz(neuerEintrag);

					System.out.println("\nNeuer Ort:");
					neuerEintrag = sc.nextLine();
					freundAendern.adressen.get(auswahlAdresse).setOrt(neuerEintrag);

			}else if(auswahlMenueAendern == 5){
				Adresse neueAdresse = new Adresse();
				freundAendern.adressen.add(neueAdresse);
				
				System.out.println("\nStrasse und Hausnr.: ");
				sc.nextLine();
				neuerEintrag = sc.nextLine();
				neueAdresse.setStr(neuerEintrag);
				
				System.out.println("\nPostleitzahl: ");
				neuerEintrag = sc.nextLine();
				neueAdresse.setPlz(neuerEintrag);
				
				System.out.println("\nOrt: ");
				neuerEintrag = sc.nextLine();
				neueAdresse.setOrt(neuerEintrag);
			}else if(auswahlMenueAendern == 6){
				break;
			}
		}	
	}
	

	public void loeschen(){

		int auswahlDatensatz;
		Scanner sc = new Scanner(System.in);

		for (Freund freund : freunde) {
			System.out.println("["+freunde.indexOf(freund)
								+"] Name: "+freund.getVorname()+" "+freund.getNachname()
								+" | Geburtsdatum: "+freund.getGeburtsdatum());
		}

		System.out.println("\nWelcher Datensatz soll geloescht werden?");

		//Pruefen, ob Auswahl ausserhalb der Arraylist liegt
		do{
			while(!sc.hasNextInt()){
				System.err.println("\nBitte eine gueltigen Datensatz waehlen.");
				sc.next();
			}
			auswahlDatensatz = sc.nextInt();
		}while(auswahlDatensatz < 0 || auswahlDatensatz > freunde.size()-1);

		freunde.remove(auswahlDatensatz);
	}


	public void suchen() {
		String suchwort;
		ArrayList<Freund> suchergebnisse = new ArrayList<Freund>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nSuche:");
		suchwort = sc.next();

		for (Freund freund : freunde) {
			if(freund.nachname.equalsIgnoreCase(suchwort) 
				|| freund.vorname.equalsIgnoreCase(suchwort)
				||freund.id.toString().equalsIgnoreCase(suchwort) 
				|| freund.geburtsdatum.equalsIgnoreCase(suchwort)){
				suchergebnisse.add(freund);
			}
			
			for (Adresse adresse : freund.adressen) {
				if(adresse.ort.equalsIgnoreCase(suchwort) 
					|| adresse.str.equalsIgnoreCase(suchwort) 
					|| adresse.plz.equalsIgnoreCase(suchwort)){
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
			System.out.println("\nID: "+freund.getID());
			System.out.println("Name: "+freund.getVorname()+" "
								+freund.getNachname()
								+" | Geburtsdatum: "
								+freund.getGeburtsdatum());
			System.out.println("\n  Adresse/n:\n ");
			
			for (Adresse adresse : freund.adressen) {
				System.out.println("  ["+freund.adressen.indexOf(adresse)+1+"]"
									+"Strasse: "+adresse.str
									+" | Ort: "+adresse.plz+" "+adresse.ort);
			}
		}
	}


	public void alleAnzeigen() {

		System.out.println("\nAnzahl Freunde: "+freunde.size());

		for (Freund freund : freunde) {
			System.out.println("____________________________________________________________________");
			System.out.println("\nID: "+freund.getID());
			System.out.println("Name: "+freund.getVorname()+" "+freund.getNachname()
								+" | Geburtsdatum: "+freund.getGeburtsdatum());
			System.out.println("\n  Adresse/n:\n ");
			
			for (Adresse adresse : freund.adressen) {
				System.out.println("  ["+freund.adressen.indexOf(adresse)+1+"]"
									+"Strasse: "+adresse.str+" | Ort: "+adresse.plz+" "+adresse.ort);
			}
		}
	}
}
