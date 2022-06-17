package classes;

public class Salesman extends Employee{

	public Salesman(String nom, String prenom, int age, String anneeEntree, double chiffreAffaire) {
		super(nom, prenom, age, anneeEntree);
		calculerSalaire(chiffreAffaire);
	}

	@Override
	public void calculerSalaire(double val) {
		this.salaire = val*0.2 + 400;
		
	}
	
	
}
