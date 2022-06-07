package org.eclipse.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.classes.Etudiant;
import org.eclipse.classes.Exemple;
import org.eclipse.classes.Operation;

public class Main {

	public static void main(String[] args) {
		List<Etudiant> etudiants = new ArrayList<Etudiant>();

		Etudiant etu1 = new Etudiant("Dupont", "0123");
		Etudiant etu2 = new Etudiant("Delafontaine", "1025");
		Etudiant etu3 = new Etudiant("Pichon", "5520");
		Etudiant etu4 = new Etudiant("Perrin", "0011");
		Etudiant etu5 = new Etudiant("Delaune", "1110");

		etudiants.add(etu1);
		etudiants.add(etu2);
		etudiants.add(etu3);
		etudiants.add(etu4);
		etudiants.add(etu5);

		System.out.println(trouverEtuViaNum(etudiants, "0000"));
		System.out.println(trouverEtuViaNum(etudiants, "5520"));

		System.out.println(trouverEtuViaNom(etudiants, "Dubois"));
		System.out.println(trouverEtuViaNom(etudiants, "Pichon"));

		for (String n : listeNums(etudiants)) {
			System.out.println(n);
		}

		HashMap<String, Etudiant> etudiants2 = new HashMap<String, Etudiant>();

		Etudiant etu6 = new Etudiant("Dupont", "0123");
		Etudiant etu7 = new Etudiant("Delafontaine", "1025");
		Etudiant etu8 = new Etudiant("Pichon", "5520");
		Etudiant etu9 = new Etudiant("Perrin", "0011");
		Etudiant etu10 = new Etudiant("Delaune", "1110");

		etudiants2.put("etu6", etu6);
		etudiants2.put("etu7", etu7);
		etudiants2.put("etu8", etu8);
		etudiants2.put("etu9", etu9);
		etudiants2.put("etu10", etu10);

		System.out.println(trouverEtuViaNumMap(etudiants2, "0000"));
		System.out.println(trouverEtuViaNumMap(etudiants2, "5520"));

		System.out.println(trouverEtuViaNomMap(etudiants2, "Dubois"));
		System.out.println(trouverEtuViaNomMap(etudiants2, "Pichon"));

		for (String n : listeNumsMap(etudiants2)) {
			System.out.println(n);
		}

		Exemple<Integer, String> couple = new Exemple<Integer, String>();
		couple.setVar1(10);
		couple.setVar2("Bonjour");
		System.out.println(couple.getVar1().getClass().getTypeName() + " " + couple.getVar1());
		System.out.println(couple.getVar2().getClass().getTypeName() + " " + couple.getVar2());
		
		
		
		Operation <Integer> operation1 = new Operation<Integer>(5,3);
		operation1.plus();
		Operation <String> operation2 = new Operation<String>("bon","jour");
		operation2.plus();
		Operation <Double> operation3 = new Operation<Double>(5.2,3.8);
		operation3.plus();
		Operation <Boolean> operation4 = new Operation<Boolean>(true,false);
		operation4.plus();

	}

	public static String trouverEtuViaNum(List<Etudiant> arr, String num) {
		String str = "Non trouvé";
		for (Etudiant e : arr) {
			if (e.getNumero() == num) {
				str = e.getNom();
			}
		}
		return str;
	}

	public static String trouverEtuViaNom(List<Etudiant> arr, String nom) {
		String val = "Non trouvé";
		for (Etudiant e : arr) {
			if (e.getNom() == nom) {
				val = e.getNumero();

			}
		}
		return val;
	}

	public static List<String> listeNums(List<Etudiant> arr) {
		List<String> nums = new ArrayList<String>();
		for (Etudiant e : arr) {
			nums.add(e.getNumero());
		}
		return nums;
	}

	public static String trouverEtuViaNumMap(HashMap<String, Etudiant> map, String num) {
		String str = "Non trouvé";
		for (Entry<String, Etudiant> e : map.entrySet()) {
			if (e.getValue().getNumero() == num) {
				str = e.getValue().getNom();
			}
		}
		return str;
	}

	public static String trouverEtuViaNomMap(HashMap<String, Etudiant> map, String nom) {
		String str = "Non trouvé";
		for (Entry<String, Etudiant> e : map.entrySet()) {
			if (e.getValue().getNom() == nom) {
				str = e.getValue().getNumero();
			}
		}
		return str;
	}

	public static List<String> listeNumsMap(HashMap<String, Etudiant> map) {
		List<String> nums = new ArrayList<String>();
		for (Entry<String, Etudiant> e : map.entrySet()) {
			nums.add(e.getValue().getNumero());
		}
		return nums;
	}
}
