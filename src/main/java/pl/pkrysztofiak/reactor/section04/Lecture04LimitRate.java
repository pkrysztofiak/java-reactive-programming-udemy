package pl.pkrysztofiak.reactor.section04;

import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

public class Lecture04LimitRate {

    public static void main(String[] args) {


        Flux.range(1, 1000)
                .log()
                .limitRate(100) //75%
                .subscribe(new Subscriber<>());

        Flux.range(1, 1000)
                .log()
                .limitRate(100, 99) //99%
                .subscribe(new Subscriber<>());

        Flux.range(1, 1000)
                .log()
                .limitRate(100, 100) //back to 75%
                .subscribe(new Subscriber<>());

        Flux.range(1, 1000)
                .log()
                .limitRate(100, 0) //back to 100%
                .subscribe(new Subscriber<>());
    }
}
