package pl.pkrysztofiak.reactor.section02;

import pl.pkrysztofiak.reactor.utils.On;
import reactor.core.publisher.Flux;

public class Lecture05FluxRange {

    public static void main(String[] args) {
        Flux.range(2, 2)
                .log()
                .map(String::valueOf)
                .log()
                .subscribe(On.next());
    }
}