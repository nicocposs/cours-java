package fr.orsys.series.business;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Abonne extends Utilisateur {
	private LocalDate dateDeNaissance;
	
	@ManyToMany(mappedBy = "abonnes")
	@Size(min = 1)
	private List<Interet> interet;
}