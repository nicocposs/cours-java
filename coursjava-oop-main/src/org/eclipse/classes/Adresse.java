package org.eclipse.classes;

import org.eclipse.exceptions.IncorrectCodePostalException;

public class Adresse {

	private String rue;
	private int codePostal;
	private String ville;

	public Adresse() {
		super();
	}

	// throws ca permet de dire que ici le constructeur va renvoyer une exception
	public Adresse(String rue, int codePostal, String ville) throws IncorrectCodePostalException {
		super();
		// Alors que throw new permet de renvoyer une nouvelle instance de l'exception IncorrectCodePostalException
		if(String.valueOf(codePostal).matches("/\\{5}/"))
			throw new IncorrectCodePostalException();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	// throws ca permet de dire que ici le constructeur va renvoyer une exception
	public void setCodePostal(int codePostal) throws IncorrectCodePostalException {
		// Alors que throw new permet de renvoyer une nouvelle instance de l'exception IncorrectCodePostalException
		if(String.valueOf(codePostal).matches("/\\{5}/"))
			throw new IncorrectCodePostalException();
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

}
