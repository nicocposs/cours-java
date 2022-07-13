package fr.orsys.fx.calendrier_gif.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.orsys.fx.calendrier_gif.business.Utilisateur;
import lombok.AllArgsConstructor;


public interface UtilisateurService {
	List<Utilisateur> recupererUtilisateurs();
	
	Utilisateur recupererUtilisateur(String email, String motDePasse);
	
	Page<Utilisateur> recupererUtilisateurs(Pageable pageable);

	void enregistrerUtilisateur(@Valid Utilisateur utilisateur);

	void sauvegarderChangements(Utilisateur u);
}
