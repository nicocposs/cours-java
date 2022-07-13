package fr.orsys.fx.calendrier_gif.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.orsys.fx.calendrier_gif.business.Theme;
import fr.orsys.fx.calendrier_gif.dao.ThemeDao;
import fr.orsys.fx.calendrier_gif.service.ThemeService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ThemeServiceImpl implements ThemeService {

	private ThemeDao themeDao;
	
	@Override
	public List<Theme> recupererThemes() {
		return themeDao.findAll();
	}

}
