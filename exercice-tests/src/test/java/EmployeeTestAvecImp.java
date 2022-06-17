import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import classes.Producer;
import classes.ProducerWithRisk;
import classes.Representant;
import classes.Salesman;
import classes.Staff;
import classes.WarehouseMan;
import classes.WarehouseManWithRisk;

public class EmployeeTestAvecImp {
	private Staff myEmployees;
	
	
	@Before
	public void impl() {
		
	    
		myEmployees = new Staff();
		
		myEmployees.add(new Salesman("Pierre", "Business", 45, "1995", 30000d));
	    myEmployees.add(new Representant("Léon", "Ventout", 25, "2001", 20000d));
	    myEmployees.add(new Producer("Yves", "Ahalouest", 28, "1998", 1000));
	    myEmployees.add(new WarehouseMan("Jeanne", "Stoktout", 32, "1998", 45));
	    myEmployees.add(new ProducerWithRisk("Jean", "Flippe", 28, "2000", 1000));
	    myEmployees.add(new WarehouseManWithRisk("Al", "Abordage", 30, "2001", 45));
	}
	
	@After
	public void deleting() {
		myEmployees = null;
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCalculSalaire() {
		assertEquals("Salaire de Pierre Business égal à 6400", 6400d, myEmployees.get(0).getSalaire(),0.1);
		assertEquals("Salaire de Pierre Business égal à 4800", 4800d, myEmployees.get(1).getSalaire(),0.1);
		assertEquals("Salaire de Pierre Business égal à 5000", 5000d, myEmployees.get(2).getSalaire(),0.1);
		assertEquals("Salaire de Pierre Business égal à 2925", 2925d, myEmployees.get(3).getSalaire(),0.1);
		assertEquals("Salaire de Pierre Business égal à 5200", 5200d, myEmployees.get(4).getSalaire(),0.1);
		assertEquals("Salaire de Pierre Business égal à 3125", 3125d, myEmployees.get(5).getSalaire(),0.1);
	}

}
