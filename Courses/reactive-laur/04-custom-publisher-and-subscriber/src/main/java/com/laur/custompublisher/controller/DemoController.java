package com.laur.custompublisher.controller;


import com.laur.custompublisher.publisher.DemoPublisher;
import com.laur.custompublisher.subscriber.DemoSubscriber;
import org.reactivestreams.Subscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
public class DemoController {

    @GetMapping
    public void demo() {
        // Stream API vs Reactor

        // Publisher
//        Flux<Integer> f1 = Flux.just(1,2,3,4,5);

        // Subscriber
//        f1.subscribe(c -> System.out.println(c));

        // Stream
//        Stream<Integer> s1 = Stream.of(1,2,3,4,5);
//        s1.forEach(System.out::println);

        // Custom publisher
//        DemoPublisher f1 = new DemoPublisher(List.of(1,2,3,4,5));

        // Custom subscriber
//        f1.subscribe(new DemoSubscriber());

        // Programmatically tell FluX how to produce events using create() method and s (Sink)
        Flux<String> f1 = Flux.create(s -> {
            for(int i=0; i<10; i++)
                s.next(UUID.randomUUID().toString());
            s.complete();
        });

        // Logging the methods called in the process
        f1.log().subscribe(c -> System.out.println(c));
    }


}
