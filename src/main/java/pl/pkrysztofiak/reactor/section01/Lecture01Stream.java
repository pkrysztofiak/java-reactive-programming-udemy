package pl.pkrysztofiak.reactor.section01;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Lecture01Stream {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1).map(i -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i * 2;
        });
        System.out.println(stream);

    }
}
