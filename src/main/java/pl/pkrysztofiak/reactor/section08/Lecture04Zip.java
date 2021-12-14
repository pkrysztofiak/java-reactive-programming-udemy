package pl.pkrysztofiak.reactor.section08;

import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

public class Lecture04Zip {

    public static void main(String[] args) {
        Flux.zip(body(), engine(), chassis()).subscribe(new Subscriber<>());


    }

    private static Flux<String> body() {
        return Flux.range(0, 5).map(i -> "body");
    }

    private static Flux<String> engine() {
        return Flux.range(0, 2).map(i -> "engine");
    }

    private static Flux<String> chassis() {
        return Flux.range(0, 6).map(i -> "chassis");
    }




}
