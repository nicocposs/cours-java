package service;

import java.util.List;

import model.Customer;

public interface IService {
	void addCustome(Customer c);
	
	Customer getValidatedCustomer(int id);
	
	List<Customer> getAllCustomer();
}
