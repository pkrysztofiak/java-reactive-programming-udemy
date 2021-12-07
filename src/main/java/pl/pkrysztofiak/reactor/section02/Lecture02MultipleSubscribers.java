package pl.pkrysztofiak.reactor.section02;

import reactor.core.publisher.Flux;

public class Lecture02MultipleSubscribers {

    public static void main(String[] args) {

        Flux<Integer> flux = Flux.just(1, 2, 3, 4);

        flux.subscribe(next -> System.out.println("Subscriber1 next=" + next));
        flux.subscribe(next -> System.out.println("Subscriber2 next=" + next));
    }
}
