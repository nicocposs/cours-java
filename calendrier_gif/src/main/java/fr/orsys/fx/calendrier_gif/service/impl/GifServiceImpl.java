package fr.orsys.fx.calendrier_gif.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import fr.orsys.fx.calendrier_gif.business.Gif;
import fr.orsys.fx.calendrier_gif.business.GifDistant;
import fr.orsys.fx.calendrier_gif.business.GifTeleverse;
import fr.orsys.fx.calendrier_gif.business.Utilisateur;
import fr.orsys.fx.calendrier_gif.dao.GifDao;
import fr.orsys.fx.calendrier_gif.service.GifService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GifServiceImpl implements GifService {

	private final GifDao gifDao;
	
	@Override
	public GifDistant ajouterGifDistant(GifDistant gifDistant, Utilisateur utilisateur) {
		gifDistant.setUtilisateur(utilisateur);
		return gifDao.save(gifDistant);
	}

	@Override
	public GifTeleverse ajouterGifTeleverse(LocalDate localDate, Utilisateur utilisateur, String legende,
			String nomFichierOriginal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gif recupererGif(Long id) {
		return gifDao.findById(id).orElse(null);
	}

	@Override
	public GifTeleverse ajouterGifTeleverse(GifTeleverse gifTeleverse) {
		return gifDao.save(gifTeleverse);
	}

}
