package pl.pkrysztofiak.reactor.section04.helper;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private int id;
    private String name;

    public User(int id) {
        this.id = id;
        name = Faker.instance().name().fullName();
    }
}
