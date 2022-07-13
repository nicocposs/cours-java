package fr.orsys.fx.calendrier_gif.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.exception.JourExistantException;
import fr.orsys.fx.calendrier_gif.exception.JourInexistantException;

public interface JourService {

	Jour ajouterJour(LocalDate date) throws JourExistantException;
	
	Jour ajouterJour(Jour jour) throws JourExistantException;
	
	Jour enregistrerJour(Jour jour);
	
	/**
	 * Cette méthode renvoie la liste exhaustive des jours stockés dans la table jour
	 * @return
	 */
	List<Jour> recupererJours();
	
	Jour recupererJour(LocalDate localDate);
	
	/**
	 * Cette méthode renvoie une page de jours
	 * 
	 * @param pageable (object qui correspond à une demande de page)
	 * @return une page de jours
	 */
	Page<Jour> recupererJours(Pageable pageable);

	List<Jour> recupererJoursDuMoisEnCours();

	LocalDate recupererDerniereDate();

	Jour recupererDernierJour();

	Jour mettreAJour(LocalDate date, int nouveauNbPoints) throws JourInexistantException;

	boolean supprimerJour(LocalDate date);

	long compterJours();

}