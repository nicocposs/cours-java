package org.eclipse.classes;

public class Etudiant {
	private int id;
	private String nom;
	private String prenom;
	private Filiere filiere;
	private static int nbr;
	
	public Etudiant() {
		super();
		nbr++;
	}
	
	public Etudiant(String nom, String prenom, Filiere filiere) {
		super();
		this.id = ++nbr;
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = filiere;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", filiere=" + filiere + "]";
	}
	
	
}
