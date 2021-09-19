package lecture14.switch_demo;

/**
 * @author yinxing
 * @date 2019/12/13
 */

public class SwitchDemo {

    public int foo(int i) {
        int j;
        switch (i) {
            case 1:
                j = 1;
                break;
            case 2:
                j = 2;
                break;
            default:
                j = 3;
        }
        return j;
    }
}
