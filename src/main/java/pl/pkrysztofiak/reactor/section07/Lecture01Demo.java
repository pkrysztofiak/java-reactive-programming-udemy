package pl.pkrysztofiak.reactor.section07;

import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;

public class Lecture01Demo {

    public static void main(String[] args) throws InterruptedException {

        Flux.create(fluxSink -> {
                    for (int i = 1; i < 501; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed " + i);
                    }
                })
                .publishOn(Schedulers.boundedElastic())
//                .doOnNext(i -> {
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                })
                .subscribe(new Subscriber<>());

        TimeUnit.SECONDS.sleep(60);

    }
}
