package fr.orsys.fx.calendrier_gif.automatism;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.service.JourService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JourAutomatism {

	JourService jourService;
	
	
	private void ajouterNouveauJour() {
		Jour j = jourService.recupererDernierJour();
		Jour j2 = new Jour();
		j2.setDate(j.getDate().plusDays(1));
		System.out.println(j2);
		jourService.ajouterJour(j2);
	}
}
