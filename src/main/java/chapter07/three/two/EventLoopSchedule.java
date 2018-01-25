package chapter07.three.two;

import io.netty.channel.Channel;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 使用EventLoop
 */
public class EventLoopSchedule {
    public static void main(String[] args) {
        Channel channel = null;
        ScheduledFuture<?> future = channel.eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("60 second later");
            }
        }, 60, TimeUnit.SECONDS);
    }
}
