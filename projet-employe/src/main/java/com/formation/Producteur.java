package com.formation;

public class Producteur extends Employe {

	private int nbUnites;
	
	public Producteur(String prenom, String nom, int age, String dateEntree, int nbUnites) {
		super(prenom, nom, age, dateEntree);
		this.nbUnites = nbUnites;
	}
	
	@Override
	public double calculerSalaire() {
		return nbUnites * 5;
	}

}
