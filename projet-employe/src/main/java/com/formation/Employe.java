package com.formation;

public abstract class Employe implements Intervenant {

	private String prenom;
	private String nom;
	private int age;
	private String dateEntree;
	
	public Employe() {
		super();
		this.prenom = "DEFAULT";
		this.nom = "DEFAULT";
		this.age = 99;
		this.dateEntree = "DEFAULT";	
	}
	
	public Employe(String prenom, String nom, int age, String dateEntree) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
		this.dateEntree = dateEntree;
	}
	
	
	public String getNom() {
		return this.prenom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
}
