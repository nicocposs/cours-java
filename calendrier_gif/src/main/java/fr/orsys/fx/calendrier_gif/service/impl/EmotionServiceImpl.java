package fr.orsys.fx.calendrier_gif.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.orsys.fx.calendrier_gif.business.Emotion;
import fr.orsys.fx.calendrier_gif.dao.EmotionDao;
import fr.orsys.fx.calendrier_gif.dao.ReactionDao;
import fr.orsys.fx.calendrier_gif.exception.EmotionExistanteException;
import fr.orsys.fx.calendrier_gif.service.EmotionService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EmotionServiceImpl implements EmotionService {

	private final EmotionDao emotionDao;
	private final ReactionDao reactionDao;	

	@Override
	public Emotion ajouterEmotion(String nom, String code) {
		return emotionDao.save(new Emotion(nom, code));
	}

	@Override
    public Emotion ajouterEmotion(Emotion emotion) {
        if (emotionDao.findByCode(emotion.getCode())!=null) {
            throw new EmotionExistanteException("Le code de l'émotion est déjà présent en base");
        }
        return emotionDao.save(emotion);
    }
	
	@Override
	public List<Emotion> recupererEmotions() {
		// Cette méthode se contente d'invoquer la méthode findAll sur l'objet emotionDao
		return emotionDao.findAll();
	}

	@Override
	public Emotion recupererEmotion(Long id) {
		return emotionDao.findById(id).orElse(null);
	}

	@Override
	public Emotion recupererEmotion(String nom) {
		return emotionDao.findByNom(nom);
	}

	@Override
	public Emotion mettreAJourEmotion(Long id, String nom, String code) {
		Emotion emotion = recupererEmotion(id);
		emotion.setNom(nom);
		emotion.setCode(code);
		return emotionDao.save(emotion);
	}

	@Override
	@Transactional
	public boolean supprimerEmotion(Long id) {
		Emotion emotion = recupererEmotion(id);
		if (emotion==null) {
			return false;
		} else {
			reactionDao.deleteAllByEmotion(emotion);
			emotionDao.delete(emotion);
			return true;
		}
	}

	@Override
	public Emotion enregistrerEmotion(Emotion emotion) {
		// TODO Auto-generated method stub
		return null;
	}

}
