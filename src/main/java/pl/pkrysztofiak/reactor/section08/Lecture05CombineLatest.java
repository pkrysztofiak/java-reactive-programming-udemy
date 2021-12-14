package pl.pkrysztofiak.reactor.section08;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture05CombineLatest {

    public static void main(String[] args) {

    }

    private static Flux<String> getString() {
        return Flux.just("A", "B", "C", "D").delayElements(Duration.ofSeconds(1));
    }

    private static Flux<Integer> getNumber() {
        return Flux.just(1, 2, 3).delayElements(Duration.ofSeconds(3));
    }
}
