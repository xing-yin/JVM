package lecture4.demo2;

/**
 * @author Alan Yin
 * @date 2021/9/13
 */

public class Application {

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        SubClass.testStaticMethod();
        subClass.testNoStaticMethod();
    }
}
