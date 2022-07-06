package fr.orsys.fx.calendrier_gif.business;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class GifDistant extends Gif {
	@NotNull(message = "Merci de saisir une URL")
	@NotBlank(message = "Merci de saisir une URL")
	@URL(message = "Merci de saisir une URL valide, elle doit se terminer par .gif, .Gif ou .GIF", regexp = "^https?://(?:[a-z0-9\\-]+\\.)+[a-z]{2,6}(?:/[^/#?]+)+\\.(?:Gif|gif|GIF)$")
	private String url;

}
