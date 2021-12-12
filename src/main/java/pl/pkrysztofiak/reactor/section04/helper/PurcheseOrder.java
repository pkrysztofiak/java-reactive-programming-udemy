package pl.pkrysztofiak.reactor.section04.helper;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurcheseOrder {

    private String item;
    private String price;
    private int userId;

    public PurcheseOrder(int userId) {
        this.userId = userId;
        item = Faker.instance().commerce().productName();
        price = Faker.instance().commerce().price();
    }
}
