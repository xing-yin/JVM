package volatile_test;

/**
 * 演示：指令乱序执行
 *
 * @author Alan Yin
 * @date 2021/10/18
 */

public class MixedOrder {

    int a = 0;

    boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void read() {
        if (flag) {
            int i = a + 1;
        }
    }

}
