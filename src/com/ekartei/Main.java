package com.ekartei;
import java.util.Scanner;
import com.ekartei.entitaeten.*;
public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		while(true){	
			Kartei kartei = new Kartei();
			Scanner sc = new Scanner(System.in);
			int input;
				
			do{
				System.out.print("\n\n[1] Neuen Freund anlegen \n[2] Daten aendern \n[3] Freund suchen \n[4] Alle anzeigen \n\n");
				while(!sc.hasNextInt()){
					System.err.println("\nBitte eine gültige Aktion waehlenblablabla.\n");
					sc.next();
				}
				input = sc.nextInt();
			}while(input <= 0 || input > 4);
			
			
			if (input == 1) {
				
				kartei.anlegen();
				
			
			}else if (input == 2) {
				
				kartei.aendern();
			
			}else if (input == 3) {
				
				System.out.println("3 gewaehlt diggi");
				
			
			}else if (input == 4) {
				
				kartei.alleAnzeigen();
				
			}


			// Ausstiegsszenario
			String input2;
			do{
				System.out.println("\nZurueck zum Hauptmenue? (j/n)");
				while(!sc.hasNextLine()){
					System.out.println("Bitte auswaehlen.");
					sc.next();
				}
				input2 = sc.next();
			}while(!(input2.equals("j") || input2.equals("n")));
			
			if(input2.equals("n")){
				System.exit(0);
			}
		}
	}
}
