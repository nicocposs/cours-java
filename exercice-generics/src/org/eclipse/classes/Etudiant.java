package org.eclipse.classes;

public class Etudiant {
	private int id;
	private String nom;
	private String numero;
	private static int count;

	

	public Etudiant() {
		this.id = ++count;
	}



	public Etudiant(String nom, String numero) {
		super();
		this.id = ++count;
		this.nom = nom;
		this.numero = numero;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public int getId() {
		return id;
	}



	public static int getCount() {
		return count;
	}



	@Override
	public String toString() {
		return numero + " : " + nom;
	}
	
	

}
