package org.eclipse.classes;

import java.util.Arrays;
import java.util.List;

import org.eclipse.enums.Sport;
import org.eclipse.interfaces.IMiseEnForme;

// POJO -> PLAIN OLD JAVA OBJECT
// final -> classe qui ne peut pas avoir de classes filles
// public final class Personne implements IMiseEnForme {
public class Personne implements IMiseEnForme {

	private int id;
	private String nom;
	private String prenom;
	// declaration d'un attribut Sport de type enum
	private Sport sport;
	// Agregation : type d'association
	// Une personne peut avoir une adresse
	private Adresse adresse;

	// attribut statique => attribut dont la valeur est paratgee
	// par toutes les instances
	private static int nbrPersonnes;

	public Personne() {
		super();
		nbrPersonnes++;
	}

	// Surcharge contructeur
	public Personne(String nom, String prenom, Sport sport) {
		super();
		this.id = ++nbrPersonnes;
		this.nom = nom;
		this.prenom = prenom;
		this.sport = sport;
	}

	// Surcharge contructeur
	public Personne(String nom, String prenom, Adresse adresse) {
		super();
		this.id = ++nbrPersonnes;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public static int getNbrPersonnes() {
		return nbrPersonnes;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", sport=" + sport + ", adresse="
				+ adresse + "]";
	}

	public void afficherNomComplet(String nom) {
		System.out.println(nom.toUpperCase() + VALUE);
	}

	// Methode prefixe par final -> methode que l'on ne pouura pas
	// redefinir ds les classes Enfants
	// Surcharge de methode afficherNomComplet(String nom, String prenom)
	// Rajout d'un deuxieme parametre
	public final void afficherNomComplet(String nom, String prenom) {
		System.out.println(nom.toUpperCase() + " " + prenom.toUpperCase());
	}

	// Surcharge de methode afficherNomComplet(String nom, String prenom, Adresse
	// adresse)
	// Rajout d'un deuxieme parametre
	public void afficherNomComplet(String nom, String prenom, Adresse adresse) {
		System.out.println(nom.toUpperCase() + " " + prenom.toUpperCase() + " " + adresse);
	}

	@Override
	public void afficherNomMajuscule() {
		System.out.println(nom.toUpperCase());
	}

	@Override
	public void afficherPrenomMinuscule() {
		System.out.println(prenom.toLowerCase());
	}
}
