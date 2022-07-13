package fr.orsys.fx.calendrier_gif.business;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
/**
 * Classe métier (correspond à un concept que le client nous présente)
 * @author fxcote
 *
 */
public class Emotion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message="Merci de donner un nom à l''émotion")
	private String nom;

	@Size(max=10, message="Le code de l''émotion ne peut pas excéder 10 caractères")
	private String code;
	
	private String description;
	
	private LocalDate dateAjout;
	
	public Emotion(String nom, String code) {
		this.nom = nom;
		this.code = code;
	}

}