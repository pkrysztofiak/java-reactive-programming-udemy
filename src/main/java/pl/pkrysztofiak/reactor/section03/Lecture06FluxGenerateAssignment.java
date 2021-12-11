package pl.pkrysztofiak.reactor.section03;

import com.github.javafaker.Faker;
import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.function.Consumer;

public class Lecture06FluxGenerateAssignment {

    public static void main(String[] args) {

        Flux.generate(new Consumer<SynchronousSink<String>>() {

            private int counter = 0;

            @Override
            public void accept(SynchronousSink<String> synchronousSink) {
                String country = Faker.instance().country().name();
                synchronousSink.next(country);
                counter++;
                if (country.equalsIgnoreCase("canada") || counter >= 10) {
                    synchronousSink.complete();
                }
            }
        }).subscribe(new Subscriber<>());

//        Flux.generate(synchronousSink -> {
//            String country = Faker.instance().country().name();
//            synchronousSink.next(country);
//            if (country.toLowerCase().equals("canada")) {
//                synchronousSink.complete();
//            }
//        }).subscribe(new Subscriber<>());
    }
}