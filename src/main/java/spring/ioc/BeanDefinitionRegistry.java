package spring.ioc;

/**
 * 注册定义的bean
 * @author zwb
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册一个bean
     * @param beanName 名字
     * @param beanDefinition 对象
     * @throws Exception 异常
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception;

    /**
     * 获取一个Bean定义
     * @param beanName 名字
     * @return Bean定义对象
     */
    BeanDefinition getBeanDefinition(String beanName);

    /**
     * 是否包含一个Bean定义
     * @param beanName 名字
     * @return boolean
     */
    boolean containsBeanDefinition(String beanName);
}
