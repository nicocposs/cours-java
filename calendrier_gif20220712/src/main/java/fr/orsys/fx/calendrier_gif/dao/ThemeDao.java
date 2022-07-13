package fr.orsys.fx.calendrier_gif.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import fr.orsys.fx.calendrier_gif.business.Theme;

public interface ThemeDao extends JpaRepository<Theme, Long> {

	/**
	 * Cette méthode est annotée @Query (élément de Spring Data)
	 * 
	 * Entre les parenthèses de l'annotation @Query Spring Data
	 * attend par défaut une requête HQL (Hibernate Query Language)
	 * 
	 * @return
	 */
	@Query("SELECT nom FROM Theme WHERE nom like 'B%'")
	List<String> findByThemeStartingWithB();
}
