package code.chapter01.three.two;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ConnectHandler extends ChannelHandlerAdapter {

    /**
     * 当一个新的连接已经被建立时，channelActive(ChannelHandler Context)将会被调用
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client " + ctx.channel().remoteAddress() + " connected");
    }
}
