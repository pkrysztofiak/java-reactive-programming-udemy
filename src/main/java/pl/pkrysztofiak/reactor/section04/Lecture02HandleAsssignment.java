package pl.pkrysztofiak.reactor.section04;

import com.github.javafaker.Faker;
import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

public class Lecture02HandleAsssignment {

    public static void main(String[] args) {
        Flux.<String>generate(synchronousSink -> {
                    String country = Faker.instance().country().name();
                    System.out.println("next country=" + country);
                    synchronousSink.next(country);
                })
                .handle((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if (s.toLowerCase().equals("canada")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(new Subscriber<>());
    }
}
