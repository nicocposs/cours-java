package com.formation;

public class ProducteurAvecRisque extends Producteur {

	public ProducteurAvecRisque(String prenom, String nom, int age, String dateEntree, int nbUnites) {
		super(prenom, nom, age, dateEntree, nbUnites);
	}
	
	@Override
	public double calculerSalaire() {
		return super.calculerSalaire() + 200;
	}

}
