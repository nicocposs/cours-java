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
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Jour {
	Random random = new Random();
	@Id
	@NonNull
	private LocalDate date;
	
	private int nbPoints;
	
	@OneToOne
	private Gif gif;
	
	public Jour(LocalDate date) {
		this.date = date;
		this.nbPoints = random.nextInt(30);
	}
	
	
}
