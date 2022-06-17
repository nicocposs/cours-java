package com.formation;

import java.util.ArrayList;
import java.util.List;

public class CalculatriceNormale implements ICalculatrice {

	
	@Override
	public int add(int a, int b) {		
		return a+b;
	}
	
	@Override
	public int mul(int a, int b) {		
		return a*b;
	}
	
	@Override
	public int div(int a, int b) {		
		return a/b;
	}
	
	@Override
	public int sub(int a, int b) {		
		return a-b;
	}
	
	//est pair ???
	@Override
	public boolean isEven(int a) {
		return a % 2 == 0;
	}
	
	//est impair ???
	@Override
	public boolean isOdd(int a) {
		return !isEven(a);
	}
	
	
	public static void codeAOptimiser() {
		int[] tab1 = {
				1, 2, 3, 4, 5, 6
		};
		int[] tab2 = {
				1, 4, 3, 7, 5, 8
		};
		
		//1ère implémentation
		List<Integer> lindices = new ArrayList<>();
		List<Integer> lvalues = new ArrayList<>();
		for(int i = 0; i < tab1.length; i++) {
			if(tab1[i] == tab2[i]) {
				lindices.add(i);
				lvalues.add(tab1[i]);
			}			
		}
		
		//2ème implémentation
		boolean[] tabEquality = new boolean[tab1.length];
		for(int i = 0; i < tab1.length; i++) {
			tabEquality[i] = tab1[i] == tab2[i];
		}
		
		
	}
	
}
