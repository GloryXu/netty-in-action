package chapter06.three.two;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 缓存到ChannelHandlerContext的引用
 */
public class WriteHandler extends ChannelHandlerAdapter{

    private ChannelHandlerContext ctx;

    /**
     * 存储到ChannelHandlerContext的引用以供稍后使用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
    }

    public void send(String msg) {
        ctx.writeAndFlush(msg);
    }
}
