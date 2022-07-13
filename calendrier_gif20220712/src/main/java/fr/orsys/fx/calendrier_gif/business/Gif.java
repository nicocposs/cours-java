package fr.orsys.fx.calendrier_gif.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public abstract class Gif {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	protected LocalDateTime dateHeureAjout;
	
	protected String legende;
	
	@OneToOne
	@JoinColumn(unique = true)
	@JsonIgnore
	protected Jour jour;
	
	@ManyToOne
	protected Utilisateur utilisateur;

	@JsonIgnore
	@OneToMany(mappedBy="gif", fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	protected List<Reaction> reactions;
	
	public Gif() {
		dateHeureAjout = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return "Gif [id=" + id + ", dateHeureAjout=" + dateHeureAjout + ", legende=" + legende + ", jour=" + jour
				+ ", utilisateur=" + utilisateur.getPrenom() + "]";
	}

}