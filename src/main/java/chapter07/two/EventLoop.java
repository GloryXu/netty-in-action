package chapter07.two;

import java.util.List;

/**
 * 在事件循环中执行任务
 */
public class EventLoop {
    public static void main(String[] args) {
        boolean terminated = false;
        while (!terminated) {
            // 阻塞，直到有事件已经就绪可被运行
            List<Runnable> readyEvents = blockUntilEventReady();
            for (Runnable en : readyEvents) {
                // 循环遍历，并处理所有的事件
                en.run();
            }
        }
    }

    private static List<Runnable> blockUntilEventReady() {
        return null;
    }
}
