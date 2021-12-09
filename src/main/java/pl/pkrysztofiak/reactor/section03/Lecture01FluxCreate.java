package pl.pkrysztofiak.reactor.section03;

import com.github.javafaker.Faker;
import pl.pkrysztofiak.reactor.utils.On;
import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

public class Lecture01FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                fluxSink.next(Faker.instance().country().name());
            }
            fluxSink.complete();
        }).subscribe(new Subscriber<>());
    }
}
