

package com.formation.cal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//Suite de tests
public class UtilisateurCalculatriceAvecImpTest {

	private UtilisateurCalculatrice user;
	
	@Before
	public void avantChaqueTest() {
		//Ajout des enregistrements dans les tables
		ICalculatrice cal = new CalculatriceNormale();		
		user = new UtilisateurCalculatrice(cal);
	}
	
	@After
	public void apresChaqueTest() {
		//Suppression des enregistrements dans les tables
		user = null;
	}
	
	@Test
	//Cas de test
	public void testTVA() {
		int valeurAttendue = 120;
		int valeurObtenue = user.calculerPrixTVA(100);
		Assert.assertEquals("Test de l'addition", valeurAttendue, valeurObtenue);
		
	}
	
	@Test(expected=ArithmeticException.class)
	//Cas de test
	public void testDivision() {
		user.calculerDivision(100, 0);
	}
}

