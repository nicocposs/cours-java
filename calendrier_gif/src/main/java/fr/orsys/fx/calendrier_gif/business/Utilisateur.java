package fr.orsys.fx.calendrier_gif.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
@Entity
@AllArgsConstructor
@Data
public class Utilisateur {
	private static final int NB_POINTS_INITIAL = 500;
	
	public Utilisateur() {
		this.nbPoints = NB_POINTS_INITIAL;
		this.dateHeureInscription = LocalDateTime.now();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@NonNull
	private String nom;
	@NotBlank(message="Merci de préciser votre prénom")
	@NonNull
	private String prenom;
	    
	@NonNull
	@Email(message="Merci de préciser une adresse email au bon format")
	@NotBlank(message="Merci de préciser une adresse email")
	@Column(unique=true)
	@Pattern(regexp="^([A-Za-z0-9-])+(.[A-Za-z0-9-]+)*@orsys.fr$", message="Votre adresse doit faire partie du nom de domaine orsys.fr")
	private String email;
	@NonNull
	private String motDePasse;
	private int nbPoints;
	private LocalDateTime dateHeureInscription;
	
	@ManyToOne
	private Theme theme;
	
	@OneToMany(mappedBy="utilisateur")
	@ToString.Exclude
	private List<Gif> gifs;
}
