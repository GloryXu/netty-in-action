package chapter05.two.two;

import io.netty.buffer.ByteBuf;

/**
 * 堆缓冲区
 * 最常用的ByteBuf模式是将数据存储在JVM的堆空间中，这种模式被称为支撑数组（backing array）
 */
public class HeapBufferArea {

    public static void main(String[] args) {
        ByteBuf heapBuf = null;
        // 检查ByteBuf是否有一个支撑数组
        if (heapBuf.hasArray()) {
            byte[] array = heapBuf.array();// 如果有，则获取对该数组的引用
            int offset = heapBuf.arrayOffset() + heapBuf.readerIndex();// 计算第一个字节的偏移量
            int length = heapBuf.readableBytes();// 获得可读字节数
            handleArray(array, offset, length);// 使用数组、偏移量作为参数调用你的方法
        }
    }

    private static void handleArray(byte[] array, int offset, int length) {
        
    }
}
