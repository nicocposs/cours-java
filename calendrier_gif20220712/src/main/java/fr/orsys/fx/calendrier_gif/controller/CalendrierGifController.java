package fr.orsys.fx.calendrier_gif.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.orsys.fx.calendrier_gif.business.GifDistant;
import fr.orsys.fx.calendrier_gif.business.GifTeleverse;
import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.business.Utilisateur;
import fr.orsys.fx.calendrier_gif.exception.JourDejaPrisException;
import fr.orsys.fx.calendrier_gif.service.EmotionService;
import fr.orsys.fx.calendrier_gif.service.GifService;
import fr.orsys.fx.calendrier_gif.service.JourService;
import fr.orsys.fx.calendrier_gif.service.ReactionService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CalendrierGifController {

	private static final int NB_JOURS_PAR_PAGE = 7;

	protected static final String DOSSIER_IMAGES = "src/main/webapp/images/";

	/// On déclare les dépendances du contrôleur
	private final EmotionService emotionService;
	private final JourService jourService;
	private final GifService gifService;
	private final ReactionService reactionService;
	
	private final HttpSession httpSession;
	
	@GetMapping("calendrier")
	public ModelAndView calendrier(@PageableDefault(page=0, size=NB_JOURS_PAR_PAGE) Pageable pageable) {
		ModelAndView mav = new ModelAndView();
		// On définit le nom de la vue (la crème dessert)
		// Le mav utilise la vue calendrier.jsp
		mav.setViewName("calendrier");
		
		// On ajoute un objet dans le compartiment à petites billes
		// Les attributs du mav seront envoyés à la vue calendrier.jsp
		// avant on écrivait : request.setAttribute("pageDeJours", jourService.recupererJours(pageable))
		mav.addObject("pageDeJours", jourService.recupererJours(pageable));
		
		// On met en session la page choisie
		if (pageable!=null) {
			httpSession.setAttribute("numeroDePage", pageable.getPageNumber());
		}

		return mav;
	}
	
	
	// Toutes les méthodes de ce conrôleur devront renvoyer un objet de type
	// ModelAndView
	// (métaphore de la Danette Pop)
	// On indique sur quelle(s) URL(s) la méthode va écouter
	// Autrement dit : quelle(s) sont la ou les URLs que la méthode prend en charge
	// Equivalent de @WebServlet
	@GetMapping("emotions")
	public ModelAndView emotions() {

		System.out.println(new Date());
		// On déclare et on instancie un objet de type ModelAndView
		ModelAndView mav = new ModelAndView();

		// On définit le nom de la vue (== crème dessert)
		// Equivalent de request.getRequestDispatcher("WEB-INF/index.jsp")
		mav.setViewName("emotions");

		// On ajoute dans le modèle la liste des nbs d'inscrits
		// Equivalent de request.setAttribute("nbInscrits",
		// utilisateurService.recupererNbInscrits())
		mav.addObject("emotions", emotionService.recupererEmotions());

		return mav;
	}

	/**
	 * Cette méthode redirige vers la vue emotion.jsp
	 * @return
	 */
	@GetMapping("emotion")
	public ModelAndView emotionGet() {
		System.out.println(new Date());
		return new ModelAndView("emotion");
	}
	
	@PostMapping("emotion")
	public ModelAndView emotionPost(@RequestParam("NOM") String nom, @RequestParam("CODE") String code) {
		emotionService.ajouterEmotion(nom, code);
		
		return new ModelAndView("redirect:emotions");
	}
	
	@GetMapping("calendrier/placerGifDistant")
	public ModelAndView placerGifDistantGet(@RequestParam("ID_JOUR") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate idJour,
			@ModelAttribute GifDistant gifDistant) {

		ModelAndView mav = new ModelAndView("placerGifDistant");
		Jour jour = jourService.recupererJour(idJour);
		// On associe le jour choisi au gif
		gifDistant.setJour(jour);
		return mav;
	}

	@PostMapping("calendrier/placerGifDistant")
	public ModelAndView placerGifDistantPost(@Valid @ModelAttribute GifDistant gifDistant, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView mav = placerGifDistantGet(gifDistant.getJour().getDate(), gifDistant);
			return mav;
		} else {
			Jour jour = gifDistant.getJour();
			Jour jourChoisi = jourService.recupererJour(jour.getDate());
			// On vérifie qu'il n'y a pas déja un gif sur ce jour
			if (jourChoisi.getGif() == null) {
				gifService.ajouterGifDistant(gifDistant, (Utilisateur) httpSession.getAttribute("utilisateur"));
			}
			if (httpSession.getAttribute("numeroDePage") != null) {
				return new ModelAndView("redirect:/calendrier?page=" + httpSession.getAttribute("numeroDePage"));
			} else {
				return new ModelAndView("redirect:/calendrier");
			}
		}
	}
	
	@PostMapping("calendrier/televerserGif")
    public ModelAndView televerserGifDistantGet(@RequestParam("ID_JOUR") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate idJour,
                                                @RequestParam("FICHIER") MultipartFile multipartFile,
                                                @RequestParam("LEGENDE") String legende) {        
        try {
            GifTeleverse gifTeleverse = gifService.ajouterGifTeleverse(idJour, (Utilisateur) httpSession.getAttribute("utilisateur"), legende, multipartFile.getOriginalFilename());
            enregisterFichier(gifTeleverse.getId() + ".gif", multipartFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JourDejaPrisException e) {
            return new ModelAndView("redirect:calendrier/jourDejaPris");
        }
        if (httpSession.getAttribute("numeroDePage")!=null)
        {
            return new ModelAndView("redirect:/calendrier?page=" + httpSession.getAttribute("numeroDePage"));
        }
        else {
            return new ModelAndView("redirect:/calendrier");
        }
    }


	@GetMapping("calendrier/reagir")
	public ModelAndView reagirGet(@RequestParam("ID_GIF") Long idGif) {		
		ModelAndView mav = new ModelAndView("reagir");
		mav.addObject("gif", gifService.recupererGif(idGif));
		mav.addObject("emotions", emotionService.recupererEmotions());
		return mav;
	}

	@PostMapping("calendrier/reagir")
	public ModelAndView reagirPost(@RequestParam("ID_GIF") Long idGif, @RequestParam("ID_EMOTION") Long idEmotion) {		
		reactionService.ajouterReaction(idGif, idEmotion, (Utilisateur) httpSession.getAttribute("utilisateur"));
		if (httpSession.getAttribute("numeroDePage")!=null)
		{
			return new ModelAndView("redirect:/calendrier?page=" + httpSession.getAttribute("numeroDePage"));
		}
		else {
			return new ModelAndView("redirect:/calendrier");
		}
	}
	
	@GetMapping("calendrier/televerserGif")
	public ModelAndView televerserGifDistantGet(@RequestParam("ID_JOUR") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate idJour) {		
		ModelAndView mav = new ModelAndView("televerserGif");
		mav.addObject("idJour", idJour);
		return mav;		
	}

	protected static void enregisterFichier(String nom, MultipartFile multipartFile) throws IOException {
		Path chemin = Paths.get(DOSSIER_IMAGES);
		multipartFile.getOriginalFilename();
		if (!Files.exists(chemin)) {
			Files.createDirectories(chemin);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path cheminFichier = chemin.resolve(nom);
			Files.copy(inputStream, cheminFichier, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Erreur d'écriture : " + nom, ioe);
		}
	}

}