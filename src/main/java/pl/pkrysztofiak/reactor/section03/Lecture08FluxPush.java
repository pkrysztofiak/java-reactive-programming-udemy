package pl.pkrysztofiak.reactor.section03;

import pl.pkrysztofiak.reactor.section03.helper.NameProducer;
import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;

public class Lecture08FluxPush {

    public static void main(String[] args) throws InterruptedException {

        NameProducer producer = new NameProducer();
        Flux.push(producer).subscribe(new Subscriber<>());

        Runnable runnable = producer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        TimeUnit.SECONDS.sleep(2);
    }
}
