package pl.pkrysztofiak.reactor.section03;

import com.github.javafaker.Faker;
import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

public class Lecture04FluxCreateIssueFix {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            String country;
            int counter = 0;
            do {
                country = Faker.instance().country().name();
                System.out.println("emitting " + country);
                fluxSink.next(counter);
                counter++;
            } while (!country.toLowerCase().equals("canada") && !fluxSink.isCancelled() && counter < 10);
        }).subscribe(new Subscriber<>());
    }
}
