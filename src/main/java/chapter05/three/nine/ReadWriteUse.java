package chapter05.three.nine;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * ByteBuf上的read()和write()操作
 */
public class ReadWriteUse {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        System.out.println((char)buf.readByte());
        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();
        buf.writeByte((byte)'?');
        System.out.println(readerIndex == buf.readerIndex());
        System.out.println(writerIndex == buf.writerIndex());
    }
}
