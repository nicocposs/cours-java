package org.eclipse.classes;

import org.eclipse.exceptions.IncorrectCodePostalException;

public class Adresse {
	private int id;
	private String rue;
	private String ville;
	private String codePostal;
	private static int nbr;
	
	public Adresse() {
		super();
		nbr++;
		// TODO Auto-generated constructor stub
	}
	
	public Adresse(String rue, String ville, String codePostal) throws IncorrectCodePostalException{
		super();
		if(codePostal.length() != 5) {
			throw new IncorrectCodePostalException();
		}
		this.id = ++nbr;
		this.rue = rue;
		this.ville = ville;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public void setCodePostal(String codePostal) throws IncorrectCodePostalException{
		if(codePostal.length() != 5) {
			throw new IncorrectCodePostalException();
		}
		this.codePostal = codePostal;
	}
	
	public static int getNbr() {
		return nbr;
	}
	
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", rue=" + rue + ", ville=" + ville + ", codePostal=" + codePostal + "]";
	}
	
	
	
}
