package org.eclipse.main;

import org.eclipse.classes.Compteur;
import org.eclipse.classes.MyCount;
import org.eclipse.classes.MyThread;
import org.eclipse.classes.MyThreadRunnable;
import org.eclipse.classes.TestThread;

public class Main {

	public static void main(String[] args) throws InterruptedException{
//		MyThread A = new MyThread("A");
//		MyThread B = new MyThread("B");
//		MyThread C = new MyThread("C");
//		Thread D = new Thread(new MyThreadRunnable("D"));
//		Thread E = new Thread(new MyThreadRunnable("E"));
//		Thread F = new Thread(new MyThreadRunnable("F"));
//		
//		System.out.println(D.isAlive() + " " + D.getState());
//		
//		A.start();
//		B.start();
//		C.start();
//		B.interrupt();
//		D.start();
//		E.start();
//		F.start();
//		
//		
//		
//		System.out.println(D.isAlive() + " " + D.getState());
//		
//		D.join();
//		E.join();
//		F.join();
//		
//		System.out.println(D.isAlive() + " " + D.getState());
//		
//		System.out.println(Thread.currentThread().getName() + " : j'ai fini");
		
		// Ecrire une classe Compteur qui herite de Thread avec un attribut nom
		
				// Un compteur a une methode run qui compte de 1 a 7 A chaque iteration, 
				// le thread affiche son nom + l’indice de son iteration
				// puis appelle la methode sleep pour une duree aleatoire (de 0 a 3 000 millisecondes).
				
				// Quand il finit de compter, il affiche un message contenant son
				// nom et un message du type a fini de compter en position x et il affiche sa position
				// Creer un main avec 5 threads et verifier l’execution
		
//		Compteur[] compteurs = { new Compteur("a"), new Compteur("b"), new Compteur("c"), new Compteur("d"),
//				new Compteur("e") };
//		for (int i = 0; i < compteurs.length; i++) {
//			compteurs[i].start();
//		}
		
		
		
		MyCount TC = new MyCount();
		Thread t1 = new Thread(new TestThread(TC," t1 "));
		Thread t2 = new Thread(new TestThread(TC," t2 "));
		Thread t3 = new Thread(new TestThread(TC," t3"));
		t1.start();
		t2.start();
		t3.start();
		  
	}

}
