package chapter06.one.six;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;

public class DiscardOutboundHandler extends ChannelHandlerAdapter {
    /**
     * 重要的是，不仅要释放资源，还要通知ChannelPromise。
     * 否则可能会出现ChannelFutureListener收不到某个消息已经被处理了的通知的情况
     *
     * @param ctx
     * @param msg
     * @param promise
     * @throws Exception
     */
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        // 释放资源
        ReferenceCountUtil.release(msg);
        // 通知ChannelPromise数据已经被处理了
        promise.setSuccess();
    }
}
