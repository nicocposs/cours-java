package presentation;

import java.util.List;

import model.Customer;
import service.IService;
import service.ServiceImpl;

public class View {

	public static void main(String[] args) {
		IService service = new ServiceImpl();
		
		Customer c1 = new Customer("Einstein");
		Customer c2 = new Customer("Batman");
		Customer c3 = new Customer("Superman");
		Customer c4 = new Customer(null);

		service.addCustome(c1);
		service.addCustome(c2);
		service.addCustome(c3);
		service.addCustome(c4);
		
		List<Customer> customers = service.getAllCustomer();
		customers.forEach(System.out::println);
		
		System.out.println(service.getValidatedCustomer(0));
		service.getValidatedCustomer(5).ifPresent(System.out::println);
	}

}
