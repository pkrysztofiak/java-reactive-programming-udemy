package pl.pkrysztofiak.reactor.section05;

import pl.pkrysztofiak.reactor.section05.assignment.InventoryService;
import pl.pkrysztofiak.reactor.section05.assignment.OrderService;
import pl.pkrysztofiak.reactor.section05.assignment.RevenueService;
import pl.pkrysztofiak.reactor.utils.Subscriber;

import java.util.concurrent.TimeUnit;

public class Lecture06Assignment {

    public static void main(String[] args) throws InterruptedException {

        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());

        inventoryService.inventoryStream()
                .subscribe(new Subscriber<>("inventory"));

        revenueService.revenueStream()
                .subscribe(new Subscriber<>("revenue"));

        TimeUnit.SECONDS.sleep(60);

    }
}
