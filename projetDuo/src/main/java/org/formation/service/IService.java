package org.formation.service;

import java.util.List;

import org.formation.hibernate.entity.Conseiller;

public interface IService {
	
	Conseiller getConseiller(int id);
	List<Conseiller> getAll();
	boolean updateConseiller(Conseiller c);
	boolean deleteConseiller(int id);
	boolean addConseiller (Conseiller c);

}
