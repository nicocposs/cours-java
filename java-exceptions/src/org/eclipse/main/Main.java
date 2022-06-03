package org.eclipse.main;

import org.eclipse.classes.Adresse;
import org.eclipse.exceptions.IncorrectCodePostalException;

public class Main {

	public static void main(String[] args) throws IncorrectCodePostalException{
		int x = 5, y = 0;
		
		try{
			System.out.println(x/y);
		}catch(ArithmeticException e) {
			System.err.println("Division par zero");
		}
		System.out.println("Fin de calcul");

	

		try {
			Adresse ad1 = new Adresse("31 résidence schaffner","Mazingarbe","626705");
			Adresse ad2 = new Adresse("31 résidence schaffner","Mazingarbe","62670");
			System.out.println(ad1 + " " + ad2);
		}catch(IncorrectCodePostalException e) {
			System.err.println(e.getLocalizedMessage());
		}
		
		
	}
}
