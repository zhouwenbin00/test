package spring.ioc;

public class GenericBeanDefinition implements BeanDefinition {

    /**
     * 字节码对象
     */
    private Class<?> beanClas;

    /**
     *
     */
    private String initMethodName;

    /**
     * 域
     */
    private String scope = BeanDefinition.SINGLETION;

    @Override
    public Class<?> getBeanClass() {
        return beanClas;
    }

    @Override
    public boolean isSingleton() {
        return scope.equals(BeanDefinition.SINGLETION);
    }

    @Override
    public boolean isPrototype() {
        return scope.equals(BeanDefinition.PROTOTYPE);
    }

    @Override
    public String getScope() {
        return scope;
    }


}
