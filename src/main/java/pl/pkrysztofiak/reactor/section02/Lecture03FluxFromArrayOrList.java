package pl.pkrysztofiak.reactor.section02;

import pl.pkrysztofiak.reactor.utils.On;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Lecture03FluxFromArrayOrList {

    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4};
        Flux.fromArray(array).subscribe(On.next());

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        Flux.fromIterable(numbers).subscribe(On.next());

    }
}
