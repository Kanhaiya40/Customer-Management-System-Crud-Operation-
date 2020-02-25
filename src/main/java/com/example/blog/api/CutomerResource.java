package com.example.blog.api;

import com.example.blog.model.Customer;
import com.example.blog.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/customer")
public class CutomerResource {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer)
    {
       return  customerService.addCustomers(customer);

    }
    @GetMapping
    public List<Customer>  getCustomer()
    {
        return customerService.getCustomers();
    }
    @GetMapping(value="/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId)
    {
        return customerService.getCustomers(customerId);
    }
    @PutMapping(value="/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId,@RequestBody Customer cutomer)
    {
        return customerService.updateCustomer(customerId,cutomer);
    }
    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId)
    {
        customerService.deleteCustomer(customerId);
    }
}
