package fr.orsys.fx.calendrier_gif.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.orsys.fx.calendrier_gif.business.Emotion;
import fr.orsys.fx.calendrier_gif.dao.EmotionDao;
import fr.orsys.fx.calendrier_gif.service.EmotionService;

@Component // Spring va déduire que cette classe est un service
public class EmotionServiceImpl implements EmotionService {

	private final EmotionDao emotionRepository;
	
	public EmotionServiceImpl(EmotionDao emotionDao) {
		super();
		this.emotionRepository = emotionDao;
	}

	@Override
	public Emotion ajouterEmotion(String nom, String code) {
		return emotionRepository.save(new Emotion(nom, code));
	}

	@Override
	public List<Emotion> recupererEmotions() {
		// Cette méthode se contente d'invoquer la méthode findAll sur l'objet emotionDao
		return emotionRepository.findAll();
	}

	@Override
	public Emotion recupererEmotion(Long id) {
		return emotionRepository.findById(id).orElse(null);
	}

	@Override
	public Emotion recupererEmotion(String nom) {
		return emotionRepository.findByNom(nom);
	}

	@Override
	public Emotion ajouterEmotion(Emotion emotion) {
		return emotionRepository.save(emotion);
	}

	@Override
	public Emotion mettreAJourEmotion(Long id, String nom, String code) {
		Emotion emotion = recupererEmotion(id);
		emotion.setNom(nom);
		emotion.setCode(code);
		return emotionRepository.save(emotion);
	}

	@Override
	public boolean supprimerEmotion(Long id) {
		Emotion emotion = recupererEmotion(id);
		if (emotion==null) {
			return false;
		} else {
			emotionRepository.delete(emotion);
			return true;
		}
	}

	@Override
	public Emotion enregistrerEmotion(Emotion emotion) {
		// TODO Auto-generated method stub
		return null;
	}

}
