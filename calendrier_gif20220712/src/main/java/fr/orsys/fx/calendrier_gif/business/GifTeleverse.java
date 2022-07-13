package fr.orsys.fx.calendrier_gif.business;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class GifTeleverse extends Gif{
	
	private String nomFichierOriginal;
		
}