package classes;

public class Representant extends Employee {

	public Representant(String nom, String prenom, int age, String anneeEntree, double chiffreAffaire) {
		super(nom, prenom, age, anneeEntree);
		calculerSalaire(chiffreAffaire);
	}

	@Override
	public void calculerSalaire(double val) {
		this.salaire = val*0.2 + 800;
		
	}

}
