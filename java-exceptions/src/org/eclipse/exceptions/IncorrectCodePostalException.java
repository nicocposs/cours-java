package org.eclipse.exceptions;

public class IncorrectCodePostalException extends Exception{
	
	public IncorrectCodePostalException() {
		System.out.println("Le code postal ne peut pas d�passer 5 chiffres");
	}
	
}
