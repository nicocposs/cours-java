package org.eclipse.main;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.classes.*;

public class Main {

	public static void main(String[] args) {
		Adresse adr1 = new Adresse();
		adr1.setVille("Mazingarbe");
		adr1.setCodePostal("62290");
		adr1.setRue("31 résidence schaffner");
		
		System.out.println(adr1);
		
		adr1.setCodePostal("62670");
		
		System.out.println(adr1);
		
		
		
		Adresse adr2 = new Adresse("17 rue du nouveau fort", "Lillers", "62140");
		
		System.out.println(adr2);
		
		adr2.setVille("Divion");
		
		System.out.println(adr2);
		
		
		
		Chercheur ch1 = new Chercheur();
		ch1.setNom("Grard");
		ch1.setNumOrdinateur(12);
		ch1.setPoste("AR1");
		
		Chercheur ch2 = new Chercheur("Gérard","AR2");
		
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println("Nombre de chercheurs : "+Chercheur.getNbr());
		
		
		
		ch1.setNumOrdinateur(15);
		
		
		
		
		Chercheur ch3 = new Chercheur();
		ch3.setNom("Garcia");
		ch3.setNumOrdinateur(8);
		ch3.setPoste("AR3");
		
		
		
		Bureau bur1 = new Bureau("BUR12", "Bureau 1", new ArrayList<Chercheur>());
		Bureau bur2 = new Bureau("BUR13", "Bureau 2", new ArrayList<Chercheur>());
		
		Chercheur ch4 = new Chercheur("Chercheur4","TR1",2);
		Chercheur ch5 = new Chercheur("Chercheur5","TR2",3);
		Chercheur ch6 = new Chercheur("Chercheur6","TR3",4);
		
		bur1.addChercheur(ch1);
		bur1.addChercheur(ch2);
		bur1.addChercheur(ch3);
		
		bur2.addChercheur(ch4);
		bur2.addChercheur(ch5);
		bur2.addChercheur(ch6);
		
		
		
		
		Laboratoire lab1 = new Laboratoire("Laboratoire 1", "Pharmacologie", adr1, new ArrayList<Bureau>());
		
		lab1.addBureau(bur1);
		lab1.addBureau(bur2);
		
		System.out.println(lab1);
	}

}
