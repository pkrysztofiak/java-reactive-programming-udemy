package pl.pkrysztofiak.reactor.section02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class Lecture06Subscription {

    public static void main(String[] args) throws InterruptedException {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        atomicReference.set(s);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext=" + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("onError=" + t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

        Subscription subscription = atomicReference.get();

        TimeUnit.SECONDS.sleep(1);
        subscription.request(3);

        TimeUnit.SECONDS.sleep(1);
        subscription.request(3);

        TimeUnit.SECONDS.sleep(1);
        subscription.cancel();

        TimeUnit.SECONDS.sleep(1);
        subscription.request(3);
    }
}