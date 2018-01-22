package chapter06.two.one;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.base64.Base64Decoder;

public class ModifyChannelPipeline {
    public static void main(String[] args) {
        ChannelPipeline pipeline = null;
        ChannelHandler firstHandler = null;
        ChannelHandler secondHandler = null;
        ChannelHandler thirdHandler = null;
        pipeline.addLast("handler1", firstHandler);
        pipeline.addLast("handler2", secondHandler);
        pipeline.addLast("handler3", thirdHandler);

        // ....

        pipeline.remove("handler3");
        pipeline.remove(firstHandler);
        pipeline.replace("handler2", "handler4", new Base64Decoder());

    }
}
