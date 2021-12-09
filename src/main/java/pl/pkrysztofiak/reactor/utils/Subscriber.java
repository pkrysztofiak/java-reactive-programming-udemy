package pl.pkrysztofiak.reactor.utils;

import org.reactivestreams.Subscription;

public class Subscriber<T> implements org.reactivestreams.Subscriber<T> {

    private final String name;

    public Subscriber() {
        name = "";
    }

    public Subscriber(String name) {
        this.name = name + " - ";
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T next) {
        System.out.println(name + "next=" + next);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println(name + "error=" + t.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + "complete");
    }
}
