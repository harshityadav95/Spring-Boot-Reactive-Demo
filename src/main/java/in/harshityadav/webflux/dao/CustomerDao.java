package in.harshityadav.webflux.dao;

import in.harshityadav.webflux.dto.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    public List<Customer> getCustomers(){

        return IntStream.rangeClosed(1,50)
                .peek(i-> System.out.println("Processing Count"+i))
                .mapToObj(i-> new Customer(i,"Cusomer"+i))
                .collect(Collectors.toList());
    }


}
