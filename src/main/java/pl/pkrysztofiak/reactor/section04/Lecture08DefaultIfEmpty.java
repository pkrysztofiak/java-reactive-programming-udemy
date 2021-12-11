package pl.pkrysztofiak.reactor.section04;

import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture08DefaultIfEmpty {

    public static void main(String[] args) {

        getOrderNumbers()
                .filter(i -> i > 10)
                .defaultIfEmpty(-100)
                .subscribe(new Subscriber<>());

    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }
}
