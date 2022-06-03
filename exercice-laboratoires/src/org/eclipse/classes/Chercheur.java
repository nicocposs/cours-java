package org.eclipse.classes;

public class Chercheur {
	private int id;
	private String nom;
	private String poste;
	private int numOrdinateur;
	private static int nbr;
	
	public Chercheur() {
		super();
		this.id = ++nbr;
	}

	public Chercheur(String nom, String poste, int numOrdinateur) {
		super();
		this.id = ++nbr;
		this.nom = nom;
		this.poste = poste;
		this.numOrdinateur = numOrdinateur;
	}
	
	public Chercheur(String nom, String poste) {
		super();
		this.id = ++nbr;
		this.nom = nom;
		this.poste = poste;
	}

	
	
	public int getId() {
		return id;
	}

	public static int getNbr() {
		return nbr;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public int getNumOrdinateur() {
		return numOrdinateur;
	}

	public void setNumOrdinateur(int numOrdinateur) {
		this.numOrdinateur = numOrdinateur;
	}

	@Override
	public String toString() {
		String texte =  "        - Cercheur " + id + " :\n";
		texte += "          - Nom : " + nom + "\n";
		texte += "          - Poste : " + poste + "\n";
		texte += "          - Num. Ordinateur : " + numOrdinateur + "\n";
		return texte;
	}
	
	public boolean comparer(Chercheur ch) {
		return ch.getId() == this.id;
	}
}
