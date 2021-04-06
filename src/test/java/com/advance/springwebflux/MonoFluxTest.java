package com.advance.springwebflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
       Mono<?> mono = Mono.just("springbasic").
               then(Mono.error(new RuntimeException("Exception Occur")))
               .log();
       mono.subscribe(System.out::println);

    }
    void testFlux(){
       Flux<String> flux = Flux.just("Spring","spring boot","Spring microservice")
               .log();
       flux.subscribe(System.out::println);
    }

    @Test
    public void getAll(){

    }
}
