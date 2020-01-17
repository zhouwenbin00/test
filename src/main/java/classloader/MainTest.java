package classloader;


/**
 * @author zwb
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
        Application.run(MainTest.class, "main");
    }

    public void start() throws Exception {
        SingletonTest instance = SingletonTest.getInstance();
        instance.test();
    }
}
