package main;

import classes.Producer;
import classes.ProducerWithRisk;
import classes.Representant;
import classes.Salesman;
import classes.Staff;
import classes.WarehouseMan;
import classes.WarehouseManWithRisk;

public class Main {

	public static void main(String[] args) {
		final Staff myEmployees = new Staff();
	    myEmployees.add(new Salesman("Pierre", "Business", 45, "1995", 30000d));
	    myEmployees.add(new Representant("Léon", "Ventout", 25, "2001", 20000d));
	    myEmployees.add(new Producer("Yves", "Ahalouest", 28, "1998", 1000));
	    myEmployees.add(new WarehouseMan("Jeanne", "Stoktout", 32, "1998", 45));
	    myEmployees.add(new ProducerWithRisk("Jean", "Flippe", 28, "2000", 1000));
	    myEmployees.add(new WarehouseManWithRisk("Al", "Abordage", 30, "2001", 45));
	    
	    myEmployees.displaySalaries();
	    myEmployees.displayAverageSalary();
	}

}
