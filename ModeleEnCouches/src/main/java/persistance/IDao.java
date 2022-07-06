package persistance;

import java.util.List;
import java.util.Optional;

import model.Customer;

public interface IDao {
	void save(Customer c);
	
	Optional<Customer> findById(int id);
	
	void delete(int id);
	
	List<Customer> findAll();
}
