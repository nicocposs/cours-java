package fr.orsys.fx.calendrier_gif;

import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.business.Theme;
import fr.orsys.fx.calendrier_gif.business.Utilisateur;

public class ExempleDeSerialisation {

	public static void main(String[] args) {
		System.out.println("Exemples de sérialisation");
		
		// Sérialisation : on prend un objet Java et on l'exprime en JSON
		// Désérialisation : on reçoit un bloc de texte en JSON et on l'utilise pour hydrater un
		// objet métier Java
		
		// On déclare et on instancie un objet de type ObjectMapper qui est capable
		// de sérialiser n'importe quel objet Java
		ObjectMapper objectMapper = new ObjectMapper();
		
		Theme theme = new Theme("Light");
		Jour jour = new Jour();
		jour.setDate(LocalDate.of(2022, 7, 12));
		jour.setNbPoints(30);
		System.out.println(theme);
		System.out.println(jour);
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPrenom("Capucine");
		utilisateur.setMotDePasse("1234");
		utilisateur.setEmail("capucine@orsys.fr");
		utilisateur.setTheme(theme);
		
		try {
			System.out.println(objectMapper.writeValueAsString(theme));
			System.out.println(objectMapper.writeValueAsString(utilisateur));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}