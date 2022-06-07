package org.eclipse.interfaces;

// Abstraction

// Les interfaces servent à créer des comportements génériques: si plusieurs classes doivent obéir 
// à un comportement particulier, on créé une interface décrivant ce comportement, 
// on est la fait implémenter par les classes qui en ont besoin.
public interface IMiseEnForme {
	
	int VALUE = 5;
	// tjs des methodes abstraites
	void afficherNomMajuscule();
	void afficherPrenomMinuscule();

}

