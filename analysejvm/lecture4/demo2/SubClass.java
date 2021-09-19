package lecture4.demo2;

/**
 * 如果子类定义了与父类中非私有方法同名的方法，而且这两个方法的参数类型相同，那么这两个方法之间又是什么关系呢？
 * <p>
 * - 如果这两个方法都是静态的，那么子类中的方法将隐藏父类中的方法。
 * - 如果这两个方法都不是静态的，且都不是私有的，那么子类的方法重写了父类中的方法。
 *
 * @author Alan Yin
 * @date 2021/9/13
 */

public class SubClass extends ParentClass {

    public static String testStaticMethod() {
        System.out.println("SubClass testStaticMethod");
        return "SubClass";
    }

    @Override
    public String testNoStaticMethod() {
        System.out.println("SubClass testNoStaticMethod");
        return "SubClass";
    }

}
