package com.alany.analysejvm.lecture14.foreach;

import java.util.Iterator;
import java.util.List;

/**
 * @author yinxing
 * @date 2019/12/12
 */

public class CollectionForeachDemo {

    public void foo(List<Integer> list) {
        for (Integer item : list) {
        }
    }

    /**
     * 等同于
     */
    public void bar(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
        }
    }
}
