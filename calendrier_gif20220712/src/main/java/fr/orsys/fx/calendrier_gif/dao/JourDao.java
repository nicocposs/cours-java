package fr.orsys.fx.calendrier_gif.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.business.Utilisateur;

public interface JourDao extends JpaRepository<Jour, LocalDate> {

	Jour findByDate(LocalDate localDate);

	List<Jour> findByGifUtilisateur(Utilisateur utilisateur);

	List<Jour> findByGifIsNull();

	List<Jour> findByNbPoints(int nbPoints);

	List<Jour> findByGifIsNullAndNbPointsGreaterThanEqual(int min);

	List<Jour> findByGifIsNullAndNbPointsGreaterThanEqualAndDateBefore(int min, LocalDate date);

	@Query("FROM Jour WHERE month(date)=month(current_date()) AND year(date)=year(current_date())")
	List<Jour> findDaysOfCurrentMonth();

	@Query("SELECT max(date) FROM Jour")
	LocalDate findLastDate();

	// Requête par dérivation
	Jour findFirstByOrderByDateDesc();

}
