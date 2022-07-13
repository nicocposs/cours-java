package fr.orsys.fx.calendrier_gif.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.orsys.fx.calendrier_gif.business.Gif;
import fr.orsys.fx.calendrier_gif.business.GifDistant;
import fr.orsys.fx.calendrier_gif.business.GifTeleverse;
import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.business.Utilisateur;
import fr.orsys.fx.calendrier_gif.dao.GifDao;
import fr.orsys.fx.calendrier_gif.dao.GifDistantDao;
import fr.orsys.fx.calendrier_gif.dao.GifTeleverseDao;
import fr.orsys.fx.calendrier_gif.dao.UtilisateurDao;
import fr.orsys.fx.calendrier_gif.service.GifService;
import fr.orsys.fx.calendrier_gif.service.JourService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GifServiceImpl implements GifService {

	// Métaphore du mille-feuille : on commence par définir les attributs de la classe (glaçage)
	
	private final GifDao gifDao;
	private final GifDistantDao gifDistantDao;
	private final GifTeleverseDao gifTeleverseDao;
	private final JourService jourService;
	private final UtilisateurDao utilisateurDao;
	
	@Override
	public GifDistant ajouterGifDistant(LocalDate idJour, String url, Utilisateur utilisateur) {
		GifDistant gifDistant = new GifDistant();
		Jour jour = jourService.recupererJour(idJour);
		gifDistant.setJour(jour);
		gifDistant.setUrl(url);
		gifDistant.setUtilisateur(utilisateur);
		return ajouterGifDistant(gifDistant, utilisateur);
	}

	@Override
	public GifDistant ajouterGifDistant(GifDistant gifDistant, Utilisateur utilisateur) {
		
		// TODO véfifier solde du joueur
		
		gifDistant = gifDistantDao.save(gifDistant);
		gifDistant.setUtilisateur(utilisateur);
		
		// Met à jour le solde de l'utilisateur
		utilisateur.setNbPoints(utilisateur.getNbPoints()-gifDistant.getJour().getNbPoints());
		utilisateurDao.save(utilisateur);
		return gifDistant;
	}
	
	@Override
	public GifTeleverse ajouterGifTeleverse(LocalDate localDate, Utilisateur utilisateur, String legende, String nomFichierOriginal) {
		Jour jour = jourService.recupererJour(localDate);
		
		if (recupererGifParJour(jour) == null) {
			GifTeleverse gifTeleverse = new GifTeleverse();
			gifTeleverse.setJour(jourService.recupererJour(localDate));
			gifTeleverse.setLegende(legende);
			gifTeleverse.setNomFichierOriginal(nomFichierOriginal);
			gifTeleverse = gifTeleverseDao.save(gifTeleverse);
			gifTeleverse.setUtilisateur(utilisateur);
			jour.setGif(gifTeleverse);
			jourService.enregistrerJour(jour);
			// Met à jour le solde de l'utilisateur
			utilisateur.setNbPoints(utilisateur.getNbPoints() - jour.getNbPoints());
			utilisateurDao.save(utilisateur);
			return gifTeleverse;
		}
		else {
			// TODO il faudrait lever une exception maison : throw new JourDejaPrisException();
			return null;
		}
	}

	@Override
	public Gif enregistrerGif(Gif gif) {
		return gifDao.save(gif);
	}

	@Override
	public Gif recupererGif(Long idGif) {
		return gifDao.findById(idGif).orElse(null);
	}

	@Override
	public Gif mettreAJourLegende(Gif gif, String nouvelleLegende) {
		gif.setLegende(nouvelleLegende);
		gifDao.save(gif);
		return gif;
	}

	@Override
	public Gif recupererGifParJour(Jour jour) {
		return gifDao.findLast1ByJour(jour);
	}

	@Override
	public List<Gif> recupererGifsParLegende(String legende) {
		return gifDao.findByLegendeContaining(legende);
	}

	@Override
	public List<Gif> recupererGifsParNbReactions() {
		return gifDao.findTopByReactions();
	}
	
}