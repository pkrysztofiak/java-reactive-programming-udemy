package pl.pkrysztofiak.reactor.section06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;

public class Lecture02SubscribeOnDemo {

    public static void main(String[] args) throws InterruptedException {

        Flux<Integer> flux = Flux.<Integer>create(fluxSink -> {
                    log("Create");
                    fluxSink.next(1);
                })
                .doOnNext(i -> log("Next " + i));

        Runnable runnable = () -> flux
                .doFirst(() -> log("first2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> log("first1"))
                .subscribe(i -> log("Sub " + i));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        TimeUnit.SECONDS.sleep(5);
    }

    private static void log(String message) {
        System.out.println(message + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
