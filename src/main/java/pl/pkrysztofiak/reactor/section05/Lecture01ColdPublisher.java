package pl.pkrysztofiak.reactor.section05;

import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Lecture01ColdPublisher {

    public static void main(String[] args) throws InterruptedException {
        Flux<String> movieFlux = Flux.fromStream(() -> getMovie()).delayElements(Duration.ofSeconds(2));

        movieFlux.subscribe(new Subscriber<>("Sam"));

        TimeUnit.SECONDS.sleep(5);

        movieFlux.subscribe(new Subscriber<>("John"));

        TimeUnit.SECONDS.sleep(60);


    }

    private static Stream<String> getMovie() {
        System.out.println("Get the movie streaming request");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7");
    }
}
