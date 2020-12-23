package com.bank.Customer.userInterFace;

import com.bank.Customer.Customer;
import com.bank.Customer.CustomerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

@Component
@ManagedBean
@ViewScoped
public class CustomerViewBean {

    @Autowired
    private CustomerApi customerApi;
    private Customer customer;
    private String firstName;
    private String lastName;

    public void init(){
        customer=new Customer();
    }

    public void save() {

        customer.setName(firstName);
        customer.setSurName(lastName);
        customerApi.saveCustomer(customer);
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
