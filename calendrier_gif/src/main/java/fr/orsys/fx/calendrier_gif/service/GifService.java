package fr.orsys.fx.calendrier_gif.service;

import java.time.LocalDate;

import fr.orsys.fx.calendrier_gif.business.Gif;
import fr.orsys.fx.calendrier_gif.business.GifDistant;
import fr.orsys.fx.calendrier_gif.business.GifTeleverse;
import fr.orsys.fx.calendrier_gif.business.Utilisateur;

public interface GifService {

    GifDistant ajouterGifDistant(GifDistant gifDistant, Utilisateur utilisateur);

    GifTeleverse ajouterGifTeleverse(LocalDate localDate, Utilisateur utilisateur, String legende, String nomFichierOriginal);
    
    GifTeleverse ajouterGifTeleverse(GifTeleverse gifTeleverse);
    
    Gif recupererGif(Long id);
}
