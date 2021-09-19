package lecture9.demo2;

import java.lang.invoke.*;

/**
 * 巡回赛
 *
 * @author yinxing
 * @date 2019/12/9
 */

public class Circuit {

    /**
     * 启动方法。它将接收前面提到的三个固定参数，并且返回一个链接至 Horse.race 方法的 ConstantCallSite。
     *
     * @param lookup
     * @param name
     * @param callsiteType
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     */
    public static CallSite bootstrap(MethodHandles.Lookup lookup, String name, MethodType callsiteType) throws NoSuchMethodException, IllegalAccessException {
        MethodHandle mh = lookup.findVirtual(Horse.class, name, MethodType.methodType(void.class));
        return new ConstantCallSite(mh.asType(callsiteType));
    }

    public static void startRace(Object obj) {
        // aload obj
        // invokedynamic race()
        // 动态调用 race() 方法
    }

    public static void main(String[] args) {
        startRace(new Horse());
        startRace(new Deer());
    }
}
