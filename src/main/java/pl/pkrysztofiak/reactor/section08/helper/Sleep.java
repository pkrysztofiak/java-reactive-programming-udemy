package pl.pkrysztofiak.reactor.section08.helper;

import java.util.concurrent.TimeUnit;

public class Sleep {

    public static void seconds(int n) {
        try {
            TimeUnit.SECONDS.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void millis(int n) {
        try {
            TimeUnit.MILLISECONDS.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
