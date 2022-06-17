package com.formation.cal;

public interface ICalculatrice {

	int add(int a, int b);

	int mul(int a, int b);

	int div(int a, int b);

	int sub(int a, int b);

	//est pair ???
	boolean isEven(int a);

	//est impair ???
	boolean isOdd(int a);

}