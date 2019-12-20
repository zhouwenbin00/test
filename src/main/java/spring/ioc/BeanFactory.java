package spring.ioc;

/**
 * 抽象的bean工厂
 *
 * @author zwb
 */
public interface BeanFactory {


    /**
     * 用于标记自己的前缀
     */
    String FACTORY_BEAN_PREFIX = "&";


    /**
     * 根据名字获取一个bean
     *
     * @param beanName bean的名字
     * @return 一个bean的实例对象
     */
    Object getBean(String beanName) throws Exception;


    /**
     * 返回一个实例，该实例可以是指定bean的共享或独立的。
     * <p>与{@link #getBean（String）}相同，但提供了类型的度量
     * 如果Bean不属于Bean，则抛出BeanNotOfRequiredTypeException以确保安全。
     * 必填类型。 这意味着ClassCastException不能在强制转换时抛出
     * 结果正确无误，就像{@link #getBean（String）}一样。
     * <p>将别名转换回相应的规范bean名称。
     * 将询问父工厂是否在该工厂实例中找不到该bean。
     *
     * @param name         要检索的bean的名称
     * @param requiredType bean必须匹配的类型； 可以是接口或超类
     * @return bean的实例
     * 如果不是必需的类型，则抛出BeanNotOfRequiredTypeException
     * @throws NoSuchBeanDefinitionException 如果没有这样的bean定义
     * @throws BeansException                如果无法创建bean
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    /**
     * 该bean工厂是否包含bean定义或外部注册的单例
     * 具有给定名称的实例？
     * <p>如果给定名称是别名，它将被翻译回相应的名称
     * 规范bean名称。
     * <p>如果该工厂是分层工厂，将询问任何父工厂，如果bean无法
     * 在此工厂实例中可以找到。
     * <p>如果找到与给定名称匹配的bean定义或单例实例，
     * 此方法将返回{@code true}命名的bean定义是否具体
     * 或抽象的，懒惰的或渴望的，无论是否在范围内。 因此，请注意，{@code true}
     * 此方法的返回值不一定表示{@link #getBean}
     * 将能够获得具有相同名称的实例。
     *
     * @param name 要查询的bean的名称
     * @return 是否存在具有给定名称的bean
     */
    boolean containsBean(String name);

    /**
     * 这个bean是单利吗？ 也就是说，{@link #getBean}将始终
     * 返回同一个实例？
     * <p>注意：此方法返回{@code false}并不能清楚地表明
     * 独立实例。 它表示非单例实例，可能与
     * 也适用于作用域Bean。 使用{@link #isPrototype}操作来显式
     * 检查独立实例。
     * <p>将别名转换回相应的规范bean名称。
     * 将询问父工厂是否在该工厂实例中找不到该bean。
     *
     * @param name 要查询的bean的名称
     * @throws NoSuchBeanDefinitionException 如果没有给定名称的bean
     * @return 此bean是否对应于一个单例实例
     */
    boolean isSingleton(String name) throws org.springframework.beans.factory.NoSuchBeanDefinitionException;

    /**
     *这个bean是多利吗？ 也就是说，{@link #getBean}总是返回
     *独立实例？
     * <p>注意：此方法返回{@code false}并不能清楚地表明
     *单例对象。 它表示非独立实例，可能与
     *也适用于作用域Bean。 使用{@link #isSingleton}操作来显式
     *检查共享单例实例。
     * <p>将别名转换回相应的规范bean名称。
     *将询问父工厂是否在该工厂实例中找不到该bean。
     * @param name 要查询的bean的名称
     * @return 此bean是否将始终提供独立的实例
     * @throws NoSuchBeanDefinitionException 如果没有给定名称的bean
     */
    boolean isPrototype(String name) throws org.springframework.beans.factory.NoSuchBeanDefinitionException;
}
