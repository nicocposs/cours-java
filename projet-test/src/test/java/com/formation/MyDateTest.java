package com.formation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class MyDateTest {

	private MyDate d;
	
	@Before
	public void setup() {
        d = new MyDate(31, 12, 2006);		
	}
	/**
     * Test method for {@link MyDate#getDay()}.
     */	
	@Test
    public void testGetDay() {
        assertEquals(31, d.getDay());
    }

    /**
     * Test method for {@link MyDate#getMonth()}.
     */
	@Test
    public void testGetMonth() {
        assertEquals(12, d.getMonth());
    }

    /**
     * Test method for {@link MyDate#getYear()}.
     */
	@Test
    public void testGetYear() {
        assertEquals(2006, d.getYear());
    }

    /**
     * Test method for {@link MyDate#isValidDate()} .
     */
	@Test
    public void testisValidDate() {
		assertTrue("20 juin 1988 est valide", MyDate.isValidDate(20, 6, 1988));
		assertTrue("28 juin 1988 est valide", MyDate.isValidDate(28, 6, 1988));
		assertTrue("09 avril 1992 est valide", MyDate.isValidDate(9, 4, 1992));
		assertFalse("31 juin 1988 est valide", MyDate.isValidDate(31, 6, 1988));
		assertFalse("32 juin 1988 est valide", MyDate.isValidDate(32, 6, 1988));
		assertFalse("-1 juin 1988 est valide", MyDate.isValidDate(-1, 6, 1988));
	}

    /**
     * Test simple valid dates
     */
	@Test
    public void testSimpleValidDates() {
        boolean b = MyDate.isValidDate(1, 1, 2000);
        assertTrue(b);
        b = MyDate.isValidDate(25, 12, 2000);
        assertTrue(b);
    }

    /**
     * Test simple invalid dates
     */
	@Test
    public void testSimpleInvalidDates() {
        boolean b = MyDate.isValidDate(0, 1, 2000);
        assertFalse("0 est invalide pour le jour", b);
        b = MyDate.isValidDate(32, 12, 2000);
        assertFalse(b);
    }

    /**
     * Test valid limit dates
     */
	@Test
    public void testValidLimitDates() {
        boolean b = MyDate.isValidDate(31, 1, 2000);
        assertTrue("31 janvier est une date valide", b);
    }

    /**
     * Test invalid limit dates
     */
	@Test
    public void testInvalidLimitDates() {
        boolean b = MyDate.isValidDate(31, 4, 2000);
        assertFalse("31 avril est une date invalide", b);
    }

    /**
     * Test February valid limit dates
     */
	@Test
    public void testFebruaryValidLimitDates() {
        boolean b = MyDate.isValidDate(29, 2, 2000);
        assertTrue("29 février 2000 est une date valide", b);
    }

    /**
     * Test February invalid limit dates
     */
	@Test
    public void testFebruaryInvalidLimitDates() {
        boolean b = MyDate.isValidDate(29, 2, 2001);
        assertFalse("29 février 2001 est une date invalide", b);
    }

	
    /**
     * Test method for {@link MyDate#nextDay()}.
     */
	@Test
    public void testNextDay() {
        //d = MyDate(31, 12, 2006);
		d = d.nextDay();
		assertEquals("Changement d'année", 2007, d.getYear());
		assertEquals("Changement de mois", 1, d.getMonth());
		assertEquals("Changement de jour", 1, d.getDay());
		
		d = new MyDate(30, 6, 2006);
		d = d.nextDay();
		assertEquals("Pas de changement d'année", 2006, d.getYear());
		assertEquals("Changement de mois", 7, d.getMonth());
		assertEquals("Changement de jour", 1, d.getDay());
		

		d = new MyDate(15, 2, 2006);
		d = d.nextDay();
		assertEquals("Pas de changement d'année", 2006, d.getYear());
		assertEquals("Pas de changement de mois", 2, d.getMonth());
		assertEquals("Changement de jour", 16, d.getDay());
		/*
		d = new MyDate(15, 2, 2006);
		MyDate d1 = new MyDate(15, 2, 2006);
		MyDate d2 = d;
		//d.equals(d1) ==> true (assertEquals)
		//d == d1 ==> false (assertSame)
		//d.equals(d2) ==> true
		//d == d2 ==> true
		*/		 
    }
	
}