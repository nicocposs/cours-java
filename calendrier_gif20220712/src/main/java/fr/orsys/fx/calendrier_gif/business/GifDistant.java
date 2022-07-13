package fr.orsys.fx.calendrier_gif.business;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GifDistant extends Gif {

	public GifDistant(Utilisateur utilisateur, Jour jour, String string, String string2, LocalDateTime dateHeureAjout) {
		this.utilisateur=utilisateur;
		this.jour = jour;
		this.legende=string;
		this.url = string2;
	}

	@NotNull(message = "Merci de saisir une URL")
	@NotBlank(message = "Merci de saisir une URL")
	@URL(message = "Merci de saisir une URL valide, elle doit se terminer par .gif, .Gif ou .GIF", regexp = "^https?://(?:[a-z0-9\\-]+\\.)+[a-z]{2,6}(?:/[^/#?]+)+\\.(?:Gif|gif|GIF)$")
	private String url;
	
}