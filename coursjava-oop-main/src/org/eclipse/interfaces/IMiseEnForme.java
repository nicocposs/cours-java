package org.eclipse.interfaces;

// Abstraction

// Les interfaces servent � cr�er des comportements g�n�riques: si plusieurs classes doivent ob�ir 
// � un comportement particulier, on cr�� une interface d�crivant ce comportement, 
// on est la fait impl�menter par les classes qui en ont besoin.
public interface IMiseEnForme {
	
	int VALUE = 5;
	// tjs des methodes abstraites
	void afficherNomMajuscule();
	void afficherPrenomMinuscule();

}

