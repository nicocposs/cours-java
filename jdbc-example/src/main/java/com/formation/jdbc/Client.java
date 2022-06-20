package com.formation.jdbc;

import java.sql.Date;

public class Client {

	private int id;
	private String prenom;
	private String nom;
	private Date dateEntree;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateEntree() {
		return dateEntree;
	}
	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", dateEntree=" + dateEntree + "]";
	}
	
	
}
