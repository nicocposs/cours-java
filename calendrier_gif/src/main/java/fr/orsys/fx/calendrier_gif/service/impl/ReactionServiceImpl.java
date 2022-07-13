package fr.orsys.fx.calendrier_gif.service.impl;

import org.springframework.stereotype.Service;

import fr.orsys.fx.calendrier_gif.business.Reaction;
import fr.orsys.fx.calendrier_gif.dao.ReactionDao;
import fr.orsys.fx.calendrier_gif.service.ReactionService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReactionServiceImpl implements ReactionService {
	ReactionDao reactionDao;
	
	@Override
	public Reaction ajouterReaction(Reaction reaction) {
		return reactionDao.save(reaction);
	}

}
