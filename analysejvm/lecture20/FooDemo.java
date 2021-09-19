package lecture20;

/**
 * @author Alan Yin
 * @date 2019/12/23
 */

public class FooDemo {

   static class Foo {
        int a = 0;
    }

    static int bar(int x){
        Foo foo = new Foo();
        foo.a = x;
        return foo.a;
    }
}
