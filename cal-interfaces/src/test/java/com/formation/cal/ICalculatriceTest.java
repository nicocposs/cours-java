package com.formation.cal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

//Suite de tests
public class ICalculatriceTest {

	private ICalculatrice c;
	
	@BeforeClass
	public static void avantPremierTest() {
		//Création des tables
	}
	
	@AfterClass
	public static void apresDernierTest() {
		//Suppression des tables
	}
	
	
	@Before
	public void avantChaqueTest() {
		//Ajout des enregistrements dans les tables
		c = Mockito.mock(ICalculatrice.class);
	}
	
	@After
	public void apresChaqueTest() {
		//Suppression des enregistrements dans les tables
		c = null;
	}
	
	@Test
	//Cas de test
	public void testAddition() {
		Mockito.when(c.add(5, 6)).thenReturn(11);
		
		int valeurAttendue = 11;
		int aInput = 5;
		int bInput = 6;
		
		int valeurObtenue = c.add(aInput, bInput);
		
		Assert.assertEquals("Test de l'addition", valeurAttendue, valeurObtenue);
		
	}

}
