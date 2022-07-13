package fr.orsys.fx.calendrier_gif.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.orsys.fx.calendrier_gif.business.Emotion;
import fr.orsys.fx.calendrier_gif.business.Gif;
import fr.orsys.fx.calendrier_gif.business.Reaction;
import fr.orsys.fx.calendrier_gif.business.Utilisateur;
import fr.orsys.fx.calendrier_gif.dao.EmotionDao;
import fr.orsys.fx.calendrier_gif.dao.ReactionDao;
import fr.orsys.fx.calendrier_gif.service.GifService;
import fr.orsys.fx.calendrier_gif.service.ReactionService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReactionServiceImpl implements ReactionService {

	private EmotionDao emotionDao;
	private GifService gifService;
	private ReactionDao reactionDao;

	@Override
	public Reaction ajouterReaction(Long idGif, Long idEmotion, Utilisateur utilisateur) {
		Emotion emotion = emotionDao.findById(idEmotion).orElse(null);
		Gif gif = gifService.recupererGif(idGif);
		Reaction reaction = new Reaction();
		reaction.setGif(gif);
		reaction.setUtilisateur(utilisateur);
		reaction.setEmotion(emotion);
		reactionDao.save(reaction);
		return reaction;
	}

	@Override
	public List<Reaction> recupererReactions(Gif gif) {	
		return reactionDao.findByGif(gif);
	}

	@Override
	public boolean supprimerReaction(Long id) {
		if (reactionDao.existsById(id)) {
			reactionDao.deleteById(id);
			return true;
		}
		return false;
	}
}
