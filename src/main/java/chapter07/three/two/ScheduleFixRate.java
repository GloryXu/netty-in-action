package chapter07.three.two;

import io.netty.channel.Channel;
import io.netty.util.concurrent.ScheduledFuture;

import java.util.concurrent.TimeUnit;

/**
 * 使用EventLoop调度周期性的任务
 */
public class ScheduleFixRate {
    public static void main(String[] args) {
        Channel channel = null;
        ScheduledFuture<?> future = channel.eventLoop().scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run every 60 seconds");
            }
        }, 60, 60, TimeUnit.SECONDS);
    }
}
