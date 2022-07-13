package fr.orsys.fx.calendrier_gif.service.impl;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import fr.orsys.fx.calendrier_gif.business.Utilisateur;
import fr.orsys.fx.calendrier_gif.dao.UtilisateurDao;
import fr.orsys.fx.calendrier_gif.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

	private UtilisateurDao utilisateurDao;
	
	@Override
	public Utilisateur recupererUtilisateur(String email, String motDePasse) {
		return utilisateurDao.findByEmailAndMotDePasse(email, motDePasse);
	}

	@Override
	public Utilisateur enregistrerUtilisateur(@Valid Utilisateur utilisateur) {
		return utilisateurDao.save(utilisateur);
	}

}
