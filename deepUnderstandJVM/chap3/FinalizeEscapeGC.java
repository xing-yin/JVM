package  chap3;

/**
 * 演示两点:
 * 1.对象可以在被 GC 时自我拯救
 * 2.这种自救的机会只有一次，因为一个对象的 finalize() 方法最多只会被系统自动调用一次
 *
 * @author: yinxing
 * @date: 2019/3/3
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        // 自救:重新与引用连的任意一个对象建立关联即可
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次成功自救
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize() 方法优先级很低，所以暂停 0.5 秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }

        // 对象第二次自救失败（与上面的代码完全相同）
        // （因为一个对象的 finalize() 方法最多只会被系统自动调用一次）
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize() 方法优先级很低，所以暂停 0.5 秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }
    }
}
