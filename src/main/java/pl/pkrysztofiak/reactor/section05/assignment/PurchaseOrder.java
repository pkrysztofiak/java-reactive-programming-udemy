package pl.pkrysztofiak.reactor.section05.assignment;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.ToString;

import java.util.Locale;

@Data
@ToString
public class PurchaseOrder {

    private String item;
    private double price;
    private String category;
    private int quantity;

    public PurchaseOrder() {
        item = Faker.instance().commerce().productName();
        price = 1 + Faker.instance().random().nextDouble() * (500 - 1);
        category = Faker.instance().commerce().department();
        quantity = Faker.instance().random().nextInt(1, 10);
    }
}
