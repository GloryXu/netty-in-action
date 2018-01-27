package chapter08.six;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

import java.net.InetSocketAddress;

/**
 * Using attributes
 */
public class UsingAttributes {
    public static void main(String[] args) {
        final AttributeKey<Integer> id = AttributeKey.valueOf("ID");
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new NioEventLoopGroup()).channel(NioSocketChannel.class)
                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                             @Override
                             protected void messageReceived(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
                                 System.out.println("Received data");
                             }

                             @Override
                             public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
                                 Integer idValue = ctx.channel().attr(id).get();
                                 // do something with the idValue
                             }
                         }
                );
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        bootstrap.attr(id, 123456);
        ChannelFuture future = bootstrap.connect(new InetSocketAddress("www.baidu.com", 80));
        System.out.println("----------------------");
        future.syncUninterruptibly();
    }
}
