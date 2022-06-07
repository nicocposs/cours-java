package org.eclipse.main;

import org.eclipse.classes.Salle;
import org.eclipse.classes.SalleService;

public class Main {

	public static void main(String[] args) {
		SalleService salleServ = new SalleService();
		
		salleServ.create(new Salle("S1", "Salle 1"));
		salleServ.create(new Salle("S2", "Salle 2"));
		salleServ.create(new Salle("S3", "Salle 3"));
		salleServ.create(new Salle("S4", "Salle 4"));
		salleServ.create(new Salle("S5", "Salle 5"));
		
		for(Salle s : salleServ.findAll()) {
			System.out.println(s.hashCode());
			System.out.println(s);
		}
		
		
		

		salleServ.delete(new Salle("S2", "Salle 2"));		
		
		
		
		for(Salle s : salleServ.findAll()) {
			System.out.println(s.hashCode());
			System.out.println(s);
		}

	}
}
