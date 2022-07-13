package fr.orsys.fx.calendrier_gif.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import fr.orsys.fx.calendrier_gif.business.Theme;
import fr.orsys.fx.calendrier_gif.dao.ThemeDao;
import fr.orsys.fx.calendrier_gif.service.ThemeService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ThemeServiceImpl implements ThemeService {
	private ThemeDao themeDao;
	@Override
	public List<Theme> recupererThemes() {
		return themeDao.findAll();
	}

	@Override
	public Theme recupererTheme(String nom) {
		return themeDao.findThemeByNom(nom);
	}

	@Override
	public Page<Theme> recupererTheme(Pageable pageable) {
		return themeDao.findAll(pageable);
	}

}
