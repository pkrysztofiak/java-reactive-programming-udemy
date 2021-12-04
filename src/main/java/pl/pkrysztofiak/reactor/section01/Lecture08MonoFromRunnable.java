package pl.pkrysztofiak.reactor.section01;

import pl.pkrysztofiak.reactor.utils.On;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

public class Lecture08MonoFromRunnable {

    public static void main(String[] args) {

        Mono.fromRunnable(Lecture08MonoFromRunnable::timeConsumingOperation).subscribe(
                On.next(),
                On.error(),
                On.complete());

    }

    private static void timeConsumingOperation() {
        System.out.println("timeConsumingOperation");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
