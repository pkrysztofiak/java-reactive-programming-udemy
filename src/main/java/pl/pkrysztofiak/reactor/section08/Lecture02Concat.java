package pl.pkrysztofiak.reactor.section08;

import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

public class Lecture02Concat {

    public static void main(String[] args) {
        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.just("c", "d", "e");

//        Flux<String> concat = flux1.concatWith(flux2)
        Flux<String> concat = Flux.concat(flux1, flux2);

        concat.subscribe(new Subscriber<>());

    }
}
