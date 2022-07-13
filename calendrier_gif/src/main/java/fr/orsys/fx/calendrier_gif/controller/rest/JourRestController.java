package fr.orsys.fx.calendrier_gif.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.service.JourService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/jour/")
public class JourRestController {
	
	private final JourService jourService;
	
	@GetMapping("jours")
	public List<Jour> jourGet(){
		return jourService.recupererJours();
	}
	

}
