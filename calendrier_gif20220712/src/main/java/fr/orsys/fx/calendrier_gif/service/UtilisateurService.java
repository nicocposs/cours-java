package fr.orsys.fx.calendrier_gif.service;

import javax.validation.Valid;

import fr.orsys.fx.calendrier_gif.business.Utilisateur;

public interface UtilisateurService {

	Utilisateur recupererUtilisateur(String email, String motDePasse);

	Utilisateur enregistrerUtilisateur(@Valid Utilisateur utilisateur);
}
