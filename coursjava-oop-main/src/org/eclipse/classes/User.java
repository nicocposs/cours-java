package org.eclipse.classes;

// Les classes abstraites permet de définir des comportements (méthodes) dont l'implémentation (le code dans la méthode) 
// se fait dans les classes filles
// Ainsi, on a l'assurance que les classes filles respecteront le comportement défini par la classe mère abstraite
public abstract class User {
	
	// 3 types de visibilites :
	// - public accessible partt ds le programme
	// - private accessible seulement ds la classe
	// - protected accessible ds le package mais aussi au niveau des classes filles
	// (BONNES pratiques)à utiliser sur les classes abstraites
	protected int id;
	protected String nom;
	protected String prenom;
	
	private static int count;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String nom) {
		super();
		this.id = ++count;
		this.nom = nom;
	}
	
	public User(String nom, String prenom) {
		super();
		this.id = ++count;
		this.nom = nom;
		this.prenom = prenom;
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

	@Override
	public String toString() {		
		String result = "Personne [nom=" + nom.toLowerCase() + ", prenom=" + prenom + "]";
		return result;
	}
	
	public abstract void afficherNomComplet();

}
