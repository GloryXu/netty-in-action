package chapter12.three.two;

import chapter12.three.one.HttpRequestHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

/**
 * Handling text frames
 */
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    private final ChannelGroup group;
    public TextWebSocketFrameHandler(ChannelGroup group) {
        this.group = group;
    }
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            // If the event indicates that the handshake was successful, removes the HttpRequestHandler from the
            // ChannelPipeline because no further HTTP messages will be received.
            ctx.pipeline().remove(HttpRequestHandler.class);
            // Notifies all connected WebSocket clients that new Client has connected
            group.writeAndFlush(new TextWebSocketFrame("Client " + ctx.channel() + " joined"));
            // Adds the new WebSocket Channel to the ChannelGroup so it will receive all messages
            group.add(ctx.channel());
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
    @Override
    public void channelRead0(ChannelHandlerContext ctx,TextWebSocketFrame msg) throws Exception {
        // Increments the reference count of the message and writes it to all connected clients in the ChannelGroup
        group.writeAndFlush(msg.retain());
    }
}
