package spring.ioc;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认的bean工厂
 *
 * @author zwb
 */
public class DefaultBeanFactory implements BeanFactory, BeanDefinitionRegistry {


    private Map<String, Object> beanMap = new ConcurrentHashMap<>();
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String beanName) throws Exception {
        return doGetBean(beanName);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return null;
    }

    @Override
    public boolean containsBean(String name) {
        return false;
    }

    @Override
    public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
        return false;
    }

    private Object doGetBean(String beanName) throws Exception {
        Objects.requireNonNull(beanName, "beanName不能为空");
        Object instance = beanMap.get(beanName);
        // 如果instance存在，直接返回
        if (instance != null) {
            return instance;
        }
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        Objects.requireNonNull(beanDefinition, "beanDefinition不能为空");
        Class<?> beanClass = beanDefinition.getBeanClass();
        Objects.requireNonNull(beanClass, "beanClass不能为空");
        instance = beanClass.newInstance();
        // 如果是单列的，放入容器，下次直接拿
        if (beanDefinition.isSingleton()) {
            beanMap.put(beanName, instance);
        }
        return instance;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception {
        Objects.requireNonNull(beanName, "beanName不能为空");
        Objects.requireNonNull(beanDefinition, "beanDefinition不能为空");
        if (containsBeanDefinition(beanName)) {
            throw new Exception("已经存在的beanName" + beanName);
        }
        beanDefinitionMap.put(beanName, beanDefinition);

    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }
}
