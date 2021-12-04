package pl.pkrysztofiak.reactor.utils;

import java.util.function.Consumer;

public class On {

    public static <T> Consumer<T> next() {
        return t -> System.out.println("next=" + t);
    }

    public static Consumer<Throwable> error() {
        return e -> System.out.println(e.getMessage());
    }

    public static Runnable complete() {
        return () -> System.out.println("completed");
    }
}
