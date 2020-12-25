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

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello() {

        String courses = "";
        //String courseAppURL = "http://localhost:8080/courses";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("customer-service",false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL+"/test";
        RestTemplate restTemplate = new RestTemplate();
        courses = restTemplate.getForObject(courseAppURL,String.class);
        return("Our responce are "+courses);
       // return "hello";
    }



    @RequestMapping(value = "/getCustomerInfo")
    public String getCustomerInfo() {
        Customer customer = new Customer();
        // InstanceInfo instanceInfo = client.getNextServerFromEureka("customer-service",false);
        //  String customerAppURL = instanceInfo.getHomePageUrl();
        //  String courseAppURL = "http://localhost:8002/getAll/";
        //   customerAppURL = customerAppURL+"getAll";
        //customer = restTemplate.getForObject("http://localhost:8002/getAll/", Customer.class);
        InstanceInfo instanceInfo = client.getNextServerFromEureka("customer-service",false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL+"/getAll";
        RestTemplate restTemplate = new RestTemplate();
        customer = restTemplate.getForObject(courseAppURL,Customer.class);
        return customer.getCustomerId();

    }

    @RequestMapping("/firste")
    public String getSpecificCourse() {
        Customer customer = new Customer();
        //String courseAppURL = "http://localhost:8080/1";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("customer-service",false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL+"/2";
        RestTemplate restTemplate = new RestTemplate();

        customer = restTemplate.getForObject(courseAppURL,Customer.class);

        return("Our first course is "+customer.getCustomerId());
    }
}
