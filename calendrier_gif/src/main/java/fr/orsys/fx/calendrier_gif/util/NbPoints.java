package fr.orsys.fx.calendrier_gif.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NbPoints {
	private int annee;
    private int mois;
    private int nbPoints;
    
    public NbPoints(int annee, int mois, Double nbPoints) {
    	this.annee = annee;
    	this.mois = mois;
    	this.nbPoints = nbPoints.intValue();
    }
}
