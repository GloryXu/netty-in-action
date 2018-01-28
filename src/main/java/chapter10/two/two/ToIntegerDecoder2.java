package chapter10.two.two;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class ToIntegerDecoder2 extends ReplayingDecoder<Void> {

    // The incoming to messages ByteBuf is a Replaying-DecoderBuffer.
    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(in.readInt());
    }
}
