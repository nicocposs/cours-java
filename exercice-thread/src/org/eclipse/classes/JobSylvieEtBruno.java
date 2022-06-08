package org.eclipse.classes;

public class JobSylvieEtBruno implements Runnable {
	Compte compte;
	private String nom;

	public JobSylvieEtBruno(Compte compte, String nom) {
		this.compte = compte;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			effectuerRetrait(10);
		}

	}

	public void effectuerRetrait(int montant) {
		synchronized (compte) {
			if (compte.getSolde() >= montant) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				compte.retraitArgent(montant);
				System.out.println(
						this.getNom() + " a fait un retrait de " + montant + ", le solde est de " + compte.getSolde());
			} else {
				System.out.println("Solde insuffisant ("+compte.getSolde()+")");
			}
		}
	}

}
