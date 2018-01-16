package chapter05.two.two;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 使用CompositeByteBuf的复合缓冲区模式
 */
public class CompositeBufferArea {
    public static void main(String[] args) {
//        ByteBuffer byteBuffer = null;
//        byteBuffer.flip();
        CompositeByteBuf messageBuf = Unpooled.compositeBuffer();
        ByteBuf headerBuf = null;// can be backing or direct
        ByteBuf bodyBuf = null;// can be backing or direct
        messageBuf.addComponent(0, headerBuf);
        messageBuf.addComponent(0, bodyBuf);

        messageBuf.removeComponent(0);// remove the header
        /*for (ByteBuf buf : messageBuf) {
            System.out.println(buf.toString());
        }*/
    }
}
