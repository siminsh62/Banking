package com.bank.Customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerApi {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/test")
    public String test() {
        return "hello";
    }

    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public void saveCustomer(@RequestBody Customer customerInfo) {
        customerRepository.save(customerInfo);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    //public Customer getById( @RequestBody  Long id  ){
    public Optional<Customer> getById(@PathVariable("id") Long id) throws UserNotFoundException {

        return customerRepository.findById(id);

    }
    @RequestMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Long id ) {
        return customerRepository.getOne(id);
    }
//    @RequestMapping(value="/getById/{name}",method = RequestMethod.GET)
//    public Customer getByName(@PathVariable ("name") String name){
//
//        return customerRepository.findByC;
//    }

    @RequestMapping(value = "/getAll")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
