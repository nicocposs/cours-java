package org.eclipse.classes;

import java.util.Random;

public class Compteur extends Thread {
	private String nom;
	private static int ordre = 1;

	public Compteur() {
		super();
	}

	public Compteur(String nom) {
		super();
		this.nom = nom;
	}

	public void run() {
		for (int i = 1; i <= 7; i++) {
			System.out.println(nom + " : " + i);
			try {
				sleep((long) (Math.random() * 3000));
			} catch (InterruptedException e) {
				System.err.println(nom + " a ete interrompu.");
			}
		}
		System.out.println(nom + " a fini de compter en position " + ordre++);
	}
}
