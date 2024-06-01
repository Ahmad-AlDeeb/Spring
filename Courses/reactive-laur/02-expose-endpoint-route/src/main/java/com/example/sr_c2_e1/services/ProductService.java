package com.example.sr_c2_e1.services;

import com.example.sr_c2_e1.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
public class ProductService {

  public Flux<Product> getAll() {
    var p1 = new Product();   // from DB
    p1.setName("Beer");
    var p2 = new Product();
    p2.setName("Chocolate");
    var p3 = new Product();
    p3.setName("Milk");
    var p4 = new Product();
    p4.setName("Bread");
    var p5 = new Product();
    p5.setName("Pepsi");

    Flux<Product> products =
            Flux.fromStream(List.of(p1, p2, p3, p4, p5).stream())
                    .delayElements(Duration.ofSeconds(1));

    return products;
  }
}
