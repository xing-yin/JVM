package reflect;

/**
 * @author Alan Yin
 * @date 2020/12/3
 */

public class Line {

    static {
        System.out.println("静态代码块执行: loading line");
    }

    public static String s = getString();

    private static String getString() {
        System.out.println("给静态变量赋值的静态方法执行：loading line");
        return "test";
    }

    public static void test() {
        System.out.println("普通静态方法执行：loading line");
    }

    {
        System.out.println("普通的代码块");
    }

    public Line() {
        System.out.println("构造方法执行");
    }
}
