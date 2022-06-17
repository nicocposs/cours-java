package classes;

public abstract class Employee {
	private String nom;
	private String prenom;
	private int age;
	private String anneeEntree;
	protected double salaire;
	
	public Employee(String nom, String prenom, int age, String anneeEntree) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.anneeEntree = anneeEntree;
	}
	
	
	
	public double getSalaire() {
		return salaire;
	}



	public abstract void calculerSalaire(double v);

	@Override
	public String toString() {
		return "	L'employé "+ this.prenom +" "+ this.nom + " a un salaire de " + this.salaire + "€";
	}
}
