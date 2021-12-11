package pl.pkrysztofiak.reactor.section04;

import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Lecture07Timeout {

    public static void main(String[] args) throws InterruptedException {
        getOrderNumbers()
                .timeout(Duration.ofSeconds(2), fallback())
                .subscribe(new Subscriber<>());

        TimeUnit.SECONDS.sleep(100);
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10).delayElements(Duration.ofSeconds(5));
    }

    private static Flux<Integer> fallback() {
        return Flux.range(100, 10).delayElements(Duration.ofMillis(200));
    }
}
