package pl.pkrysztofiak.reactor.section03;

import com.github.javafaker.Faker;
import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

public class Lecture07FluxGenerateCounter {

    public static void main(String[] args) {
        Flux.generate(
                () -> 1,
                (counter, sink) -> {
                    String country = Faker.instance().country().name();
                    sink.next(country);
                    if (counter >= 10 || country.toLowerCase().equals("canada")) {
                        sink.complete();
                    }
                    return counter + 1;
                }
        ).subscribe(new Subscriber<>());
    }
}
