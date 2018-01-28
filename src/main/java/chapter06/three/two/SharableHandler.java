package chapter06.three.two;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 可共享的ChannelHandler
 * 指在多个ChannelPipeline中共享同一个ChannelHandler，对应的ChannelHandler必须要使用@Sharable注解标注
 *
 * 此类Handler必须线程安全
 *
 *
 * 为何要共享同一个ChannelHandler 在多个ChannelPipeline中安装同一个ChannelHandler的一个常见的原因就是用于收集跨越多个Channel的统计信息
 */
@ChannelHandler.Sharable
public class SharableHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Channel read message : " + ctx.read());
        ctx.fireChannelRead(msg);
    }

}
