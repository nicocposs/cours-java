package org.eclipse.main;

import org.eclipse.interfaces.Calcul;
import org.eclipse.interfaces.Vehicule;

public class Main {

	public static void main(String[] args) {
		
//		Vehicule v1 = new Vehicule() {
//			@Override
//			public void rouler() {
//				System.out.println("v1 roule !");
//			}
//		};
//		
//		v1.rouler();
//		
//		Vehicule v2 = new Vehicule() {		
//			@Override
//			public void rouler() {
//				System.out.println("v2 roule !");			
//			}
//		};
//		
//		v2.rouler();
		
		// L'expression Lambda est particulièrement utile lorsque le traitement n'est utile
		// qu'une seule fois : elle évite d'avoir à écrire une méthode dans une classe.
		
		Vehicule v3 = (type) -> System.out.println(type);
		
		v3.rouler("v3 roule !");
		
		Calcul addition = (x, y) -> x + y;
		
		// en Java 8 on peut passer des varaibles qui referencent des fonctions 
		// et les passer en tant que parametre
		System.out.println("8 + 2 = " + calculer(8, 2, addition));
		
		Calcul soustraction = (x, y) -> x - y;
		System.out.println("8 - 2 = " + calculer(8, 2, soustraction));
		
		Calcul multiplication = (x, y) -> {
			return x * y;
		};		
		System.out.println("8 * 2 = " + calculer(8, 2, multiplication));

		Calcul division = (x, y) -> x / y;
		System.out.println("8 / 2 = " + calculer(8, 2, division));
	}
	
	private static int calculer(int x, int y, Calcul operation) {
		return operation.calc(x, y);
	}

}