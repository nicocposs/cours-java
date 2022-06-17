package com.formation;

public class ManutentionnaireAvecRisque extends Manutentionnaire {
	
	public ManutentionnaireAvecRisque(String prenom, String nom, int age, String dateEntree, int nbHeures) {
		super(prenom, nom, age, dateEntree, nbHeures);
	}
	
	@Override
	public double calculerSalaire() {
		return super.calculerSalaire() + 200;
	}

}
