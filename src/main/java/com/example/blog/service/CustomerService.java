package com.example.blog.service;

import com.example.blog.dao.CustomerDao;
import com.example.blog.exception.CustomerNotFoundException;
import com.example.blog.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class CustomerService {
    @Autowired
    private CustomerDao customerDAO;

    private List<Customer> customerList=new CopyOnWriteArrayList<>();
    private int customerIdCount=1;

    public Customer addCustomers(Customer customer)
    {
        /*
        customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;
        return customer;*/
        return customerDAO.save(customer);


    }
    public List<Customer> getCustomers()
    {
        /*return customerList;*/
        return customerDAO.findAll();
    }
    public Customer getCustomers(int customerId) {
        Optional<Customer> optionalCustomer=customerDAO.findById(customerId);
        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Cutomer u are searching for is not Present");
        /*return customerList.stream().filter(c -> c.getCustomerId() == customerId).findFirst().get();*/
        return optionalCustomer.get();


    }
    public Customer updateCustomer(int customerId,Customer customer)
    {
        customer.setCustomerId(customerId);
       /* customerList.stream().forEach(c->
        {
            if(c.getCustomerId()==customerId)
            {
                c.setCustomerFirstName(customer.getCustomerFirstName());
                c.setCustomerLastName(customer.getCustomerLastName());
                c.setCustomerEmail(customer.getCustomerEmail());

            }
        });
        return customerList.stream().filter(c->c.getCustomerId()==customerId).findFirst().get(); */
       return  customerDAO.save(customer);

    }
    public void deleteCustomer(int customerId)
    {
        /*customerList.stream().forEach(c->
        {
            if(c.getCustomerId()==customerId)
            {
                customerList.remove(c);
            }
        });*/
        customerDAO.deleteById(customerId);
    }

}
