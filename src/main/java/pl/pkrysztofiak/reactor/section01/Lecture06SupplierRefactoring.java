package pl.pkrysztofiak.reactor.section01;

import com.github.javafaker.Faker;
import pl.pkrysztofiak.reactor.utils.On;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Lecture06SupplierRefactoring {

    public static void main(String[] args) {
        getName();
        getName().subscribeOn(Schedulers.boundedElastic()).subscribe(On.next());
        getName();

        String name = getName().subscribeOn(Schedulers.boundedElastic()).block();
        System.out.println(name);

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Mono<String> getName() {
        System.out.println("getName()");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Faker.instance().name().fullName();
        }).map(String::toUpperCase);
    }
}
