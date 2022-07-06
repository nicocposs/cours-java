package org.formation.service;

import java.util.List;

import org.formation.hibernate.entity.Conseiller;
import org.formation.persistence.Dao;
import org.formation.persistence.IDao;

public class ServiceImpl implements IService {
	
	private IDao dao = new Dao();

	@Override
	public Conseiller getConseiller(int id) {

		return dao.find(id);
	}

	@Override
	public List<Conseiller> getAll() {

		return dao.findAll();
	}

	@Override
	public boolean updateConseiller(Conseiller c) {

		return dao.update(c);
	}

	@Override
	public boolean deleteConseiller(int id) {

		return dao.delete(id);
	}

	@Override
	public boolean addConseiller(Conseiller c) {

		return dao.add(c);
	}

}
