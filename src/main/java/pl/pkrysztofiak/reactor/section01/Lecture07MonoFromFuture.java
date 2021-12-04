package pl.pkrysztofiak.reactor.section01;

import com.github.javafaker.Faker;
import pl.pkrysztofiak.reactor.utils.On;
import reactor.core.publisher.Mono;

import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Lecture07MonoFromFuture {

    public static void main(String[] args) throws InterruptedException {

        Mono.fromFuture(getName()).subscribe(On.next());

        TimeUnit.SECONDS.sleep(2);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Faker.instance().name().fullName());
    }
}
