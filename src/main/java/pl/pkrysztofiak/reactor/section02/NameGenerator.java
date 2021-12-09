package pl.pkrysztofiak.reactor.section02;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;

public class NameGenerator {

    public static Flux<String> generate(int count) {
        return Flux.range(0, count).map(i -> generate());
    }

    private static String generate() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Faker.instance().name().fullName();
    }
}
