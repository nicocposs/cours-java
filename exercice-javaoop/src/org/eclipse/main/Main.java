package org.eclipse.main;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.classes.Etudiant;
import org.eclipse.classes.Filiere;

public class Main {

	public static void main(String[] args) {
		Filiere fil1 = new Filiere("TS","Terminale S");
		Filiere fil2 = new Filiere("TL","Terminale L");

		Etudiant etu1 = new Etudiant("NomA","PrenomA",fil1);
		Etudiant etu2 = new Etudiant("NomB","PrenomB",fil1);
		Etudiant etu3 = new Etudiant("NomC","PrenomC",fil1);
		Etudiant etu4 = new Etudiant("NomD","PrenomD",fil2);
		Etudiant etu5 = new Etudiant("NomE","PrenomE",fil2);
		
		
		List<Etudiant> etus = new ArrayList<Etudiant>();
		etus.add(etu1);
		etus.add(etu2);
		etus.add(etu3);
		etus.add(etu4);
		etus.add(etu5);
		
		String TS = "Terminale S :\n";
		String TL = "Terminale L :\n";
		for(Etudiant e : etus) {
			if(e.getFiliere().getCode() == "TS") {
				TS += e + "\n";
			}else {
				TL += e + "\n";
			}
		}
		
		System.out.println(TS);
		System.out.println(TL);
		
	}

}
