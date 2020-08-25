package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api")
public class CustomerRestController {
    // autowire the CustomerService
    @Autowired
    private CustomerService customerService;
    // add mapping for Get customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();

    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer (@PathVariable int customerId)
    {
        Customer theCustomer =customerService.getCustomer(customerId);

        if (theCustomer==null)
        {
            throw new CustomerNotFoundException("customer not found -"+customerId);
        }
        return  theCustomer;
    }

    //add mapping for post /customers  adding new customer

    @PostMapping("/customers")

    public Customer addCustomer (@RequestBody Customer theCustomer)
    {
        //if the id is 0, than dao wil insert new customer
        theCustomer.setId(0);
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    @PutMapping ("/customers")
    public Customer updateCustomer (@RequestBody Customer theCustomer)

    {
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }


}
