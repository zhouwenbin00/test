package classloader;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/** @author zwb */
public class MyClassLoader extends ClassLoader {

    private String rootPath;

    /*存放需要本类加载器加载的类*/
    private Set<String> classes;

    public MyClassLoader(String rootPath, String... clazzPaths) throws IOException {
        this.rootPath = rootPath;
        this.classes = new HashSet<>();
        File file = new File(rootPath);
        if (!file.isDirectory()) {
            System.out.println("???-");
        }
        loadAllClass(file, null);
        for (String clazzPath : clazzPaths) {
            File temp = new File(clazzPath);
            if (!temp.isDirectory()) {
                System.out.println("???-");
            }
            loadAllClass(temp, null);
        }
    }

    private void loadAllClass(File dir, String pkg) throws IOException {
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("??/");
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                String pkg0 = pkg == null ? file.getName() : pkg + "." + file.getName();
                loadAllClass(file, pkg0);
            } else {
                if (file.getName().endsWith(".class")) {
                    String className = fileNameToClassName(file.getName(), pkg);
                    if (classes.contains(className)){
                        continue;
                    }
                    byte[] bytes = loadClassData(file);
                    System.out.println("load---" + className);
                    classes.add(className);
                    Class<?> clazz = defineClass(className, bytes, 0, bytes.length);
                    Class<?> supClass = clazz.getSuperclass();
                    while (supClass != null){
                        if (supClass.getName().startsWith("java.")){
                            break;
                        }
                        classes.add(supClass.getName());
                        supClass = supClass.getSuperclass();
                    }
                    for (Class<?> aClass : clazz.getInterfaces()) {
                        classes.add(aClass.getName());
                    }
                }
            }
        }
    }



    private byte[] loadClassData(File file) throws IOException {
        InputStream is = null;
        ByteArrayOutputStream outputStream = null;
        is = new FileInputStream(file);
        outputStream = new ByteArrayOutputStream();
        int i = 0;
        while ((i = is.read()) != -1) {
            outputStream.write(i);
        }
        outputStream.close();
        is.close();

        return outputStream.toByteArray();
    }

    private String fileNameToClassName(String name, String pkg) {
        int i = name.lastIndexOf(".class");
        if (i==-1){
            System.out.println(name);
        }
        return pkg + "." + name.substring(0, i);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            Class<?> loadedClass = findLoadedClass(name);
            if (loadedClass == null) {
                if (!classes.contains(name)) {
                    return getSystemClassLoader().loadClass(name);
                } else {
                    throw new ClassNotFoundException();
                }
            }
            return loadedClass;
        }
    }
}
