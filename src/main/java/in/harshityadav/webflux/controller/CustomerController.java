package in.harshityadav.webflux.controller;

import in.harshityadav.webflux.dto.Customer;
import in.harshityadav.webflux.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {


        //injecting the service
        @Autowired
        private CustomerService service;

        // traditional endpoint
        @GetMapping("/")
        public List<Customer> getAllCustomer(){

                return service.loadAllCustomers();
        }

        // reactive controller
        @GetMapping("/stream")
        public Flux<Customer> getAllCustomerStream(){

                return service.loadAllCustomersStream();
        }


}
