package chapter11.one;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * Adding SSL/TLS support
 */
public class SslChannelInitializer extends ChannelInitializer<Channel> {

    private final SslContext context;
    private final boolean startTls;

    public SslChannelInitializer(SslContext context, boolean startTls) {
        this.context = context;
        this.startTls = startTls;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        // For each SslHandler instance, obtains a new SSLEngine from the SslContext using the ByteBufAllocator of the Channel
        SSLEngine engine = context.newEngine(ch.alloc());
        //Adds the SslHandler        to the pipeline as        the first handler
        ch.pipeline().addFirst("ssl", new SslHandler(engine, startTls));
    }
}
