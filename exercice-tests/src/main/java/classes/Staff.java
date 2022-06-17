package classes;

import java.util.ArrayList;
import java.util.List;

public class Staff {
	private List<Employee> employes;
	
	
	
	public Staff() {
		employes = new ArrayList<Employee>();
	}

	public void add(Employee e) {
		this.employes.add(e);
	}
	
	public void displaySalaries() {
		System.out.println("Liste des salaires des employes :");
		for(Employee e : employes) {
			System.out.println(e);
		}
	}
	
	public void displayAverageSalary() {
		double valeurMoyenne = 0d;
		
		for(Employee e : employes) {
			valeurMoyenne += e.salaire;
		}
		
		valeurMoyenne /= employes.size();
		
		System.out.println("Valeur du salaire moyen : " + valeurMoyenne + "€");
	}
	
	public Employee get(int i) {
		return employes.get(i);
	}
}
