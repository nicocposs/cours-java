package persistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.Customer;

public class MemoryDao implements IDao {
	private static final Map<Integer,Customer> DB = new HashMap<Integer, Customer>();
	private static int id = 0;
	
	
	@Override
	public void save(Customer c) {
		c.setId(id);
		DB.put(c.getId(), c);
		id++;
	}

	@Override
	public Optional<Customer> findById(int id) {
		return Optional.ofNullable(DB.get(id));
	}

	@Override
	public void delete(int id) {
		//TODO DB.remove(id);
		
	}

	@Override
	public List<Customer> findAll() {
		return new ArrayList<Customer>(DB.values());
	}

}
