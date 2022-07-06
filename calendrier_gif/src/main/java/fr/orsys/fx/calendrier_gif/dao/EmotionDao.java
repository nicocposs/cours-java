package fr.orsys.fx.calendrier_gif.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.orsys.fx.calendrier_gif.business.Emotion;

public interface EmotionDao extends JpaRepository<Emotion, Long> {

	List<Emotion> findFirst2ByNomContaining(String nom);
	
	// L'annotation @Query accueille par défaut une requête HQL
	@Query("FROM Emotion WHERE nom LIKE 's%'")
	List<Emotion> findEmotionsHavingNameStartingWithS();

	// Requête par dérivation : il n'y a pas d'annotation @Query, par conséquent
	// Spring Data essaie de construire une requête HQL en analysant le nom 
	// de la méthode Java
	Emotion findByNom(String nom);
}
