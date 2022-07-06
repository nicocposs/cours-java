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
	private final GifDistantDao gifDistantDao;
	private final ReactionDao reactionDao;
	private final GifDao gifDao;
	
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
		System.out.println(themeDao.findByThemeStartingWithB());
        // gestion des 4 nouvelles méthodes
//        System.out.println(utilisateurDao.findUsersHavingChosenDarkTheme());
//        System.out.println(utilisateurDao.findNonContribuitingUsers());
//        System.out.println(utilisateurDao.findAllUsersSortedByPrenom());
//        System.out.println(utilisateurDao.findInscriptionJulyUsers());
        utilisateurDao.findUsersHavingChosenDarkTheme().forEach(System.out::println);
        utilisateurDao.findNonContribuitingUsers().forEach(System.out::println);
        utilisateurDao.findAllUsersSortedByPrenom().forEach(System.out::println);
        utilisateurDao.findInscriptionJulyUsers().forEach(System.out::println);
        
        
        System.out.println("exo");
       
        
        jourDao.findDaysOfCurrentMonth().forEach(System.out::println);
        System.out.println(jourDao.findAllDaysDesc().get(0));
        List<Jour> jours = jourDao.findAll();
        
        gifDao.findGifsByReactionsDesc().forEach((e)->{System.out.println(e.getId());});
        System.out.println(jourDao.findLastEntry());
        jourDao.findAllByRandom().forEach(System.out::println);
        
        gifDao.findGifsByReactionsDesc().forEach(System.out::println);
        
        utilisateurDao.findNbInscrits().forEach(System.out::println);
        gifDao.findNbGifs().forEach(System.out::println);
        System.out.println(jourDao.findNbPoints(7, 2022));
        System.out.println(jourDao.findAverageOfPoints(7, 2022));
	}

	
	
	
	private void ajouterEmotions() {
		if (emotionDao.count() == 0) {
			emotionDao.save(new Emotion("Souriant", "&#x1F600"));
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
			
			// Partie traitement
			// On boucle tant que la taille de la map n'est pas égale à 10000
			while (map.size() != 500) {
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
			// J'invoque la méthode saveAll sur la dao utilisateurDao
			// pour demander à Spring Data de sauvegarder tous les utilisateurs présents dans la map
			utilisateurDao.saveAll(map.values());		
		}
		
	}
	
	public void ajouterGifs() {
		HashMap<String,GifDistant> map = new HashMap<>();
		Calendar calendar = Calendar.getInstance();
		List<Utilisateur> utilisateurs = utilisateurDao.findAll();
		List<Jour> jours = jourDao.findAll();	
		
		while(map.size() != 20) {
			
			GifDistant gifdistant = new GifDistant();
			
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
			gifdistant.setDateHeureAjout(
					dateAleatoire.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
			
			gifdistant.setLegende(faker.letterify("???? : ???? - ?????"));
			Jour j = jours.get(random.nextInt(jours.size()));
			
			gifdistant.setJour(j);
			Utilisateur u = utilisateurs.get(random.nextInt(utilisateurs.size()));
			gifdistant.setUtilisateur(u);
			u.setNbPoints(u.getNbPoints()-j.getNbPoints());
			utilisateurDao.save(u);
			gifdistant.setUrl("https://media.giphy.com/media/duzpaTbCUy9Vu/giphy.gif");
			
			map.put(gifdistant.getLegende(), gifdistant);
		
		}
		gifDistantDao.saveAll(map.values());
	}
	
	public void ajouterReactions() {
		HashMap<LocalDateTime,Reaction> map = new HashMap<>();
		Calendar calendar = Calendar.getInstance();
		List<Utilisateur> utilisateurs = utilisateurDao.findAll();
		List<Emotion> emotions = emotionDao.findAll();	
		List<GifDistant> gifs = gifDistantDao.findAll();
		
		while(map.size() != 10) {
			
			Reaction reaction = new Reaction();
			
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
			reaction.setDateHeure(
					dateAleatoire.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
			
			reaction.setGif(gifs.get(random.nextInt(gifs.size())));
			reaction.setEmotion(emotions.get(random.nextInt(emotions.size())));
			reaction.setUtilisateur(utilisateurs.get(random.nextInt(utilisateurs.size())));
			
			map.put(reaction.getDateHeure(), reaction);
		}
		reactionDao.saveAll(map.values());
	}
}