package fr.orsys.fx.calendrier_gif.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.orsys.fx.calendrier_gif.business.Gif;
import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.business.Utilisateur;

public interface GifDao extends JpaRepository<Gif, Long> {

	@Query("SELECT gif FROM Reaction r GROUP BY r.gif ORDER BY count(*) DESC")
	List<Gif> findTopReactions();

//	@Query(value = "FROM Gif g ORDER BY size(g.reactions) DESC")
	@Query("SELECT gif FROM Reaction r GROUP BY r.gif ORDER BY count(*) DESC")
	List<Gif> findTopByReactions();
	
	List<Gif> findByUtilisateur(Utilisateur utilisateur);
	
	List<Gif> findByUtilisateurId(Long id);
	
	List<Gif> findByUtilisateurNom(String nom);

	Gif findLast1ByJour(Jour jour);

	List<Gif> findByLegendeContaining(String legende);
}
