package fr.orsys.fx.calendrier_gif.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.business.Utilisateur;
import fr.orsys.fx.calendrier_gif.util.NbPoints;

public interface JourDao extends JpaRepository<Jour, LocalDate> {
	@Query("FROM Jour WHERE month(date)=month(current_date()) AND year(date)=year(current_date())")
	List<Jour> findDaysOfCurrentMonth();
	
	@Query("SELECT max(date) FROM Jour")
	LocalDate findLastEntry();
	
	@Query("FROM Jour ORDER BY RAND()")
	List<Jour> findAllByRandom();
	
	@Query("FROM Jour ORDER BY date DESC")
	List<Jour> findAllDaysDesc();
	
	@Query(value = "SELECT new fr.orsys.fx.calendrier_gif.util.NbPoints(year(j.date), month(j.date), avg(j.nbPoints) as nbpoints) FROM Jour j WHERE month(j.date)=:mois AND year(j.date)=:annee GROUP BY year(j.date), month(j.date)")
	NbPoints findNbPoints(@Param("mois") int mois, @Param("annee") int annee);
	
	@Query("SELECT avg(j.nbPoints) FROM Jour j GROUP BY year(j.date), month(j.date)")
    Integer findAverageOfPoints(@Param("annee") int annee, @Param("mois") int mois);
	
	List<Jour> findByGifUtilisateur(Utilisateur utilisateur);

    List<Jour> findByGifIsNull();

    List<Jour> findByNbPoints(int nbPoints);

    List<Jour> findByGifIsNullAndNbPointsGreaterThanEqual(int min);

    List<Jour> findByGifIsNullAndNbPointsGreaterThanEqualAndDateBefore(int min, LocalDate date);
}
