package pl.pkrysztofiak.reactor.section04.helper;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person {

    private String name;
    private int age;

    public Person() {
        name = Faker.instance().name().firstName();
        age = Faker.instance().random().nextInt(0, 100);
    }
}
