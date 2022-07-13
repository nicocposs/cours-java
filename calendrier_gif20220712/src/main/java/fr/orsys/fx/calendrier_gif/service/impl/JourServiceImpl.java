package fr.orsys.fx.calendrier_gif.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.dao.JourDao;
import fr.orsys.fx.calendrier_gif.exception.JourExistantException;
import fr.orsys.fx.calendrier_gif.exception.JourInexistantException;
import fr.orsys.fx.calendrier_gif.service.JourService;
import lombok.AllArgsConstructor;

@Service
//@Component
@AllArgsConstructor
@Transactional
public class JourServiceImpl implements JourService {

	// On définit les dépendances de ce service
	private JourDao jourDao;

	@Override
	public Jour ajouterJour(LocalDate date) throws JourExistantException {
		if (jourDao.existsById(date)) {
			throw new JourExistantException("Ce jour est déjà présent en base");
		}
		
		return ajouterJour(new Jour(date));
	}

	@Override
	public Jour ajouterJour(Jour jour) throws JourExistantException {
		if (jourDao.existsById(jour.getDate())) {
			throw new JourExistantException("Ce jour est déjà présent en base");
		}

		return jourDao.save(jour);
	}

	@Override
	public Jour enregistrerJour(Jour jour) {
		return jourDao.save(jour);
	}

	/**
	 * S'il y a un paramètre de type Pageable
	 * La méthode doit renvoyer un objet de type Page
	 * 
	 */
	@Override
	public Page<Jour> recupererJours(Pageable pageable) {
		return jourDao.findAll(pageable);
	}

	@Override
	public List<Jour> recupererJours() {
		return jourDao.findAll();
	}

	@Override
	public Jour recupererJour(LocalDate localDate) {
		return jourDao.findById(localDate).orElse(null);
	}

	@Override
	public List<Jour> recupererJoursDuMoisEnCours() {
		return jourDao.findDaysOfCurrentMonth();
	}

	@Override
	public LocalDate recupererDerniereDate() {
		return jourDao.findLastDate();
	}
	
	@Override
	public Jour recupererDernierJour() {
		return jourDao.findFirstByOrderByDateDesc();
	}

	@Override
	public Jour mettreAJour(LocalDate date, int nouveauNbPoints) throws JourInexistantException {
		if (!jourDao.existsById(date)) {
			throw new JourInexistantException("Ce jour n'est pas présent en base");
		}
		Jour jour = recupererJour(date);
		jour.setNbPoints(nouveauNbPoints);
		return enregistrerJour(jour);
	}

	@Override
	public boolean supprimerJour(LocalDate date) {
		Jour jour = recupererJour(date);
		if (jour==null) {
			return false;
		}
		jourDao.delete(jour);
		return true;
	}
	
	@Override
	public long compterJours() {
		return jourDao.count();
	}

}