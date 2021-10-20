package volatile_test;

/**
 * @author Alan Yin
 * @date 2021/10/15
 */

public class DoubleCheckLock {

    public static DoubleCheckLock instance;

    public DoubleCheckLock() {
    }

    public static DoubleCheckLock getInstance() {
        // 第一次检测
        if (instance == null) {
            // 同步
            synchronized (DoubleCheckLock.class) {
                if (instance == null) {
                    // 多线程环境下可能会出现问题
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }

}


