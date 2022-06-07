package org.eclipse.classes;

import org.eclipse.enums.Sport;

public class Etudiant extends Personne {

	private String niveau;

	public Etudiant() {
	}

	public Etudiant(String nom, String prenom, Sport sport, String niveau) {
		super(nom, prenom, sport);
		this.niveau = niveau;
	}


	public Etudiant(String nom, String prenom, Adresse adresse, String niveau) {
		super(nom, prenom, adresse);
		this.niveau = niveau;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return super.toString() + "Etudiant [niveau=" + niveau + "]";
	}
	
	// Polymorphysme : cela veut dire simplement qu'une classe peut prendre
	// plusieurs formes (Principe d'heritage)
	// Redefinition
	@Override
	public void afficherNomMajuscule() {
		System.out.println(super.getNom().toLowerCase());
	}
	
	// Impossible de redefinir la methode car final ds la classe mere
//	@Override
//	public void afficherNomComplet(String nom, String prenom) {
//		System.out.println(nom.toUpperCase() + " " + prenom.toUpperCase());
//	}

}
