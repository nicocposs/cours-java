package fr.orsys.fx.calendrier_gif.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.orsys.fx.calendrier_gif.business.Theme;

public interface ThemeDao extends JpaRepository<Theme, Long> {

	@Query("FROM Theme WHERE nom LIKE 'B%'")
	List<Theme> findByThemeStartingWithB();
	
	@Query("FROM Theme WHERE nom=:nom")
	Theme findThemeByNom(@Param("nom") String nom);
}
