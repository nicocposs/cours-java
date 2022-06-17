package com.formation.cal;

public class UtilisateurCalculatrice {
	
	private ICalculatrice cal;
	
	public UtilisateurCalculatrice(ICalculatrice cal) {
		this.cal = cal;
	}
	
	public int calculerPrixTVA(int prixHT) {
		return cal.add(prixHT, cal.div(cal.mul(prixHT, 20), 100));
	}
	
	public int calculerDivision(int a, int b) {
		return cal.div(a, b);
	}
}
