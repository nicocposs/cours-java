package org.eclipse.classes;

public class Admin extends User {

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	public Admin(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afficherNomComplet() {
		System.out.println("Je suis l'admin");
		System.out.println(this.getNom() + " " + this.getPrenom());
	}

}
