package sk.matusko.wixit.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.matusko.wixit.customer.dao.Customer;
import sk.matusko.wixit.customer.dao.CustomerRepository;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @RequestMapping("/save")
    public String process(){
        // save a single Customer
        repository.save(new Customer("Jack", "Smith"));

        return "Done";
    }

}
