package pl.pkrysztofiak.reactor.section03;

import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

public class Lecture03FluxTake {

    public static void main(String[] args) {

        Flux.range(0, 10)
                .log()
                .take(3)
                .log()
                .subscribe(new Subscriber<>());

    }
}
