package pl.pkrysztofiak.reactor.section03.helper;

import com.github.javafaker.Faker;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {

    private FluxSink<String> sink;

    @Override
    public void accept(FluxSink<String> sink) {
        this.sink = sink;
    }

    public void produce() {
        String threadName = Thread.currentThread().getName();
        sink.next(threadName + ":" + Faker.instance().name().firstName());
    }
}
