package pl.pkrysztofiak.reactor.section06;

import pl.pkrysztofiak.reactor.utils.On;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Lecture07FluxInterval {

    public static void main(String[] args) {

        Flux.interval(Duration.ofSeconds(1))

                .subscribe(On.next());

    }

    private static void log(String message) {
        System.out.println(message + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
