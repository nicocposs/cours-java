package com.formation;

public class Representant extends Employe {

	private double ca;
	
	public Representant(String prenom, String nom, int age, String dateEntree, double ca) {
		super(prenom, nom, age, dateEntree);
		this.ca = ca;
	}
	
	@Override
	public double calculerSalaire() {
		return ca * 0.2 + 800;
	}

}
