package pl.pkrysztofiak.reactor.section04.helper;

import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class OrderService {

    private static Map<Integer, List<PurcheseOrder>> db = new HashMap<>();

    static {
        List<PurcheseOrder> list1 = Stream.of(
                new PurcheseOrder(1),
                new PurcheseOrder(1),
                new PurcheseOrder(1))
                .toList();

        List<PurcheseOrder> list2 = Stream.of(
                new PurcheseOrder(2),
                new PurcheseOrder(2))
                .toList();

        db.put(1, list1);
        db.put(1, list2);
    }

    public static Flux<PurcheseOrder> getOrders(int userId) {
        return Flux.create(sink -> {
            db.get(userId).forEach(sink::next);
            sink.complete();
        });
    }
}
