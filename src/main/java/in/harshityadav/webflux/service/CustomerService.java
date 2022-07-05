package in.harshityadav.webflux.service;


import in.harshityadav.webflux.dao.CustomerDao;
import in.harshityadav.webflux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;


@Service
public class CustomerService {

    @Autowired
   private CustomerDao dao;

    public List<Customer> loadAllCustomers(){
        long start=System.currentTimeMillis();
        List<Customer> customers=dao.getCustomers();
        long stop=System.currentTimeMillis();
        System.out.println("Time Taken"+(stop-start));

        return customers;
    }

    public
    Flux<Customer> loadAllCustomersStream(){
        long start=System.currentTimeMillis();
        Flux<Customer> customers=dao.getCustomersStream();
        long stop=System.currentTimeMillis();
        System.out.println("Time Taken"+(stop-start));

        return customers;
    }



}
