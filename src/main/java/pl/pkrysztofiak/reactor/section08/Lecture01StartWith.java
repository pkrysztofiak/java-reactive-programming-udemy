package pl.pkrysztofiak.reactor.section08;

import pl.pkrysztofiak.reactor.section08.helper.NameGenerator;
import pl.pkrysztofiak.reactor.utils.Subscriber;

import java.util.concurrent.TimeUnit;

public class Lecture01StartWith {

    public static void main(String[] args) {
        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.generate()
                .take(2)
                .subscribe(new Subscriber<>("Sam"));

        nameGenerator.generate()
                .take(2)
                .subscribe(new Subscriber<>("Mike"));
    }
}