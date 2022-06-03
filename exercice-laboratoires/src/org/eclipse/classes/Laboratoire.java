package org.eclipse.classes;

import java.util.ArrayList;
import java.util.List;

public class Laboratoire {
	private int id;
	private String nom;
	private String specialite;
	private Adresse adresse;
	private List<Bureau> bureaux;
	private static int nbr;
	
	public Laboratoire() {
		super();
		this.bureaux = new ArrayList<Bureau>();
		this.id = ++nbr;
	}

	public Laboratoire(String nom, String specialite, Adresse adresse, List<Bureau> bureaux) {
		super();
		this.id = ++nbr;
		this.nom = nom;
		this.specialite = specialite;
		this.adresse = adresse;
		this.bureaux = bureaux;
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

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Bureau> getBureaux() {
		return bureaux;
	}

	public void setBureaux(List<Bureau> bureaux) {
		this.bureaux = bureaux;
	}
	
	public void addBureau(Bureau bur) {
		this.bureaux.add(bur);
	}

	@Override
	public String toString() {
		String texte = "Laboratoire " + id + " :\n";
		texte += "  - Nom : " + nom + "\n";
		texte += "  - Specialite : " + specialite + "\n";
		texte += "  - Adresse : " + adresse + "\n";
		texte += "  - Bureaux :\n";
		for(Bureau b : bureaux) {
			texte += "  " + b;
		}
		return texte;
	}
	
	
}
