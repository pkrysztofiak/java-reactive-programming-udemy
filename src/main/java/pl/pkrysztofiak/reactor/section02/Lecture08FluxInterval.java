package pl.pkrysztofiak.reactor.section02;

import pl.pkrysztofiak.reactor.utils.On;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Lecture08FluxInterval {

    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .log()
                .subscribe(On.next());

        TimeUnit.SECONDS.sleep(16);
    }
}