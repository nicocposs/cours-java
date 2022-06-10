package org.eclipse.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.eclipse.classes.Machine;
import org.eclipse.interfaces.IMachineALaver;

public class Lavomatic {

	public static void main(String[] args) {
//		//TP 1
//		IMachineALaver machine = () -> System.out.println("Elle démarre");
//
//		machine.demarrer();
		
//		//TP 2
//		IMachineALaver machine = (str) -> System.out.println(str);
//		
//		machine.demarrer("Elle démarre");
		
//		//TP 3
//		IMachineALaver machine = str -> "Voici la valeur : " + str;
//		
//		System.out.println(machine.demarrer("Elle démarre"));
		
//		//TP 6
//		/////// Exemple 1
//		Thread thread1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("Thread 1 lancé");
//				
//			}
//		});
//		
//		thread1.start();
//		
//		Thread thread1 = new Thread(() -> System.out.println("Thread 1 lancé"));
//		
//		thread1.start();
//		
//		
//		
//		/////// Exemple 2
		
		List<Machine> machines = Arrays.asList(
				new Machine(2011,"Machine A"),
				new Machine(2015,"Machine B"),
				new Machine(2012,"Machine C"),
				new Machine(2018,"Machine D"),
				new Machine(2010,"Machine E"));
		
		for (Machine m : machines) {
			System.out.println(m);
		}
		
		
//		//Du plus petit au plus grand
//		machines.sort(new Comparator<Machine>() {
//			
//			@Override
//			public int compare (Machine o1, Machine o2) {
//				return o1.getAnnee()-o2.getAnnee();
//			}
//		});
		
		//Du plus grand au plus petit
		machines.sort((m1,m2) -> m2.getAnnee()-m1.getAnnee());

		System.out.println("----------------------------");
		
		for (Machine m : machines) {
			System.out.println(m);
		}
		
		
		
	}

}
