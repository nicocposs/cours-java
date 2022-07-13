package fr.orsys.fx.calendrier_gif.controller.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.service.JourService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/jour/")
public class JourRestController {
	
	private final JourService jourService;
	
	@GetMapping("jours")
	@Operation(summary = "Get jours",
    description = "Get list of jours")
	public List<Jour> jourGet(){
		return jourService.recupererJours();
	}
	
	@GetMapping("jours/{id}")
	public Jour jourGetById(@PathVariable String id){
		LocalDate date = LocalDate.parse(id);
		return jourService.recupererJour(date);
	}
	
	@PostMapping("jours")
	@ResponseStatus(HttpStatus.CREATED)
	public Jour jourPost(@RequestBody Jour jour){
		return jourService.ajouterJour(jour);
	}
	
	@DeleteMapping("jours/{id}")
	public boolean jourDelete(@PathVariable String id){
		LocalDate date = LocalDate.parse(id);
		return jourService.supprimerJour(date);
	}
	
	@PutMapping("jours")
	public Jour jourPut(@RequestBody Jour jour){
		return jourService.mettreAJour(jour.getDate(), jour.getNbPoints());
	}
}
