package service;

import java.util.List;
import java.util.Optional;

import model.Customer;
import persistance.IDao;
import persistance.MemoryDao;

public class ServiceImpl implements IService {
	private IDao dao = new MemoryDao();

	@Override
	public void addCustome(Customer c) {
		if (c != null && c.getName() != null) {
			dao.save(c);
		}
	}

	@Override
	public Optional<Customer> getValidatedCustomer(int id) {
		Optional<Customer> optCustomer = dao.findById(id);
		
		optCustomer.ifPresent(c -> c.setName(c.getName().toUpperCase()));

		return optCustomer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return dao.findAll();
	}

}
