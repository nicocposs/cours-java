package fr.orsys.fx.calendrier_gif.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.orsys.fx.calendrier_gif.business.Theme;

public interface ThemeService {
	List<Theme> recupererThemes();
	
	Theme recupererTheme(String nom);
	
	Page<Theme> recupererTheme(Pageable pageable);
}
