package pl.pkrysztofiak.reactor.section08;

import pl.pkrysztofiak.reactor.section08.helper.AmericanAirlines;
import pl.pkrysztofiak.reactor.section08.helper.Emirates;
import pl.pkrysztofiak.reactor.section08.helper.Qatar;
import pl.pkrysztofiak.reactor.section08.helper.Sleep;
import pl.pkrysztofiak.reactor.utils.Subscriber;
import reactor.core.publisher.Flux;

public class Lecture03Merge {

    public static void main(String[] args) {

        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                AmericanAirlines.getFlights()
        );

        merge.subscribe(new Subscriber<>());

        Sleep.seconds(20);
    }
}
