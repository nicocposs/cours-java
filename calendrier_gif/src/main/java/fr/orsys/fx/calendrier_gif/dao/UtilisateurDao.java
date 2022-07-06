package fr.orsys.fx.calendrier_gif.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.orsys.fx.calendrier_gif.business.Utilisateur;
import fr.orsys.fx.calendrier_gif.util.NbInscrits;

public interface UtilisateurDao extends JpaRepository<Utilisateur,Long> {

	 @Query(value="FROM Utilisateur WHERE theme.nom = 'Dark'")
	 List<Utilisateur> findUsersHavingChosenDarkTheme();
	  
	 @Query(value = "FROM Utilisateur WHERE id NOT IN (SELECT DISTINCT utilisateur.id FROM Gif)")
	 List<Utilisateur> findNonContribuitingUsers();
	  
	 @Query(value="FROM Utilisateur ORDER BY prenom")
	 List<Utilisateur> findAllUsersSortedByPrenom();
	  
	 //  Requête HQL qui donne le nom et le prénom des utilisateurs s’étant inscrits au mois de juillet 2022 et dont l’adresse email email se termine par @orsys.fr
	 @Query("FROM Utilisateur WHERE month(dateHeureInscription)='7' AND year(dateHeureInscription)='2022' AND email LIKE '%@orsys.fr'")
	 List<Utilisateur> findInscriptionJulyUsers();
	 
	 @Query("FROM Utilisateur WHERE email=:email AND motDePasse=:motDePasse")
	 Utilisateur findUserByEmailAndPassword(@Param("email") String email, @Param("motDePasse") String motDePasse);
	 
	 @Query(value = "SELECT new fr.orsys.fx.calendrier_gif.util.NbInscrits(year(u.dateHeureInscription), month(u.dateHeureInscription), COUNT(*) as nbutilisateurs) FROM Utilisateur u GROUP BY year(u.dateHeureInscription), month(u.dateHeureInscription)")
	 List<NbInscrits> findNbInscrits();
}
