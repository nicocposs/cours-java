package fr.orsys.fx.calendrier_gif.automatisme;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.exception.JourExistantException;
import fr.orsys.fx.calendrier_gif.service.JourService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JourAutomatisme {

	private JourService jourService;
	
	@Scheduled(cron="0 * * * * *")
	private void ajouterJourVersion1() {
		LocalDate derniereDate = jourService.recupererDerniereDate();
		try {
			jourService.ajouterJour(derniereDate.plusDays(1));
		}
		catch (JourExistantException e) {
			System.out.println("Ce jour ne peut pas être ajouté car il est déjà présent en base");
		}
	}
	
	@Scheduled(cron="30 * * * * *")
	private void ajouterJourVersion2() {		
		Jour jour = jourService.recupererDernierJour();
		try {
			jourService.ajouterJour(jour.getDate()//
					// Alternative : 
					.plus(1, ChronoUnit.DAYS)
					.plusDays(1));
		}
		catch (JourExistantException e) {
			System.out.println("Ce jour ne peut pas être ajouté car il est déjà présent en base");
		}	
	}

}
