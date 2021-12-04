package pl.pkrysztofiak.reactor.section01;

import com.github.javafaker.Faker;
import pl.pkrysztofiak.reactor.utils.On;
import reactor.core.publisher.Mono;

public class Lecture04MonoEmptyOrError {

    public static void main(String[] args) {
        userRepository(2).subscribe(
                On.next(),
                On.error(),
                On.complete()
        );
    }

    private static Mono<String> userRepository(int userId) {

        if (userId == 1) {
            return Mono.just(Faker.instance().name().firstName());
        } else if (userId == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException());
        }
    }
}
