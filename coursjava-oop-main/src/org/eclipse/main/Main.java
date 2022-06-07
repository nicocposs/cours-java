package org.eclipse.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.eclipse.classes.*;
import org.eclipse.classes.exos.Filiere;
import org.eclipse.enums.Sport;
import org.eclipse.exceptions.IncorrectCodePostalException;

public class Main {
	// throws ca permet de dire que ici la methode va renvoyer une exception
	public static void main(String[] args) {

		System.out.println("-----------------------------EXCEPTION-----------------------------");

		int x = 5, y = 0;
		try {
			System.out.println(x / y);
		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
		System.out.println("Fin de calcul");

		System.out.println("-----------------------------OBJ-----------------------------");

		// Deux methodes pour creer un objet ou une instance de classe
		Personne p1 = new Personne("Doe", "Pat", Sport.BASKET);

		// En passant par les Setters
//		p1.setId(1);
//		p1.setNom("Wick");
//		p1.setPrenom("John");

		System.out.println(p1);

		System.out.println(p1.getNom());

		System.out.println(Personne.getNbrPersonnes());

		// En passant par le constructeur
		Personne p2 = new Personne("Doe", "Pat", Sport.TENNIS);
		System.out.println(p2.getPrenom());

		System.out.println(Personne.getNbrPersonnes());

		Personne p3 = new Personne("Wayne", "Bruce", Sport.CROSS_FIT);
		System.out.println(p3);

		System.out.println(Personne.getNbrPersonnes());

		try {
			
			Adresse a1 = new Adresse("Forge Stellaire", 01111 , "Coruscant");

			Personne p4 = new Personne("Darth", "Revan", a1);
			System.out.println(p4);

			Enseignant ens1 = new Enseignant("Darth", "Sidious", a1, 0.0f);

			Personne ens2 = new Enseignant("Darth", "Maul", a1, 0.0f);

			System.out.println("----------------------------------------------------------");
			ens1.afficherNomMajuscule();
			ens1.afficherPrenomMinuscule();
			System.out.println("----------------------------------------------------------");

			System.out.println(ens1);

			Etudiant etu1 = new Etudiant("Darth", "Vador", a1, "Full Ultime");

			Etudiant etu2 = new Etudiant("Darth", "Revan", a1, "Full Ultime");

			System.out.println("----------------------------------------------------------");
			etu1.afficherNomMajuscule(); // Doit afficher en minuscule (redefinition ds classe enfant)
			etu2.afficherPrenomMinuscule();
			System.out.println("----------------------------------------------------------");

			System.out.println(etu1);

			System.out.println("-----------------------------EXOS-----------------------------");

			// Creer deux objets de type Etudiant et deux objets de type
			// Enseignant et stocker les tous dans un seul tableau.
			// 2 Parcourir le tableau et afficher pour chacun soit le salaire soit le
			// niveau

			Personne[] personnes = { ens1, ens2, etu1, etu2 };

			for (Personne perso : personnes) {
				if (perso instanceof Enseignant) {
					System.out.println(((Enseignant) perso).getSalaire());
				} else {
					System.out.println(((Etudiant) perso).getNiveau());
				}
			}

			// Avec une collection (dynamique)

			// List<Personne> pList = new ArrayList<Personne>();
			// pList.add(ens1);
			// pList.add(etu1);

			List<Personne> pList = Arrays.asList(ens1, ens2, etu1, etu2);

			pList.forEach((perso) -> System.out.println(perso));

		} catch (IncorrectCodePostalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int res1 = maximum(4, 6);

		System.out.println(res1);

		String res2 = repetitionMot("Allez", 6);

		System.out.println(res2);

		int res3 = entierAleatoire(4, 6);
		int res32 = entierAleatoire2(4, 6);

		System.out.println(res3);
		System.out.println(res32);

		int[] numbers = { 1, 2, 3 };
		boolean res4 = contains(numbers, 3);

		System.out.println(res4);

		System.out.println("---------------------------------ABSTRACT-------------------------");

		Admin ad1 = new Admin("Joe", "L'Admin");
		ad1.afficherNomComplet();

		SuperAdmin sAd1 = new SuperAdmin("Paco", "LeSuperAdmin");
		sAd1.afficherNomComplet();

		System.out.println("---------------------------------ASSOCIATION-------------------------");

		Filiere[] filieres = new Filiere[3];
		filieres[0] = new Filiere("Info 2", "Informatique");
		filieres[1] = new Filiere("TIC", "Techno de l'info et de communication");
		filieres[2] = new Filiere("GC", "Genie Civil");

		org.eclipse.classes.exos.Etudiant[] etudiants = new org.eclipse.classes.exos.Etudiant[5];
		etudiants[0] = new org.eclipse.classes.exos.Etudiant("Jean", "Pat", "12-12-1986", filieres[1]);
		etudiants[1] = new org.eclipse.classes.exos.Etudiant("Jul", "Dre", "11-08-1994", filieres[2]);
		etudiants[2] = new org.eclipse.classes.exos.Etudiant("Dom", "minique", "13-03-1997", filieres[0]);
		etudiants[3] = new org.eclipse.classes.exos.Etudiant("Pat", "Pot", "05-11-1984", filieres[2]);
		etudiants[4] = new org.eclipse.classes.exos.Etudiant("Aya", "YAr", "23-06-1983", filieres[1]);

		for (Filiere filiere : filieres) {
			System.out.println(filiere);
		}

	}

	// double vitesse (double temps, double distance)

	// boolean trianglePossible(double c1,double c2, double c3)

	// int PGCD(int n1,int n2)

	// void initiales(String prenom, String nom)

	public static int maximum(int n1, int n2) {
		if (n1 > n2)
			return n1;
		return n2;
	}

	public static String repetitionMot(String mot, int nbRepetitions) {
		String motRepete = " ";
		for (int i = 1; i <= nbRepetitions; i++) {
			motRepete += mot;
		}
		return motRepete;
	}

	public static int entierAleatoire(int inf, int sup) {
		return (int) (Math.random() * (sup - inf) + inf);
	}

	public static int entierAleatoire2(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	public static boolean contains(int[] arr, int item) {
		for (int n : arr) {
			if (item == n) {
				return true;
			}
		}
		return false;
	}
}
