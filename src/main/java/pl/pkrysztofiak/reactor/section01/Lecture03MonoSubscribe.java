package pl.pkrysztofiak.reactor.section01;

import reactor.core.publisher.Mono;

public class Lecture03MonoSubscribe {


    public static void main(String[] args) {

        Mono<Integer> mono = Mono.just("phrase").map(String::length).map(length -> length / 0);

        mono.subscribe(
                next -> System.out.println("next=" + next),
                e -> System.out.println(e.getMessage()),
                () -> System.out.println("Completed"));

    }
}
