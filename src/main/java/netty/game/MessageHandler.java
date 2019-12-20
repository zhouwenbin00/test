package netty.game;

/**
 * 消息处理器
 *
 * @author zwb
 * @param <T>
 */
public interface MessageHandler<T extends Message> {

    /**
     * 处理消息
     *
     * @param user
     * @param message
     */
    void exec(User user, T message);
}
