package org.eclipse.main;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// Avec genericite
		LinkedList<String> list = new LinkedList<String>();

		// Ajouter des elements
		list.add("Hello");
		list.add("Bonjour");
		list.add("Ola");

		// Ajouter l element a la fin de la liste comme add()
		list.addLast("Olé");

		// Ajouter l element en premiere position
		list.addFirst("Salut");

		// Inserer l lement specifie en position index 1
		list.add(1, "Hi");

		// Affiche la liste
		list.forEach((item) -> System.out.println("List before deleting : " + item));

		// Supprimer le premier et le dernier element
		list.removeFirst();
		list.removeLast();

		list.forEach((item) -> System.out.println("List after deleting : " + item));

		// Recuperer la valeur selon son indice
		String val = list.get(2);

		// Modifier la valeur selon son indice
		list.set(2, val + " changed");

		list.forEach((item) -> System.out.println("List after change : " + item));

		System.out.println("------------------------------------------------------------");

		// Pour convertir un tableau en liste
		List<Integer> numList = Arrays.asList(2, 7, 1, 3);

		numList.forEach((n) -> System.out.println(n));

		System.out.println("------------------------------------------------------------");

		// Hashset cree une collection qui utilise une table de hachage
		// table de hachage -> stocke les valeurs en leur donnant une cle unique pour
		// les identifier
		HashSet<String> hSet = new HashSet<String>();

		hSet.add("hotel");
		// N'accepte pas les doublons
		hSet.add("hotel");

		hSet.add("motel");
		hSet.add("camping");
		hSet.add("gite");

		// Pour recuperer l element convertir le set en Array
		String[] array = hSet.toArray(new String[hSet.size()]);

		System.out.println("Element : " + array[2]);

		// Afficher la taille du Set
		System.out.println(hSet.size());

		// Supprimer l'objet motel
		hSet.remove("motel");

		System.out.println(hSet.contains("motel"));

		System.out.println(hSet.isEmpty());

		for (String value : hSet) {
			System.out.println(value);
		}

		hSet.forEach((value) -> System.out.println(value));

		System.out.println("------------------------------------------------------------");

		Integer[] tab = { 2, 3, 5, 1, 9 };

		List<Integer> ent = Arrays.asList(tab);

		ent.forEach((value) -> System.out.println(value));

		System.out.println("------------------------------------------------------------");

		// Dictionnaire

		HashMap<String, Double> map = new HashMap<String, Double>();

		map.put("A", 14.0);
		map.put("B", 36.5);
		map.put("C", 21.7);
		map.put("D", 54.7);

		Double v1 = map.get("A");
		System.out.println(v1);
		
		// Supprimer une valeur selon une clé
		map.remove("B");
		
		// Retourne l'ensemble de clé valeur, utiliser entrySet()		
		for(Entry<String, Double> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		
		Set s = map.entrySet();
		
		// Iterator est une interface qui appartient au framework collection. 
		// Il nous permet de parcourir la collection, d’accéder à l’élément et supprimer les éléments de la collection
		Iterator it = s.iterator();
		
		// boolean hasNext(): il retourne true si Iterator a plus d’élément à itérer
		while(it.hasNext()) {
			// Object next(): il retourne l’élément suivant dans la collection jusqu’à ce que la méthode hasNext() retourne true
			System.out.println(it.next());
		}
		

	}

}
