package fr.orsys.fx.calendrier_gif.business;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dateHeure;
	
	@ManyToOne
	@NotNull(message = "Veuillez choisir une emotion")
	private Emotion emotion;
	
	@ManyToOne
	private Gif gif;
	
	@ManyToOne
	private Utilisateur utilisateur;
}
