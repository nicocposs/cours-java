

package com.formation.cal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

//Suite de tests
public class UtilisateurCalculatriceAvecMockitoTest {

	private UtilisateurCalculatrice user;
	
	@Before
	public void avantChaqueTest() {
		//Ajout des enregistrements dans les tables
		ICalculatrice cal = Mockito.mock(ICalculatrice.class);
		Mockito.when(cal.mul(100, 20)).thenReturn(2000);
		Mockito.when(cal.div(2000, 100)).thenReturn(20);
		Mockito.when(cal.add(100, 20)).thenReturn(120);
		Mockito.when(cal.div(100, 0)).thenThrow(ArithmeticException.class);
		Mockito.when(cal.div(100, 5)).thenReturn(20);
		user = new UtilisateurCalculatrice(cal);

		//CalculatriceNormale cal2 = Mockito.spy(CalculatriceNormale.class);
		//Mockito.when(cal2.mul(100, 20)).thenReturn(2000);		
	
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
		Assert.assertEquals("Test calculerPrixTVA", valeurAttendue, valeurObtenue);	
	}
	
	@Test(expected=ArithmeticException.class)
	//Cas de test
	public void testDivision() {
		user.calculerDivision(100, 0);
	}
	
	
	@Test
	//Cas de test
	public void testDivision2() {
		int valeurAttendue = 20;
		int valeurObtenue = user.calculerDivision(100, 5);
		Assert.assertEquals("Test calculerDivision", valeurAttendue, valeurObtenue);	
	}
}

