package method_area;

/**
 * 运行时常量池 vs class 常量池 vs string 常量池
 * jvm 方法区
 *
 * @author Alan Yin
 * @date 2020/11/26
 */

public class JvmMethodDemo {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);

        String s3 = new String("def");
        String s4 = s3.intern();
        String s5 = "def";
        System.out.println(s3 == s4);
        System.out.println(s4 == s5);
    }
}
