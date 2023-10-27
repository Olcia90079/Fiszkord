package pl.ug.edu.fiszkord.service;

import org.springframework.stereotype.Service;
import pl.ug.edu.fiszkord.domain.Customer;
import pl.ug.edu.fiszkord.repository.CustomerRepository;

import java.sql.Date;

@Service
public class CustomerService {

    final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public void test() {
        Customer bob = new Customer("Bob Builder", 1340f, Date.valueOf("2000-04-01"));
        Customer rob = new Customer("Rob Smasher", 2500f, Date.valueOf("1989-05-09"));
        customerRepo.save(bob);
        customerRepo.save(rob);

        System.out.println(customerRepo.findAll().iterator().next().getDate());
        System.out.println(customerRepo.findByMoney(1340.0f).get(0).getName());
        System.out.println(customerRepo.findByDate(Date.valueOf("1989-05-09")).get(0).getName());
        customerRepo.delete(bob);
        System.out.println(customerRepo.findAll().spliterator().getExactSizeIfKnown());


    }
}
