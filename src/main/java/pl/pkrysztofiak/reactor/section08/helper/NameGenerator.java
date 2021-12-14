package pl.pkrysztofiak.reactor.section08.helper;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    private final List<String> list = new ArrayList<>();

    public Flux<String> generate() {
        return Flux.<String>generate(stringSynchronousSink -> {
            System.out.println("Genering...");
            Sleep.seconds(1);
            String name = Faker.instance().name().firstName();
            list.add(name);
            stringSynchronousSink.next(name);
        }).startWith(cached());
    }

    private Flux<String> cached() {
        return Flux.fromIterable(list);
    }
}
