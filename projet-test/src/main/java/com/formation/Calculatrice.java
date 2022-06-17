package com.formation;

public class Calculatrice {

	
	public int add(int a, int b) {		
		return a+b;
	}
	
	public int mul(int a, int b) {		
		return a*b;
	}
	
	public int div(int a, int b) {		
		return a/b;
	}
	
	public int sub(int a, int b) {		
		return a-b;
	}
	
	//est pair ???
	public boolean isEven(int a) {
		return a % 2 == 0;
	}
	
	//est impair ???
	public boolean isOdd(int a) {
		return !isEven(a);
	}
}
