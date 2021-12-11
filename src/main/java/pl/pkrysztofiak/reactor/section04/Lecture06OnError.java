package pl.pkrysztofiak.reactor.section04;

import com.github.javafaker.Faker;
import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lecture06OnError {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (3 - i))
                .onErrorReturn(-1)
                .subscribe(new Subscriber<>());

        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (3 - i))
                .onErrorResume(e -> fallback())
                .subscribe(new Subscriber<>());

        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (3 - i))
                .onErrorContinue((th, i) -> System.out.println("i=" + i + " caused the error"))
                .subscribe(new Subscriber<>());
    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> Faker.instance().random().nextInt(100, 200));
    }
}
