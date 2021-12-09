package pl.pkrysztofiak.reactor.section02.assignment;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPricePublisher {

    public static Flux<Integer> getPrice() {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1)).map(i -> atomicInteger.getAndAccumulate(Faker.instance().random().nextInt(-5, 5), Integer::sum));
    }
}
