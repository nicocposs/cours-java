package org.eclipse.exceptions;

public class IncorrectCodePostalException extends Exception {

	public IncorrectCodePostalException() {
		System.out.println("Le code postal doit contenir exactement 5 chiffres !");
	}

}
