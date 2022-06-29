package services;

import java.util.HashMap;
import java.util.Map;

public class NumDeptMapper implements DeptNumService {
	private Map<String, String> deptMap;
	private String[][] deptArray = { { "01", "Ain" }, { "02", "Aisne" }, { "03", "Allier" },
			{ "04", "Alpes-de-Haute-Provence" }, { "05", "Hautes-Alpes" }, { "06", "Alpes-Maritimes" },
			{ "07", "Ard�che" }, { "08", "Ardennes" }, { "09", "Ari�ge" }, { "10", "Aube" }, { "11", "Aude" },
			{ "12", "Aveyron" }, { "13", "Bouches-du-Rh�ne" }, { "14", "Calvados" }, { "15", "Cantal" },
			{ "16", "Charente" }, { "17", "Charente-Maritime" }, { "18", "Cher" }, { "19", "Corr�ze" },
			{ "2A", "Corse-du-Sud" }, { "2B", "Haute-Corse" }, { "21", "C�te-d'Or" }, { "22", "C�tes-d'Armor" },
			{ "23", "Creuse" }, { "24", "Dordogne" }, { "25", "Doubs" }, { "26", "Dr�me" }, { "27", "Eure" },
			{ "28", "Eure-et-Loir" }, { "29", "Finist�re" }, { "30", "Gard" }, { "31", "Haute-Garonne" },
			{ "32", "Gers" }, { "33", "Gironde" }, { "34", "H�rault" }, { "35", "Ille-et-Vilaine" }, { "36", "Indre" },
			{ "37", "Indre-et-Loire" }, { "38", "Is�re" }, { "39", "Jura" }, { "40", "Landes" },
			{ "41", "Loir-et-Cher" }, { "42", "Loire" }, { "43", "Haute-Loire" }, { "44", "Loire-Atlantique" },
			{ "45", "Loiret" }, { "46", "Lot" }, { "47", "Lot-et-Garonne" }, { "48", "Loz�re" },
			{ "49", "Maine-et-Loire" },

			{ "50", "Manche" }, { "51", "Marne" }, { "52", "Haute-Marne" }, { "53", "Mayenne" },
			{ "54", "Meurthe-et-Moselle" }, { "55", "Meuse" }, { "56", "Morbihan" }, { "57", "Moselle" },
			{ "58", "Ni�vre" }, { "59", "Nord" }, { "60", "Oise" }, { "61", "Orne" }, { "62", "Pas-de-Calais" },
			{ "63", "Puy-de-D�me" }, { "64", "Pyr�n�es-Atlantiques" }, { "65", "Hautes-Pyr�n�es" },
			{ "66", "Pyr�n�es-Orientales" }, { "67", "Bas-Rhin" }, { "68", "Haut-Rhin" }, { "69D", "Rh�ne" },
			{ "69M", "M�tropole de Lyon" }, { "70", "Haute-Sa�ne" }, { "71", "Sa�ne-et-Loire" }, { "72", "Sarthe" },
			{ "73", "Savoie" }, { "74", "Haute-Savoie" }, { "75", "Paris" }, { "76", "Seine-Maritime" },
			{ "77", "Seine-et-Marne" }, { "78", "Yvelines" }, { "79", "Deux-S�vres" }, { "80", "Somme" },
			{ "81", "Tarn" }, { "82", "Tarn-et-Garonne" }, { "83", "Var" }, { "84", "Vaucluse" }, { "85", "Vend�e" },
			{ "86", "Vienne" }, { "87", "Haute-Vienne" }, { "88", "Vosges" }, { "89", "Yonne" },
			{ "90", "Territoire de Belfort" }, { "91", "Essonne" }, { "92", "Hauts-de-Seine" },
			{ "93", "Seine-Saint-Denis" }, { "94", "Val-de-Marne" }, { "95", "Val-d'Oise" }, { "971", "Guadeloupe" },
			{ "972", "Martinique" }, { "973", "Guyane" }, { "974", "La R�union" },
			{ "975", "Saint-Pierre-et-Miquelon" }, { "976", "Mayotte" }, { "977", "Saint-Barth�lemy" },
			{ "978", "Saint-Martin" }, { "984", "Terres australes et antarctiques fran�aises" },
			{ "986", "Wallis-et-Futuna" }, { "987", "Polyn�sie fran�aise" }, { "988", "Nouvelle-Cal�donie" },
			{ "989", "�le de Clipperton" }

	};

	public NumDeptMapper() {
		deptMap = new HashMap<String, String>();
		for (String[] dept : deptArray) {
			deptMap.put(dept[0], dept[1]);
		}
	}

	@Override
	public String findDept(String deptNum) {
		return (deptMap.get(deptNum));
	}
}
