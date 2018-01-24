package chapter06.three.one;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

/**
 * 以下与AccessChannel的代码的事件流是一样的，都是传播事件通过整个ChannelPipeline
 *
 *
 * 但是在ChannelHandler的级别上，事件从一个ChannelHandler到下一个ChannelHandler的移动是由ChannelHandlerContext上的调用完成的
 */
public class AccessPipeline {
    public static void main(String[] args) {
        ChannelHandlerContext ctx = null;
        ChannelPipeline pipeline = ctx.pipeline();
        pipeline.write(Unpooled.copiedBuffer("Netty in Action", CharsetUtil.UTF_8));
    }
}
