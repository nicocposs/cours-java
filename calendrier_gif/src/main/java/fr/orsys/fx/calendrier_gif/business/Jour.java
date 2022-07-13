package fr.orsys.fx.calendrier_gif.business;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Jour {
	Random random = new Random();
	@Id
	@NonNull
	private LocalDate date;
	
	private int nbPoints;
	
	@OneToOne(mappedBy = "jour")
	@ToString.Exclude
	private Gif gif;
	
	public Jour() {
		this.nbPoints = random.nextInt(30);
	}
	
	public Jour(LocalDate date) {
		this.date = date;
		this.nbPoints = random.nextInt(30);
	}
	
	
}
