package chapter13.six;

import chapter13.four.LogEvent;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * LogEventDecoder
 */
public class LogEventDecoder extends MessageToMessageDecoder<DatagramPacket> {
    @Override
    protected void decode(ChannelHandlerContext ctx, DatagramPacket datagramPacket, List<Object> out) throws Exception {
        ByteBuf content = datagramPacket.content();
        int idx = content.indexOf(0, content.readableBytes(), LogEvent.SEPARATOR);
        String filename = content.slice(0, idx).toString(CharsetUtil.UTF_8);
        String logMsg = content.slice(idx + 1, content.readableBytes()).toString(CharsetUtil.UTF_8);
        LogEvent event = new LogEvent(datagramPacket.sender(), System.currentTimeMillis(), filename, logMsg);
        out.add(event);
    }
}
