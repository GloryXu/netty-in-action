package chapter10.four.three;


import io.netty.channel.CombinedChannelDuplexHandler;

/**
 * CombinedChannelDuplexHandler<I,O>
 */
public class CombinedByteCharCodec extends CombinedChannelDuplexHandler<ByteToCharDecoder, CharToByteEncoder> {

    public CombinedByteCharCodec() {
        super(new ByteToCharDecoder(), new CharToByteEncoder());
    }
}
