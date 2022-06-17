package classes;

public class WarehouseMan extends Employee {

	public WarehouseMan(String nom, String prenom, int age, String anneeEntree, double heuresEffectuees) {
		super(nom, prenom, age, anneeEntree);
		calculerSalaire(heuresEffectuees);
	}
	
	public WarehouseMan(String nom, String prenom, int age, String anneeEntree) {
		super(nom, prenom, age, anneeEntree);
	}

	@Override
	public void calculerSalaire(double val) {
		this.salaire = val*65;
		
	}

}
