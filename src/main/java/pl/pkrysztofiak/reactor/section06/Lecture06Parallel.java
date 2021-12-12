package pl.pkrysztofiak.reactor.section06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;

public class Lecture06Parallel {

    public static void main(String[] args) throws InterruptedException {

        Flux.range(1, 10)
//                .doOnNext(i -> log("start " + i))
                .parallel()
                .runOn(Schedulers.parallel())
                .doOnNext(i -> log("next " + i))
                .sequential()
                .subscribe(i -> log("sub " + i));

        TimeUnit.SECONDS.sleep(4);
    }

    private static void log(String message) {
        System.out.println(message + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
