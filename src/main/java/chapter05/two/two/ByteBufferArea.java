package chapter05.two.two;

import java.nio.ByteBuffer;

/**
 * 复合缓冲区
 * 使用ByteBuffer的复合缓冲区模式
 *
 * 分配和复制操作，以及伴随着对数组管理的需要，使得这个版本的实现效率低下而且笨拙。
 */
public class ByteBufferArea {
    public static void main(String[] args) {
        ByteBuffer header = null;
        ByteBuffer body = null;
        //Use an array to hold the message parts
        ByteBuffer[] message = new ByteBuffer[]{header, body};
        // create a new ByteBuffer and use copy to merge the header and body
        ByteBuffer message2 = ByteBuffer.allocate(header.remaining() + body.remaining());
        message2.put(header);
        message2.put(body);
        message2.flip();
    }
}
