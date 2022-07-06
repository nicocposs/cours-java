package fr.orsys.fx.calendrier_gif.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Gif {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@NonNull
	protected LocalDateTime dateHeureAjout;
	
	@NonNull
	protected String legende;
	
	@OneToOne
	protected Jour jour;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy="gif")
	@ToString.Exclude
	private List<Reaction> reactions;
	
	
}
