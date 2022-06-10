package org.eclipse.main;

import java.util.Arrays;
import java.util.List;

import org.eclipse.interfaces.ConstructInterface;
import org.eclipse.interfaces.IMethodReference;

public class Dummy {
	int valeur = 1;
	
	public static void main(String args[]) {
		List<Integer> entiers = Arrays.asList(5,10,9,6,7);
		
		entiers.forEach(System.out::println);
		
		// Equivalent : IMethodReference Imr = () -> System.out.println("Message quelconque");
		IMethodReference Imr = new Dummy()::maMethode;
		
		
		Imr.affiche();
		

		
		ConstructInterface ci = String::new;
		
		char[] chars = {'a','b','c'};
		
		System.out.println(ci.generer(chars));
		
		
		
		
		
		Dummy test = new Dummy();
		test.maMethode2();
	}
	
	public void maMethode() {
		System.out.println("Message quelconque");
	}
	
	public void maMethode2() {
		IMethodReference imr2 = () -> {
			int valeur = 2;
			System.out.println(this.valeur);
		};
		
		imr2.affiche();
	}

}
