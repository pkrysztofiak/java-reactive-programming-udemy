package pl.pkrysztofiak.reactor.section02;

import pl.pkrysztofiak.reactor.utils.On;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lecture09FluxFromMono {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a");
        method(Flux.from(mono));

        Flux.range(4, 10)
                .next()
                .subscribe(On.next(), On.error(), On.complete());

    }

    private static void method(Flux<String> flux) {

    }
}
