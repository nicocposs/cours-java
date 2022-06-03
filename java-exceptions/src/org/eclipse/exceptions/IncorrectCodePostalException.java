package org.eclipse.exceptions;

public class IncorrectCodePostalException extends Exception{
	
	public IncorrectCodePostalException() {
		System.out.println("Le code postal ne peut pas dépasser 5 chiffres");
	}
	
}
