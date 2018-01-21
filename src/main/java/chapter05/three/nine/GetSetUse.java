package chapter05.three.nine;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * get()和set()方法的用法
 * 不会改变索引值
 */
public class GetSetUse {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        // 创建一个新的ByteBuf以保存给定字符串的字节
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        // 打印第一个字符N
        System.out.println((char)buf.getByte(0));
        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();
        buf.setByte(0, (byte) 'B');
        System.out.println((char)buf.getByte(0));
        System.out.println(readerIndex == buf.readerIndex());
        System.out.println(writerIndex == buf.writerIndex());
    }
}
