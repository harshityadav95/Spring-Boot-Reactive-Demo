package in.harshityadav.webflux.dao;

import in.harshityadav.webflux.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {



    private static void sleepExecution(int j){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Customer> getCustomers(){

        return IntStream.rangeClosed(1,50)
                .peek(CustomerDao::sleepExecution)
                .peek(i-> System.out.println("Processing Count"+i))
                .mapToObj(i-> new Customer(i,"Cusomer"+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersStream(){

        return Flux.range(1,50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i-> System.out.println("Processing Count in Stream"+i))
                .map(i-> new Customer(i,"Cusomer"+i));



    }

}
