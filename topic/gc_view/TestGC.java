package gc_view;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * 测试 GC view（如 GCEasy）
 *
 * 配置参数: -XX:+UseG1GC -XX:MaxGCPauseMillis=100 -Xmx256m -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC -Xloggc:./gc.log
 * @author Alan Yin
 * @date 2020/12/3
 */

public class TestGC {

    /**
     * 不断的产生新的数据（对象），随机的废弃对象（垃圾）
     */
    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<>();
        while (true) {
            int sleep = new Random().nextInt(100);

            if (System.currentTimeMillis() % 2 == 0) {
                list.clear();
            } else {
                // 向list中添加10000个对象
                for (int i = 0; i < 10000; i++) {
                    Properties properties = new Properties();
                    properties.put("key_" + i, "value_" + System.currentTimeMillis());
                    list.add(properties);
                }
            }

            Thread.sleep(sleep);
        }
    }
}
