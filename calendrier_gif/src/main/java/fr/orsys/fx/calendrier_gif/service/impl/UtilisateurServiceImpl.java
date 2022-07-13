package fr.orsys.fx.calendrier_gif.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.orsys.fx.calendrier_gif.business.Utilisateur;
import fr.orsys.fx.calendrier_gif.dao.UtilisateurDao;
import fr.orsys.fx.calendrier_gif.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService{
	private UtilisateurDao utilisateurDao;
	@Override
	public List<Utilisateur> recupererUtilisateurs() {
		return utilisateurDao.findAll();
	}

	@Override
	public Utilisateur recupererUtilisateur(String email, String motDePasse) {
		return utilisateurDao.findByEmailAndMotDePasse(email, motDePasse);
	}

	@Override
	public Page<Utilisateur> recupererUtilisateurs(Pageable pageable) {
		return utilisateurDao.findAll(pageable);
	}

	@Override
	public void enregistrerUtilisateur(@Valid Utilisateur utilisateur) {
		utilisateurDao.save(utilisateur);
		
	}

	@Override
	public void sauvegarderChangements(Utilisateur u) {
		utilisateurDao.save(u);
	}

}
