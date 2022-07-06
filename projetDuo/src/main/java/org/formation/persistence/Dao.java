package org.formation.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.formation.hibernate.entity.Conseiller;

public class Dao implements IDao {
	private EntityManagerFactory emf;

	@Override
	public Conseiller find(int id) {
		emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		Conseiller c = em.find(Conseiller.class, id);
		emf.close();
		return c;
	}

	@Override
	public List<Conseiller> findAll() {
		emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		List<Conseiller> cList = em.createQuery("From Conseiller", Conseiller.class).getResultList();
		emf.close();
		return cList;
	}

	@Override
	public boolean update(Conseiller c) {
		emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		
		try {
			txn.begin();	
			Conseiller cModif = em.find(Conseiller.class, c.getId());
			cModif.setFirstName(c.getFirstName());
			cModif.setName(c.getName());
			cModif.setSalary(c.getSalary());
			cModif.setDOB(c.getDOB());
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
		

		return false;
	}

	@Override
	public boolean delete(int id) {
		emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		try {
			txn.begin();
			Conseiller c = em.find(Conseiller.class, id);
			em.remove(c);
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
		return true;
	}

	@Override
	public boolean add(Conseiller c) {
		emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			em.persist(c);
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}

		return true;
	}	
	
}
