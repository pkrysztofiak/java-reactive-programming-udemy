package pl.pkrysztofiak.reactor.section06;

import reactor.core.publisher.Flux;

public class Lecture01ThreadDemo {

    public static void main(String[] args) {

        Flux<Integer> flux = Flux.<Integer>create(fluxSink -> {
                    log("Create");
                    fluxSink.next(1);
                })
                .doOnNext(i -> log("Next " + i));

        Runnable runnable = () -> flux.subscribe(i -> log("Sub " + i));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }
        System.out.println("The end");
    }

    private static void log(String message) {
        System.out.println(message + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
