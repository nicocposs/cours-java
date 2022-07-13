package fr.orsys.fx.calendrier_gif.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.fx.calendrier_gif.business.Emotion;
import fr.orsys.fx.calendrier_gif.business.Gif;
import fr.orsys.fx.calendrier_gif.business.Reaction;

public interface ReactionDao extends JpaRepository<Reaction, Long> {

	void deleteAllByEmotion(Emotion emotion);

	List<Reaction> findByGif(Gif gif);

}
