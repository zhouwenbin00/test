package netty.game;

/**
 * 消息工厂
 *
 * @author zwb
 */
public interface MessageFactory {

    /**
     * 根据获取消息
     *
     * @param id
     * @param <T>
     * @return
     */
    <T extends Message> T getMessage(short id);
}
