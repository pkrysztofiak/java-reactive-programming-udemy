package pl.pkrysztofiak.reactor.section01;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

public class Lecture02MonoJust {

    public static void main(String[] args) {

        Mono<Integer> mono = Mono.just(1);

        System.out.println(mono);

        mono.subscribe(System.out::println);
    }
}
