package org.eclipse.classes.exos;

public class Etudiant {

	private Integer Id;
	private String Nom;
	private String Prenom;
	private String Date;
	private Filiere filiere;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public static int count;

	public Etudiant(String nom, String prenom, String date, Filiere filiere) {
		super();
		Id = ++count;
		Nom = nom;
		Prenom = prenom;
		Date = date;
		this.filiere = filiere;
	}

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "je suis l'étudiant " + Nom + " " + Prenom + " et ma date de naissance est " + Date + "";
	}

	public Filiere getFiliere() {
		return filiere;
	}
}