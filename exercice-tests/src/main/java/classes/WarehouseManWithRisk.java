package classes;

public class WarehouseManWithRisk extends WarehouseMan {
	
	public WarehouseManWithRisk(String nom, String prenom, int age, String anneeEntree, double heuresEffectuees) {
		super(nom, prenom, age, anneeEntree);
		calculerSalaire(heuresEffectuees);
	}
	
	@Override
	public void calculerSalaire(double val) {
		this.salaire = val*65+200;
		
	}
}
