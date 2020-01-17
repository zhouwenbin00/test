package classloader;

import java.lang.reflect.Method;

/** @author zwb */
public class Application {

    /**
     * @param clazz 启动类
     * @param method 启动方法
     */
    public static void run(Class<?> clazz, String method, Object... arg)
            throws Exception {

        String path = clazz.getResource("/").getPath();
        System.out.println(path);
        MyClassLoader myClassLoader =
                new MyClassLoader(path);
        Class<?> startClass = myClassLoader.loadClass(clazz.getName());
        Object o = startClass.newInstance();
        Class<?>[] classes = new Class[arg.length];
        for (int i = 0; i < arg.length; i++) {
            classes[i] = arg[i].getClass();
        }
        Method startMethod = startClass.getMethod(method,classes );
        startMethod.invoke(o, arg);
    }
}
