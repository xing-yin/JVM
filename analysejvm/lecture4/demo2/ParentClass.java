package lecture4.demo2;

/**
 * @author Alan Yin
 * @date 2021/9/13
 */

public class ParentClass {

    public static String testStaticMethod(){
        System.out.println("ParentClass testStaticMethod");
        return "ParentClass";
    }

    public String testNoStaticMethod(){
        System.out.println("ParentClass testNoStaticMethod");
        return "ParentClass";
    }

}
