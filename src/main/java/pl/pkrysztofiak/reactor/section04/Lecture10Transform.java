package pl.pkrysztofiak.reactor.section04;

import pl.pkrysztofiak.reactor.section04.helper.Person;
import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lecture10Transform {

    public static void main(String[] args) {

        getPerson()
                .transform(applyFilterMap())
                .subscribe(new Subscriber<>());

    }

    public static Flux<Person> getPerson() {
        return Flux.range(1, 10).map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> applyFilterMap() {
        return flux -> flux
                .filter(person -> person.getAge() > 50)
                .doOnNext(person -> person.setName(person.getName().toUpperCase()))
                .doOnDiscard(Person.class, person -> System.out.println(person + " discarded"));
    }
}