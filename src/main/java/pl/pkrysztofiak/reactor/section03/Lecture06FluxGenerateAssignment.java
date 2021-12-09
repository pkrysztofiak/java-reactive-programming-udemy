package pl.pkrysztofiak.reactor.section03;

import com.github.javafaker.Faker;
import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

public class Lecture06FluxGenerateAssignment {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            String country = Faker.instance().country().name();
            synchronousSink.next(country);
            if (country.toLowerCase().equals("canada")) {
                synchronousSink.complete();
            }
        }).subscribe(new Subscriber<>());
    }
}