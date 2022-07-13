package fr.orsys.fx.calendrier_gif.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.exception.JourExistantException;

public interface JourService {
	List<Jour> recupererJours();
	
	Jour recupererJour(LocalDate localDate);
	
	Page<Jour> recupererJours(Pageable pageable);

	Jour recupererDernierJour();

	Jour ajouterJour(Jour j);

	Jour ajouterJour(LocalDate date) throws JourExistantException;
}
