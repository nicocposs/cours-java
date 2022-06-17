package com.formation;

public class CalculatriceScientifique implements ICalculatrice {

	
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
	
	
	public double racine(int a) {		
		return Math.sqrt(a);
	}	
}
