package database.reader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


    @RequestMapping(value = "/add_customer", method = RequestMethod.POST)
    public Customer addCustomer(@RequestParam(value="firstname") String firstname, @RequestParam(value="lastname") String lastname) {
        Customer cust = new Customer(firstname,lastname);
    	repository.save(cust);
        return cust;
    }
    
    @RequestMapping(value = "/get_customer", method = RequestMethod.GET)
    public Customer getCustomer(@RequestParam(value="firstname") String firstname) {
    	return repository.findByFirstName(firstname);
    }

    @RequestMapping(value = "/get_all_customers", method = RequestMethod.GET)
    public List<Customer> getAll() {
    	return repository.findAll();
    }
    
}





/*		
	//@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}

	}

}

*/

