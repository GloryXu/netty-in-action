package chapter05.three.five;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * 对ByteBuf进行切片
 */
public class SliceByteBuf {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        // 创建ByteBuf以保存所提供的字符串的字节
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        // 创建该ByteBuf从索引0开始到15结束的一个新切片
        ByteBuf copy = buf.slice(0, 15);
        System.out.println(copy.toString(utf8));
        // 更新索引0处的字节
        buf.setByte(0, (byte) 'J');
//        将会成功，因为数据是共享的，对其中一个所做的更改对另外一个也是可见的
        System.out.println(buf.getByte(0) == copy.getByte(0));
        assert buf.getByte(0) == copy.getByte(0);
    }
}
