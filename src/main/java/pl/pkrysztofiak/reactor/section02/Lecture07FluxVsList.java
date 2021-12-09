package pl.pkrysztofiak.reactor.section02;

import pl.pkrysztofiak.reactor.utils.On;

public class Lecture07FluxVsList {

    public static void main(String[] args) {
        NameGenerator.generate(5).subscribe(On.next());
    }
}