package fr.orsys.fx.calendrier_gif.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.fx.calendrier_gif.business.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {

	// Requête par dérivation
	Utilisateur findByEmailAndMotDePasse(String email, String motDePasse);

}
