package fr.orsys.fx.calendrier_gif.business;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Jour {

	private static Random random = new Random();
	
	@Id
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate date;
	
	@Min(value=20, message="Le nombre de points doit être supérieur ou égale à 20")
	@Max(value=50, message="Le nombre de points doit être inférieur ou égale à 50")
	private int nbPoints;
	
	@JsonIgnore
	@OneToOne(mappedBy = "jour", cascade = CascadeType.REMOVE)
	private Gif gif;

	public Jour(LocalDate date) {
		this(date, 20 + random.nextInt(31));
	}

	public Jour(LocalDate date, int nbPoints) {
		this.date = date;
		this.nbPoints = nbPoints;
	}

	public String toString() {
		return date.getDayOfMonth() + "/" +  date.getMonthValue();
	}
	
}