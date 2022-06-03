package org.eclipse.classes;

public class Adresse {
	private int id;
	private String rue;
	private String ville;
	private String codePostal;
	private static int nbr;
	
	
	public Adresse() {
		super();
		this.id = ++nbr;
	}

	public Adresse(String rue, String ville, String codePostal) {
		super();
		this.id = ++nbr;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	
	
	public int getId() {
		return id;
	}

	public static int getNbr() {
		return nbr;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return rue + " - " + ville + " - " + codePostal;
	}
	
	
}
