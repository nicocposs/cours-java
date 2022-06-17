package com.formation;

public class Manutentionnaire extends Employe {

	private int nbHeures;
	
	public Manutentionnaire(String prenom, String nom, int age, String dateEntree, int nbHeures) {
		super(prenom, nom, age, dateEntree);
		this.nbHeures = nbHeures;
	}
	
	@Override
	public double calculerSalaire() {
		return nbHeures * 65;
	}

}
