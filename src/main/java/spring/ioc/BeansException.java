package spring.ioc;

/**
 * Bean包中引发的所有异常的抽象超类和子包。
 *
 * @author zwb
 */
public abstract class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
