package chapter06.four.two;

import io.netty.channel.*;

/**
 * ChannelPromise的可写方法
 * 通过调用ChannelPromise上的setSuccess()和setFailure()方法，可以使一个操作的状态在ChannelHandler的方法返回给其调用者时即可被感知到
 */
public class OutboundExceptionHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        promise.addListener(new ChannelFutureListener() {
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
