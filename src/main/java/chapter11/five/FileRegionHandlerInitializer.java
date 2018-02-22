package chapter11.five;

import io.netty.channel.*;

import java.io.File;
import java.io.FileInputStream;

/**
 * Transferring file contents with FileRegion
 */
public class FileRegionHandlerInitializer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        File file = new File("");
        FileInputStream in = new FileInputStream(file);
        FileRegion region = new DefaultFileRegion(in.getChannel(), 0, file.length());
        ch.writeAndFlush(region).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if (!future.isSuccess()) {
                    Throwable cause = future.cause();
                    // Do something
                }
            }
        });
    }

}
