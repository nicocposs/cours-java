package org.eclipse.main;
import org.eclipse.classes.Compte;
import org.eclipse.classes.JobSylvieEtBruno;

public class Main {

	public static void main(String[] args) {
		Compte C1 = new Compte();
		Thread Sylvie = new Thread(new JobSylvieEtBruno(C1,"Sylvie"));
		Thread Bruno = new Thread(new JobSylvieEtBruno(C1,"Bruno"));
		
		Sylvie.start();
		Bruno.start();
	}

}
