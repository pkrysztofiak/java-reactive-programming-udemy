package pl.pkrysztofiak.reactor.section01;

import com.github.javafaker.Faker;
import pl.pkrysztofiak.reactor.utils.On;
import reactor.core.publisher.Mono;

public class Lecture05MonoFromSupplier {

    public static void main(String[] args) {

        Mono.fromSupplier(() -> getName()).subscribe(On.next());

    }

    private static String getName() {
        System.out.println("Generating name...");
        return Faker.instance().name().firstName();
    }
}
