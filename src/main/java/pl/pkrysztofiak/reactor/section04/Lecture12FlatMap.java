package pl.pkrysztofiak.reactor.section04;

import pl.pkrysztofiak.reactor.section04.helper.OrderService;
import pl.pkrysztofiak.reactor.section04.helper.User;
import pl.pkrysztofiak.reactor.section04.helper.UserService;
import pl.pkrysztofiak.reactor.utils.Subscriber;

public class Lecture12FlatMap {

    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getId()))
                .subscribe(new Subscriber<>());
    }
}
