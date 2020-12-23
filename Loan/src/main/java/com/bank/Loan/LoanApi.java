package com.bank.Loan;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoanApi {

//    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient client;

    @RequestMapping(value = "/getCustomerInfo", method = RequestMethod.GET)
    public Customer getCustomerInfo(){
        Customer customer=new Customer();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("customer-service",false);
        String customerAppURL = instanceInfo.getHomePageUrl();
        String courseAppURL = "http://localhost:8002/";
     //   customerAppURL = customerAppURL+"getAll";
        RestTemplate restTemplate = new RestTemplate();

       return customer = restTemplate.getForObject(customerAppURL,Customer.class);

    }
}
