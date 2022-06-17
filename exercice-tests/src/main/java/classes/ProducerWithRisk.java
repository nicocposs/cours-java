package classes;

public class ProducerWithRisk extends Producer {

	public ProducerWithRisk(String nom, String prenom, int age, String anneeEntree, double nombreEntites) {
		super(nom, prenom, age, anneeEntree);
		calculerSalaire(nombreEntites);
	}
	
	@Override
	public void calculerSalaire(double val) {
		this.salaire = val*5+200;
		
	}
}
