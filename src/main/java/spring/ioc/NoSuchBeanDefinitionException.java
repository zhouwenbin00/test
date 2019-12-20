package spring.ioc;


import org.springframework.core.ResolvableType;

/**
 * 当要求{@code BeanFactory}获取其实例的bean实例时引发异常
 * 找不到定义。 这可能指向一个不存在的bean，一个非唯一的bean，
 * 或没有关联的bean定义的手动注册的单例实例。
 */
public class NoSuchBeanDefinitionException extends BeansException {

    private final String beanName;
    private final ResolvableType resolvableType;

    public NoSuchBeanDefinitionException(String name) {
        super("没有名字叫做" + name + "的bean可以使用");
        this.beanName = name;
        this.resolvableType = null;
    }

    public NoSuchBeanDefinitionException(String name, String message) {
        super("没有名字叫做" + name + "的bean可以使用 :"+message);
        this.beanName = name;
        this.resolvableType = null;
    }
}
