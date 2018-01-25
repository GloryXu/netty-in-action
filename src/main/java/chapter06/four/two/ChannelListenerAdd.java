package chapter06.four.two;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

/**
 * 添加ChannelFutureListener到ChannelFuture
 */
public class ChannelListenerAdd {
    public static void main(String[] args) {
        Channel channel = null;
        Object someMessage = null;
        ChannelFuture future = channel.write(someMessage);
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(!future.isSuccess()) {
                    future.cause().printStackTrace();
                    future.channel().close();
                }
            }
        });
    }
}
