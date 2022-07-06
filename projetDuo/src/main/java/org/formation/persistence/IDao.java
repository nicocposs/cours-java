package org.formation.persistence;

import java.util.List;

import org.formation.hibernate.entity.Conseiller;

public interface IDao {
	
	Conseiller find(int id);
	List<Conseiller> findAll();
	boolean update(Conseiller c);
	boolean delete(int id);
	boolean add(Conseiller c);

}
