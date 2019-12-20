package spring.ioc;

/**
 * bean的定义
 *
 * @author zwb
 */
public interface BeanDefinition {

    String SINGLETION = "singletion";

    String PROTOTYPE = "prototype";

    Class<?> getBeanClass();

    boolean isSingleton();

    boolean isPrototype();

    String getScope();

}
