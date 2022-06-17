package com.formation;

import org.joda.time.LocalDate;

public class Main {
	public static void main(final String[] args) {
		
		final Staff myEmployees = new Staff();
		
		myEmployees.add(new Vendeur("Pierre", "Business", 45, "1995", 30000));
		myEmployees.add(new Representant("Léon", "Ventout", 25, "2001", 20000));
		myEmployees.add(new Producteur("Yves", "Ahalouest", 28, "1998", 1000));
		myEmployees.add(new Manutentionnaire("Jeanne", "Stoktout", 32, "1998", 45));
		myEmployees.add(new ProducteurAvecRisque("Jean", "Flippe", 28, "2000", 1000));
		myEmployees.add(new ManutentionnaireAvecRisque("Al", "Abordage", 30, "2001", 45));

		myEmployees.displaySalaries();
		myEmployees.displayAverageSalary();
		
		
		LocalDate d = new LocalDate(1997, 12, 18);
		
		System.out.println(d.getDayOfMonth());
	}
}
