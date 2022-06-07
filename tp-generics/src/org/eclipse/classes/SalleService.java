package org.eclipse.classes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.interfaces.IDao;

public class SalleService implements IDao<Salle> {
	private List<Salle> vals;

	public SalleService() {
		super();
		this.vals = new ArrayList<Salle>();
	}

	@Override
	public boolean create(Salle o) {
		return this.vals.add(o);
	}

	@Override
	public boolean delete(Salle o) {
		for(Salle s : this.vals) {
			if(o.getCode() == s.getCode() && o.getLibelle() == s.getLibelle()) {
				return this.vals.remove(s);
			}
		}
		return false;
	}

	@Override
	public boolean update(Salle o) {
		for(Salle s : this.vals) {
			if(o.getId() == s.getId()) {
				s.setCode(o.getCode());
				s.setLibelle(o.getLibelle());
				return true;
			}
		}
		return false;
	}

	@Override
	public Salle findById(int id) {
		for(Salle s : this.vals) {
			if(s.getId() == id) {
				return s;
			}
		}
		return null;
	}

	@Override
	public List<Salle> findAll() {
		return this.vals;
	}

}
