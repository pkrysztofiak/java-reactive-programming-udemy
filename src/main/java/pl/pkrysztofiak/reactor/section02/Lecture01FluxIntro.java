package pl.pkrysztofiak.reactor.section02;

import pl.pkrysztofiak.reactor.utils.On;
import reactor.core.publisher.Flux;

public class Lecture01FluxIntro {

    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1);
        flux.subscribe(On.next());
    }
}
