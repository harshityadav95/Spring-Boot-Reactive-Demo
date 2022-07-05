package in.harshityadav.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono() {

        // this mono or flux will act as publisher
        // subscriber need to call subscribe method of the publisher
        Mono<String> monoString = Mono.just("Sting Data Type").log();

        //invoking the subscribe method of the publisher
        monoString.subscribe(System.out::println);


    }

    @Test
    public void testErrorMono() {

        Mono<?> obj = Mono.just(123)
                    .then(Mono.error(new RuntimeException("Exception Occured")))
                    .log();
        obj.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));



    }

    @Test
    public void testFlux(){

        //creating flux object
        //obj will act as publisher
        Flux<String> obj= Flux.just("My","Name","is","Master Control","Program")
                .concatWithValues("EOL")
                .log();

        //calling the subscribe method of the publisher
        obj.subscribe(System.out::println);






    }

    @Test
    public void testFluxError(){

        //creating flux object
        //obj will act as publisher
        Flux<String> obj= Flux.just("My","Name","is","Master Control","Program")
                .concatWithValues("goal")
                .concatWith(Flux.error(new RuntimeException("Exception Occured")))
                .concatWithValues("bbye")
                .log();

        //calling the subscribe method of the publisher
        obj.subscribe(System.out::println,(e)-> System.out.println(e.getMessage()));

    }


}
