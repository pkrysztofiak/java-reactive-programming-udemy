package pl.pkrysztofiak.reactor.section08.helper;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Emirates {

    public static Flux<String> getFlights() {
        return Flux.range(1, Faker.instance().random().nextInt(1, 10))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Emirates" + Faker.instance().random().nextInt(100, 999))
                .filter(i -> Faker.instance().random().nextBoolean());
    }
}
