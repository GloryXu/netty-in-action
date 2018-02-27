package test.chapter09.three;

import chapter09.three.FrameChunkDecoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.TooLongFrameException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Testing FrameChunkDecoder
 */
public class FrameChunkDecoderTest {

    @Ignore
    @Test
    public void testFramesDecoded() {
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }
        ByteBuf input = buf.duplicate();
        EmbeddedChannel channel = new EmbeddedChannel(new FrameChunkDecoder(4));
//        System.out.println(input.readBytes(2));
//        System.out.println(input.readBytes(2).readByte());
//        System.out.println(input.readBytes(2));
//        System.out.println(input.readBytes(2).readByte());
//        System.out.println(input.readBytes(2));
        assertTrue(channel.writeInbound(input.readBytes(2)));
        try {
            channel.writeInbound(input.readBytes(4));
            Assert.fail();
        } catch (TooLongFrameException e) {
            // expected exception
        }
        assertTrue(channel.writeInbound(input.readBytes(3)));
        //Marks the channel finished
        assertTrue(channel.finish());
        // Read frames
        ByteBuf read = channel.readInbound();
        assertEquals(buf.readSlice(2), read);
        read.release();
        read = channel.readInbound();
        assertEquals(buf.skipBytes(4).readSlice(3), read);
        read.release();
        buf.release();
    }

}