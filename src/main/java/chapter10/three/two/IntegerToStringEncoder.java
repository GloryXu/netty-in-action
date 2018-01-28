package chapter10.three.two;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 *
 */
public class IntegerToStringEncoder extends MessageToMessageEncoder<Integer> {

    @Override
    public void encode(ChannelHandlerContext ctx, Integer msg, List<Object>out) throws Exception {
        out.add(String.valueOf(msg));
    }
}
