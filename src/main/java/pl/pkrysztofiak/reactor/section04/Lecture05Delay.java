package pl.pkrysztofiak.reactor.section04;

import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Lecture05Delay {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("reactor.bufferSize.x", "100");

        Flux.range(1, 1000)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(new Subscriber<>());

        TimeUnit.HOURS.sleep(1);
    }
}
