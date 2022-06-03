package org.eclipse.classes;

import java.util.ArrayList;
import java.util.List;

public class Bureau {
	private int id;
	private String code;
	private String nom;
	private List<Chercheur> chercheurs;
	private static int nbr;
	
	public Bureau() {
		super();
		this.chercheurs = new ArrayList<Chercheur>();
		this.id = ++nbr;
	}

	public Bureau(String code, String nom, List<Chercheur> chercheurs) {
		super();
		this.id = ++nbr;
		this.code = code;
		this.nom = nom;
		this.chercheurs = chercheurs;
	}

	
	
	public int getId() {
		return id;
	}

	public static int getNbr() {
		return nbr;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Chercheur> getChercheurs() {
		return chercheurs;
	}

	public void setChercheurs(List<Chercheur> chercheurs) {
		this.chercheurs = chercheurs;
	}
	
	public void addChercheur(Chercheur ch) {
		this.chercheurs.add(ch);
	}

	@Override
	public String toString() {
		String texte =  "  - Bureau " + id + " :\n";
		texte += "      - Nom : " + nom + "\n";
		texte += "      - Code : " + code + "\n";
		texte += "      - Chercheurs :\n";
		for(Chercheur c : chercheurs) {
			texte += c;
		}
		return texte;
	}
	
	
}
