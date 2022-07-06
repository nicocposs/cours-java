package fr.orsys.fx.calendrier_gif.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.orsys.fx.calendrier_gif.business.Gif;
import fr.orsys.fx.calendrier_gif.util.NbGifs;

public interface GifDao extends JpaRepository<Gif, Long> {
	@Query("FROM Gif g ORDER BY size(g.reactions) DESC")
	List<Gif> findGifsByReactionsDesc();
	
	@Query(value = "SELECT new fr.orsys.fx.calendrier_gif.util.NbGifs(year(g.dateHeureAjout), month(g.dateHeureAjout), COUNT(*) as nbgifs) FROM Gif g GROUP BY year(g.dateHeureAjout), month(g.dateHeureAjout)")
	 List<NbGifs> findNbGifs();
}
