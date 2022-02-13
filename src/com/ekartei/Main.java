package com.ekartei;
import com.ekartei.entitaeten.*;


public class Main {
	
	public static void main(String[] args) {
		Kartei kartei = new Kartei();

		kartei.freundAnlegen("Konstantin", "Wolters", "01.08.1986", "Bockholtstr. 54", "41460", "Neuss");
		kartei.freundAnlegen("Gundula", "Gause", "23.03.1965", "Weberstr. 36a", "52078", "Aachen");
		kartei.freundAnlegen("Klaus", "Kleber", "13.07.1964", "Kirchgasse 108", "40210", "Duesseldorf");
		kartei.freundAnlegen("Mulatta", "Peter",  "06.12.1976", "Marktplatz 1", "Regensburg", "93059");
		kartei.freundAnlegen("Oliver", "Mueller", "30.11.1989", "Zollamtstr. 38", "44145", "Dortmund");

		
		kartei.freundLoeschen(3);
		kartei.freundAendern(4, "Peter", "Mulatta", "06.12.1976");
		kartei.adresseAendern(4, 0, "Marktplatz 1", "93059", "Regensburg");
		kartei.neueAdresse(4, "Bürotrakt 1a", "93059", "Regensburg");

		kartei.adressenAusgeben();


	}
}
