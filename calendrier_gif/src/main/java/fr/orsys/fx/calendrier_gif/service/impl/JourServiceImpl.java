package fr.orsys.fx.calendrier_gif.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.dao.JourDao;
import fr.orsys.fx.calendrier_gif.exception.JourExistantException;
import fr.orsys.fx.calendrier_gif.service.JourService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JourServiceImpl implements JourService{

	private JourDao jourDao;
	@Override
	public List<Jour> recupererJours() {
		return jourDao.findAll();
	}

	@Override
	public Jour recupererJour(LocalDate localDate) {
		return jourDao.findByDate(localDate);
	}

	@Override
	public Page<Jour> recupererJours(Pageable pageable) {
		return jourDao.findAll(pageable);
	}

	@Override
	public Jour recupererDernierJour() {
		return jourDao.findTopByOrderByDateDesc();
	}

	@Override
	public Jour ajouterJour(Jour j) {
		return jourDao.save(j);
	}
	
    @Override
    public Jour ajouterJour(LocalDate date) throws JourExistantException {
        if (jourDao.existsById(date)) {
            throw new JourExistantException("Ce jour est déjà présent en base");
        }
        
        return ajouterJour(new Jour(date));
    }

}
