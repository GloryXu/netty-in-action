package chapter05.two.two;

import io.netty.buffer.ByteBuf;

/**
 * 直接缓冲区
 */
public class DirectBufferArea {
    public static void main(String[] args) {
        ByteBuf directBuf = null;
        // 检查ByteBuf是否由数组支撑。如果不是，则这是一个直接缓冲区
        if(!directBuf.hasArray()) {
            int length = directBuf.readableBytes();// 获取可读字节数
            byte[] array = new byte[length];// 分配一个新的数组来保存具有该长度的字节数组
            directBuf.getBytes(directBuf.readerIndex(), array);// 将字节复制到该数组
            handleArray(array, 0, length);// 使用数组、偏移量和长度作为参数调用你的方法
        }
    }

    private static void handleArray(byte[] array, int i, int length) {

    }
}
