package fr.orsys.fx.calendrier_gif.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.orsys.fx.calendrier_gif.business.Utilisateur;
import fr.orsys.fx.calendrier_gif.service.ThemeService;
import fr.orsys.fx.calendrier_gif.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UtilisateurController {

	/// On déclare les dépendances du contrôleur
	private final UtilisateurService utilisateurService;
	private final ThemeService themeService;
	
	private final HttpSession httpSession;

	@GetMapping(value = { "/index", "/" })
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView connexionGet() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	// Cette méthode du contrôleur est annotée @PostMapping (annotation de Spring 4.3 en 2016)
	// car le formulaire HTML utilise la méthode post : via l'attribut method de la balise form
	// <form action="connexion" method="post">
	// En post : on envoie les données saisies sur le formulaire HTML dans le corps de la requête
	// En cliquant sur le bouton "Connexion", la requête HTTP est envoyée vers l'URL connexion
	// c'est pour cette raison que l'attribut value est égal à connexion
	@PostMapping(value = "connexion")
	public ModelAndView connexionPost(@RequestParam("EMAIL") String email,
									  @RequestParam("MOT_DE_PASSE") String motDePasse) {
		
		// On essaie de récupérer l'utilisateur avec les infos saisies sur le formulaire HTML de connexion
		Utilisateur utilisateur = utilisateurService.recupererUtilisateur(email, motDePasse);

		if (utilisateur == null) {
			ModelAndView mav = new ModelAndView("redirect:index");
			mav.addObject("notification", "Mot de passe et/ou email incorrect");
			return mav;
		} else {
			// L'utilisateur a fourni les bonnes informations (email et mot de passe)

			// On ajoute en session HTTP l'objet utilisateur
			httpSession.setAttribute("utilisateur", utilisateur);

			// On redirige vers l'URL calendrier
			// équivalent de ce que l'on faisait à l'époque de Jakarta Enteprise en écrivant :
			// response.sendRedirect("calendrier");
			// Après le mot redirect, on fait référence à une URL et non pas à une vue
			ModelAndView mav = new ModelAndView("redirect:calendrier");
			return mav;
		}
	}
	
	@GetMapping("inscription")
	public ModelAndView inscriptionGet(@ModelAttribute Utilisateur utilisateur) {
		ModelAndView mav = new ModelAndView("inscription");
		mav.addObject("themes", themeService.recupererThemes());
		return mav;
	}

	@PostMapping("inscription")
	public ModelAndView inscriptionPost(@Valid @ModelAttribute Utilisateur utilisateur, BindingResult result) {
		if (result.hasErrors()) {
			// La validation de l’objet utilisateur par rapport aux contraintes
			// de validation définies dans la classe métier Utilisateur a produit
			// des erreurs
			return inscriptionGet(utilisateur);
		} else {
			utilisateurService.enregistrerUtilisateur(utilisateur);
			// On redirige pour éviter que l'internaute renvoie sa requête POST (en appuyant sur F5)
			// En faisant une redirection on perd l'intégralité du model
			ModelAndView mav = new ModelAndView("redirect:index");
			// Avec une redirection, les objets seront transmis en paramètre de l'URL
			mav.addObject("notification", "Utilisateur ajouté");
			return mav;	

		}
	}

}