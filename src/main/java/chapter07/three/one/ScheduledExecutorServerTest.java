package chapter07.three.one;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServerTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        ScheduledFuture<?> future = executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("60 seconds later");
            }
        }, 60, TimeUnit.SECONDS);
        /*try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        executorService.shutdown();
    }
}
