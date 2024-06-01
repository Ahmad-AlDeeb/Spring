# Demos
- #1: expose endpoint in `@RestController` style
- #2: expose endpoint in ***route*** style
- **Endpoint approach** use `@RestController` while **functional approach** in reactive use ***route***
- #3: consume events from the endpoint using `WebClient` and handle errors
- #4: implement custom `Publisher` (`Flux`) and a custom `Subscriber` & `Subscription`.
- [Demos repository](https://github.com/Ahmad-AlDeeb/Spring/tree/main/Courses/reactive-laur)
# Notes
- Reactive app doesn't create a **thread** for each request as used to be with non-reactive web app
- We have **netty** instead of **Tomcat** since Tomcat doesn't support reactive.
- `Flux` is pipeline of events and `Mono` is the same except it send at most 1 event (both are called Publisher)
- For example, instead of returning all products in `getAllProducts` endpoint, we can return them product by product (pipeline) as soon as each one is finished processing
- Reactive programming is not a silver bullet
- **Backpressure:** is the possibility the subscriber has to decide how many values they get from the `Publisher`
- Avoid **blocking methods** which are known to return values without `Flux` or `Mono`.
- Whenever you implement **endpoints**, you don't need `Subscriber`, because you have Spring Boot attaching it for you, so that's why it's enough to define a `Publisher` and return it.
- Check Sequence diagram for `Publisher` & `Subscriber` in the img below.
 
![image](https://github.com/Ahmad-AlDeeb/Spring/assets/122436546/1d447e77-aed2-4823-8c2a-ca83ad0009ea)

# Stream vs Reactor
  - `Stream` is like a **river** and `Flux` is like a **tap**.
    - In first case:
      - Water flows on it's own pace and you as consumer have no control over it.
      - You can take water from it but if you don't the water goes away.
    - In second case:
      - Consumer can control when and how much water you want by requesting it.
      - Reactor can have multiple subscribers while Stream can't
# Resources:
- [Course by Laur Spilca](https://www.youtube.com/playlist?list=PLEocw3gLFc8W-w8QZbM8f955StBEiQjJk)
