package pl.pkrysztofiak.reactor.section03;

import pl.pkrysztofiak.reactor.section03.helper.NameProducer;
import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

public class Lecture02FluxCreateRefactor {

    public static void main(String[] args) {
        NameProducer producer = new NameProducer();
        Flux.create(producer).subscribe(new Subscriber<>());

        producer.produce();
    }
}
