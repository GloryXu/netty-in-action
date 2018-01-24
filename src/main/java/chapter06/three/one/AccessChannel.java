package chapter06.three.one;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

/**
 * 调用Channel上的write()方法将会导致写入事件从尾端到头部地流经ChannelPipeline
 */
public class AccessChannel {
    public static void main(String[] args) {
        ChannelHandlerContext ctx = null;

        Channel channel = ctx.channel();

        channel.write(Unpooled.copiedBuffer("Netty in Action", CharsetUtil.UTF_8));
    }
}
