package pl.pkrysztofiak.reactor.section08.helper;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Qatar {

    public static Flux<String> getFlights() {
        return Flux.range(1, Faker.instance().random().nextInt(1, 5))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Qatar" + Faker.instance().random().nextInt(100, 999))
                .filter(i -> Faker.instance().random().nextBoolean());
    }
}
