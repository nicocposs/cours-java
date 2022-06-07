package org.eclipse.classes.exos;

public class Filiere {
	private Integer Id;
	private String Code;
	private String Libelle;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	public static int count;

	public Filiere(String code, String libelle) {
		super();
		Id = ++count;
		Code = code;
		Libelle = libelle;
	}

	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return " La Filiere est : " + Libelle + "";
	}
}