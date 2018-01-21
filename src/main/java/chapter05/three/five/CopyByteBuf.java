package chapter05.three.five;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * 复制一个ByteBuf
 */
public class CopyByteBuf {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        // 创建ByteBuf以保存所提供的字符串的字节
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        // 创建该ByteBuf从索引0开始到15结束的分段的副本
        ByteBuf copy = buf.copy(0, 15);
        System.out.println(copy.toString(utf8));
        // 更新索引0处的字节
        buf.setByte(0, (byte) 'J');
//        将会成功，因为数据不是共享
        System.out.println(buf.getByte(0) != copy.getByte(0));
        assert buf.getByte(0) != copy.getByte(0);
    }
}
