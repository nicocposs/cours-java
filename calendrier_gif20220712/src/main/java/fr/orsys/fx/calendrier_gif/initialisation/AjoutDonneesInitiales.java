package fr.orsys.fx.calendrier_gif.initialisation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import fr.orsys.fx.calendrier_gif.business.Emotion;
import fr.orsys.fx.calendrier_gif.business.Gif;
import fr.orsys.fx.calendrier_gif.business.GifDistant;
import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.business.Reaction;
import fr.orsys.fx.calendrier_gif.business.Theme;
import fr.orsys.fx.calendrier_gif.business.Utilisateur;
import fr.orsys.fx.calendrier_gif.dao.EmotionDao;
import fr.orsys.fx.calendrier_gif.dao.GifDao;
import fr.orsys.fx.calendrier_gif.dao.GifDistantDao;
import fr.orsys.fx.calendrier_gif.dao.JourDao;
import fr.orsys.fx.calendrier_gif.dao.ReactionDao;
import fr.orsys.fx.calendrier_gif.dao.ThemeDao;
import fr.orsys.fx.calendrier_gif.dao.UtilisateurDao;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

	private final EmotionDao emotionDao;
	private final ThemeDao themeDao;
	private final JourDao jourDao;
	private final UtilisateurDao utilisateurDao;
	private final GifDao gifDao;
	private final GifDistantDao gifDistantDao;
	private final ReactionDao reactionDao;
	
	private static Random random = new Random();
	private static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("fr-FR"), new RandomService());
	private static Faker faker = new Faker(new Locale("fr-FR"));

	@Override
	public void run(String... args) throws Exception {
		Date dateHeureDebut = new Date();
		ajouterEmotions();
		ajouterThemes();
		ajouterJours();
		ajouterUtilisateurs();
		ajouterGifs();
		ajouterReactions();
		Date dateHeureFin = new Date();
		System.out.println("Données initiales ajoutées en " + String.valueOf(dateHeureFin.getTime()-dateHeureDebut.getTime()) + " ms");
		gifDao.findTopReactions().forEach(System.out::println);
	}

	 private void ajouterReactions() {
	        if (reactionDao.count() == 0) {

	            List<Emotion> emotions = emotionDao.findAll();
	            List<Gif> gifs = gifDao.findAll();
	            List<Utilisateur> utilisateurs = utilisateurDao.findAll();
	            Random random = new Random();
	            
	            for (int i = 0; i < 1000; i++) {
	                reactionDao.save(new Reaction(
	                        utilisateurs.get(random.nextInt(utilisateurs.size())),
	                        emotions.get(random.nextInt(emotions.size())), 
	                        gifs.get(random.nextInt(gifs.size()))));
	            }
	        }
	    }

	private void ajouterEmotions() {
		if (emotionDao.count() == 0) {
			emotionDao.save(new Emotion("Souriant", "&#x1F600;"));
			emotionDao.save(new Emotion("Monocle", "&#x1F9D0;"));
			emotionDao.save(new Emotion("Bisous", "&#x1F618;"));
			emotionDao.save(new Emotion("Coeur", "&#x1F60D;"));
			emotionDao.save(new Emotion("PTDR", "&#x1F923;"));
		}
	}
	
	private void ajouterThemes( ) {
		if (themeDao.count()==0) {
			themeDao.save(new Theme("Bachata"));
			themeDao.save(new Theme("Dark"));					
		}
	}

	private void ajouterJours() {
		if (jourDao.count()==0) {
			int anneeEnCours = LocalDate.now().getYear();
			int moisEnCours = LocalDate.now().getMonthValue();
			LocalDate date = LocalDate.of(anneeEnCours, moisEnCours, 1);
			int nbJoursDuMoisEnCours = date.lengthOfMonth();
			Jour jour = new Jour();
			jour.setDate(date);
			for (int i = 1; i <= nbJoursDuMoisEnCours; i++) {
				jourDao.save(new Jour(date));
				date = date.plusDays(1);
			}			
		}
	}

	public void ajouterUtilisateurs() {
		if (utilisateurDao.count()==0) {
			// Partie déclarative
			List<Theme> themes = themeDao.findAll();		
			Map<String, Utilisateur> map = new HashMap<>();
			Calendar calendar = Calendar.getInstance();
			int compteur = 0;
			
			// Partie traitement
			// On boucle tant que la taille de la map n'est pas égale à 10000
			while (map.size() != 10000) {
				compteur++;
				// On déclare un objet de type Utilisateur
				// que l'on instancie dans la foulée
				Utilisateur utilisateur = new Utilisateur();
				// On fait appel au faker pour définir le nom de l'utilisateur
				utilisateur.setNom(faker.name().lastName());
				utilisateur.setPrenom(faker.name().firstName());
				utilisateur.setEmail(fakeValuesService.letterify("?????@orsys.fr"));
				
				//utilisateur.setMotDePasse(fakeValuesService.letterify("?????"));
				utilisateur.setMotDePasse(faker.internet().password(3, 8));

				
				// Grâce à l'objet calendar et le faker on obtient une date comprise
				// entre le 1 janvier 2021 et aujourd'hui (inclus)
				calendar.set(2021, 1, 1);
				Date dateDebut = calendar.getTime();
				calendar = Calendar.getInstance();
				Date dateFin = calendar.getTime();
				Date dateAleatoire = faker.date().between(dateDebut, dateFin);
				calendar.setTime(dateAleatoire);
				// La date choisie par le faker est utilisée pour définir la date et heure
				// d'inscription du nouvel utilisateur
				utilisateur.setDateHeureInscription(
						dateAleatoire.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
				// On choisit un thème aléatoirement parmi la liste des thèmes
				utilisateur.setTheme(themes.get(random.nextInt(themes.size())));
				//System.out.println(utilisateur);
				// On ajoute l'objet utilisateur dans la map
				map.put(utilisateur.getEmail(), utilisateur);
			}
			
			// On ajoute un utilisateur pour ne pas avoir à s'inscrire à chaque lancement
			Utilisateur utilisateurTest = new Utilisateur();
			utilisateurTest.setEmail("test@orsys.fr");
			utilisateurTest.setPrenom("Test");
			utilisateurTest.setNom("Orsys");
			utilisateurTest.setMotDePasse("aaaa");
			utilisateurTest.setTheme(themes.get(1));
			map.put(utilisateurTest.getEmail(), utilisateurTest);
			
			// J'invoque la méthode saveAll sur la dao utilisateurDao
			// pour demander à Spring Data de sauvegarder tous les utilisateurs présents dans la map
			
			utilisateurDao.saveAll(map.values());
			 
			System.out.println("Nombre d'itérations=" + compteur);		
			
		}
	}
	
	private void ajouterGifs() {
		if (gifDao.count() == 0) {
			List<Jour> jours = jourDao.findAll();
			List<Utilisateur> utilisateurs = utilisateurDao.findAll();
			Calendar calendar = Calendar.getInstance();
			
			for (int i = 0; i < 20; i++) {
				Utilisateur utilisateur = utilisateurs.remove(0);
				Jour jour = jours.remove(0);
				calendar.set(2021, 1, 1);
				Date dateDebut = calendar.getTime();
				calendar = Calendar.getInstance();
				Date dateFin = calendar.getTime();
				Date dateAleatoire = faker.date().between(dateDebut, dateFin);
				calendar.setTime(dateAleatoire);
				LocalDateTime dateHeureAjout = dateAleatoire.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				gifDistantDao.save(new GifDistant(utilisateur, jour, "Wow !", "https://c.tenor.com/Qo_pth9wapcAAAAC/wow-eddy-wally.gif", dateHeureAjout));
				// On met à jour le solde de l'utilisateur
				utilisateur.setNbPoints(utilisateur.getNbPoints()-jour.getNbPoints());
				utilisateurDao.save(utilisateur);
			}
		}	
	}

	
}