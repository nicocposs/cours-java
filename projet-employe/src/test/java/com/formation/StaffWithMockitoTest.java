package com.formation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class StaffWithMockitoTest {

	private Staff staff;
	
	@Before
	public void setup() {
		staff = new Staff();		
	}
	
	@Test
	public void testAverageSalary() {
		
		Intervenant inter1 = Mockito.mock(Intervenant.class);
		/*
		Intervenant inter1 = new Intervant() {
		 	@Override
		 	double calculerSalaire() { return 0; }
		 }
		*/
		
		Mockito.when(inter1.calculerSalaire()).thenReturn(1000.0);
		/*
		Intervenant inter1 = new Intervant() {
		 	@Override
		 	double calculerSalaire() { return 1000.0; }
		 }
		*/		
		
		staff.add(inter1);
		Intervenant inter2 = Mockito.mock(Intervenant.class);
		Mockito.when(inter2.calculerSalaire()).thenReturn(2000.0);
		staff.add(inter2);
		Intervenant inter3 = Mockito.mock(Intervenant.class);
		Mockito.when(inter3.calculerSalaire()).thenReturn(3000.0);
		staff.add(inter3);
		
		double valeurAttendue = 2000.0;
		double valeurObtenue = staff.calculerAverageSalary();
		Assert.assertEquals("Test calculerAverageSalary", valeurAttendue, valeurObtenue, 0.0001);	
	}
	
	@Test
	public void testAverageSalary2() {
		
		Employe inter1 = Mockito.mock(Employe.class);
		/*
		Employe inter1 = new Employe() {
		 	@Override
		 	double calculerSalaire() { return 0; }
		 	@Override
		 	String getPrenom() { return null; }
		 }
		*/
		
		Mockito.when(inter1.calculerSalaire()).thenReturn(1000.0);
		/*
		Employe inter1 = new Employe() {
		 	@Override
		 	double calculerSalaire() { return 1000.0; }
		 	@Override
		 	String getPrenom() { return null; }
		 }
		*/

		
		staff.add(inter1);
		Employe inter2 = Mockito.mock(Employe.class);
		Mockito.when(inter2.calculerSalaire()).thenReturn(2000.0);
		staff.add(inter2);
		Employe inter3 = Mockito.mock(Employe.class);
		Mockito.when(inter3.calculerSalaire()).thenReturn(3000.0);
		staff.add(inter3);
		
		double valeurAttendue = 2000.0;
		double valeurObtenue = staff.calculerAverageSalary();
		Assert.assertEquals("Test calculerAverageSalary", valeurAttendue, valeurObtenue, 0.0001);	
	}
	
	@Test
	public void testAverageSalary3() {
		
		Employe inter1 = Mockito.mock(Employe.class);
		Mockito.when(inter1.calculerSalaire()).thenReturn(1000.0);
		staff.add(inter1);
		Employe inter2 = Mockito.mock(Employe.class);
		Mockito.when(inter2.calculerSalaire()).thenReturn(2000.0);
		staff.add(inter2);
		Employe inter3 = Mockito.mock(Employe.class);
		Mockito.when(inter3.calculerSalaire()).thenReturn(3000.0);
		staff.add(inter3);
		
		double valeurAttendue = 2000.0;
		double valeurObtenue = staff.calculerAverageSalary();
		Assert.assertEquals("Test calculerAverageSalary", valeurAttendue, valeurObtenue, 0.0001);	
	}
	
	@Test
	public void testAverageSalary4() {
		
		Employe inter1 = Mockito.mock(Employe.class);
		Mockito.when(inter1.calculerSalaire()).thenReturn(1000.0);
		/*
		Employe inter1 = new Employe() {
		 	@Override
		 	double calculerSalaire() { return 1000.0; }
		 	
		 	//Il met à null car Mockito fait un mock --> rend la classe inerte
		 	@Override
		 	String getPrenom() { return null; }
		 }
		*/
		staff.add(inter1);
		Employe inter2 = Mockito.spy(Employe.class);
		Mockito.when(inter2.calculerSalaire()).thenReturn(2000.0);
		/*
		Employe inter2 = new Employe() {
		 	@Override
		 	double calculerSalaire() { return 2000.0; }
		 	//Il réutilise getPrenom car Mockito fait un spy, garde les méthodes implémentées
		 }
		*/

		
		staff.add(inter2);
		Employe inter3 = Mockito.spy(Employe.class);
		Mockito.when(inter3.calculerSalaire()).thenReturn(3000.0);
		staff.add(inter3);
		
		Assert.assertNull("Test getPrenom avec mock", inter1.getPrenom());	
		Assert.assertEquals("Test getPrenom avec spy", "DEFAULT", inter2.getPrenom());	
		
		double valeurAttendue = 2000.0;
		double valeurObtenue = staff.calculerAverageSalary();
		Assert.assertEquals("Test calculerAverageSalary", valeurAttendue, valeurObtenue, 0.0001);	
	}
	
	
	@Test
	public void testAverageSalary5() {
		
		staff.add(new Vendeur("Pierre", "Business", 45, "1995", 30000));
		staff.add(new Representant("Léon", "Ventout", 25, "2001", 20000));
		staff.add(new Producteur("Yves", "Ahalouest", 28, "1998", 1000));
		staff.add(new Manutentionnaire("Jeanne", "Stoktout", 32, "1998", 45));
		staff.add(new ProducteurAvecRisque("Jean", "Flippe", 28, "2000", 1000));
		staff.add(new ManutentionnaireAvecRisque("Al", "Abordage", 30, "2001", 45));
		
		double valeurAttendue = 4575.0;
		double valeurObtenue = staff.calculerAverageSalary();
		Assert.assertEquals("Test calculerAverageSalary", valeurAttendue, valeurObtenue, 0.0001);	
	}
	
}
