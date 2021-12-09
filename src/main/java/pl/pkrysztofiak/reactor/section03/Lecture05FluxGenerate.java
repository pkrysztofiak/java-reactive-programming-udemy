package pl.pkrysztofiak.reactor.section03;

import com.github.javafaker.Faker;
import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

public class Lecture05FluxGenerate {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            System.out.println("emitting");
            synchronousSink.next(Faker.instance().country().name());
        }).subscribe(new Subscriber<>());

    }
}
