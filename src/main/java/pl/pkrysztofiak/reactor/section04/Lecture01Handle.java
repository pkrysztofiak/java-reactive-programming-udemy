package pl.pkrysztofiak.reactor.section04;

import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

public class Lecture01Handle {

    public static void main(String[] args) {
        Flux.range(1, 20).handle(((integer, synchronousSink) -> {
            synchronousSink.next(integer);
        })).subscribe(new Subscriber<>());
    }
}