package chapter05.two.two;

import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 访问CompositeByteBuf中的数据
 */
public class AccessCompositeByteBuf {
    public static void main(String[] args) {
        CompositeByteBuf compBuf = Unpooled.compositeBuffer();
        // 获得可读字节数
        int length = compBuf.readableBytes();
        // 分配一个具有可读字节数长度的新数组
        byte[] array = new byte[length];
        // 将字节读到该数组中
        compBuf.getBytes(compBuf.readerIndex(), array);
        // 使用偏移量和长度作为参数使用该数组
        handlerArray(array, 0, array.length);
    }

    private static void handlerArray(byte[] array, int i, int length) {

    }
}
