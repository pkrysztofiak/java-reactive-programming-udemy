package pl.pkrysztofiak.reactor.section02;

import pl.pkrysztofiak.reactor.utils.On;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lecture04FluxFromStream {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        Flux<Integer> flux = Flux.fromStream(stream);

        flux.subscribe(On.next(), On.error(), On.complete());
        flux.subscribe(On.next(), On.error(), On.complete());
    }
}
