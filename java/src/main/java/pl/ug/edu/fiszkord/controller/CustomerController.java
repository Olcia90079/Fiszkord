package pl.ug.edu.fiszkord.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.ug.edu.fiszkord.domain.Customer;
import pl.ug.edu.fiszkord.repository.CustomerRepository;

import java.sql.Date;
import java.util.Collections;
import java.util.Map;

@RestController
public class CustomerController {

    private CustomerRepository manager;

    public CustomerController(@Autowired CustomerRepository manager) {
        this.manager = manager;
    }


    @GetMapping("/")
    public Customer home(Model model) throws ParseException, java.text.ParseException {
        Customer bob = new Customer("Bob Builder", 1340f, java.sql.Date.valueOf("2000-04-01"));
        Customer rob = new Customer("Rob Smasher", 2500f, java.sql.Date.valueOf("1989-05-09"));
        manager.save(bob);
        manager.save(rob);

        System.out.println(manager.findAll().iterator().next().getDate());
        System.out.println(manager.findByMoney(1340.0f).get(0).getName());
        System.out.println(manager.findByDate(Date.valueOf("1989-05-09")).get(0).getName());
        manager.delete(bob);
        System.out.println(manager.findAll().spliterator().getExactSizeIfKnown());
        return bob;
    }

}
