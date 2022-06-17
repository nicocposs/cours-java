package com.formation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//Suite de tests
public class CalculatriceTest {

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
		c = new CalculatriceNormale();
	}
	
	@After
	public void apresChaqueTest() {
		//Suppression des enregistrements dans les tables
		c = null;
	}
	
	@Test
	//Cas de test
	public void testAddition() {
		int valeurAttendue = 11;
		int aInput = 5;
		int bInput = 6;
		
		int valeurObtenue = c.add(aInput, bInput);
		
		Assert.assertEquals("Test de l'addition", valeurAttendue, valeurObtenue);
		
	}
	
	
	@Test
	public void testAdditionFactorise() {
		
		int[] valeursAttendues = {
				11,
				10,
				-2
		};
		
		int[] aInput = {
				5,
				6,
				3
		};
		int[] bInput = {
				6,
				4,
				-5
		};
		
		for(int i = 0; i < valeursAttendues.length; i++) {
			int valeurObtenue = c.add(aInput[i], bInput[i]);			
			Assert.assertEquals("Test de l'addition", valeursAttendues[i], valeurObtenue);			
		}				
	}
	
	
	@Test
	public void testAdditionFactorise2() {
		
		List<Integer> valeursAttendues = Arrays.asList(
				11,
				10,
				-2
		);
		
		List<Map<String, Integer>> inputs = new ArrayList<>();
		inputs.add(new HashMap<String, Integer>() {{
			put("a", 5);
			put("b", 6);		
		}});
		inputs.add(new HashMap<String, Integer>() {{
			put("a", 6);
			put("b", 4);		
		}});
		inputs.add(new HashMap<String, Integer>() {{
			put("a", 3);
			put("b", -5);		
		}});
		
		for(int i = 0; i < valeursAttendues.size(); i++) {
			Integer valeurObtenue = c.add(inputs.get(i).get("a"), inputs.get(i).get("b"));			
			Assert.assertEquals("Test de l'addition", valeursAttendues.get(i), valeurObtenue);			
		}				
	}

	@Test
	public void testSoustraction() {
		
		int valeurAttendue = -1;
		int aInput = 5;
		int bInput = 6;
		
		int valeurObtenue = c.sub(aInput, bInput);
		
		Assert.assertEquals("Test de la soustraction", valeurAttendue, valeurObtenue);
		
	}
	
	@Test
	public void testMultiplication() {
		
		int valeurAttendue = 30;
		int aInput = 5;
		int bInput = 6;
		
		int valeurObtenue = c.mul(aInput, bInput);
		
		Assert.assertEquals("Test de la multiplication", valeurAttendue, valeurObtenue);
		
	}
	
	@Test
	public void testDivision() {
		
		int valeurAttendue = 5;
		int aInput = 10;
		int bInput = 2;
		
		int valeurObtenue = c.div(aInput, bInput);
		
		Assert.assertEquals("Test de la division", valeurAttendue, valeurObtenue);
		
	}

	
	@Test(expected=ArithmeticException.class)
	public void testDivision2() {
		
		int aInput = 10;
		int bInput = 0;
		c.div(aInput, bInput);		
	}
	
	
	@Test
	public void testParite() {		
		int a1 = 10;		
		int a2 = 5;		
		Assert.assertTrue("Test de la parité", c.isEven(a1));
		Assert.assertFalse("Test de la parité", c.isEven(a2));

		Assert.assertFalse("Test de la parité", c.isOdd(a1));
		Assert.assertTrue("Test de la parité", c.isOdd(a2));
				
	}

}
