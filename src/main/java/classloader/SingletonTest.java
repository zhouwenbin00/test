package classloader;

/**
 * @author zwb
 */
public class SingletonTest {


    public void test(){
        System.out.println("2");
    }

    //--------单例-----------
    public static SingletonTest getInstance() {
        return SingletonTest.Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        SingletonTest instance;

        Singleton() {
            this.instance = new SingletonTest();
        }

        SingletonTest getInstance() {
            return instance;
        }
    }

}
