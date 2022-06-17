package classes;

public class Producer extends Employee {

	public Producer(String nom, String prenom, int age, String anneeEntree, double nombreEntites) {
		super(nom, prenom, age, anneeEntree);
		calculerSalaire(nombreEntites);
	}
	
	public Producer(String nom, String prenom, int age, String anneeEntree) {
		super(nom, prenom, age, anneeEntree);
	}

	@Override
	public void calculerSalaire(double val) {
		this.salaire = val*5;
		
	}

}
