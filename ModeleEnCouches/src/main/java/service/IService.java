package service;

import java.util.List;
import java.util.Optional;

import model.Customer;

public interface IService {
	void addCustome(Customer c);
	
	Optional<Customer> getValidatedCustomer(int id);
	
	List<Customer> getAllCustomer();
}
