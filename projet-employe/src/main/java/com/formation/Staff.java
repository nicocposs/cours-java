package com.formation;

import java.util.ArrayList;
import java.util.List;

public class Staff {

	List<Intervenant> listIntervenants = new ArrayList<>();
	
	public void add(Intervenant interv) {
		listIntervenants.add(interv);
	}
	
	
	public void displaySalaries() {
		for(Intervenant interv : listIntervenants) {
			System.out.println(
					interv.getPrenom() 
					+ " " 
					+ interv.getNom() 
					+ " a un salaire de " 
					+ interv.calculerSalaire() 
					+ " €");			
		}
	}
	
	public void displayAverageSalary() {		
		System.out.println("Valeur du salaire moyen : " + calculerAverageSalary() + " €");
	}
	
	public double calculerAverageSalary() {
		double sum = 0;
		for(Intervenant interv : listIntervenants) {
			sum += interv.calculerSalaire();
		}
		return sum/listIntervenants.size();
	}
}
