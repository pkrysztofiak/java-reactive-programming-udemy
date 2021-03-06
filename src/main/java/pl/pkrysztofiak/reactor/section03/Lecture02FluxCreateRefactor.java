package pl.pkrysztofiak.reactor.section03;

import pl.pkrysztofiak.reactor.section03.helper.NameProducer;
import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;

public class Lecture02FluxCreateRefactor {

    public static void main(String[] args) throws InterruptedException {
        NameProducer producer = new NameProducer();
        Flux.create(producer).subscribe(new Subscriber<>());

        Runnable runnable = producer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        TimeUnit.SECONDS.sleep(2);
    }
}
