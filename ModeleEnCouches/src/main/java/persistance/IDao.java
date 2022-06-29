package persistance;

import java.util.List;

import model.Customer;

public interface IDao {
	void save(Customer c);
	
	Customer findById(int id);
	
	void delete(int id);
	
	List<Customer> findAll();
}
