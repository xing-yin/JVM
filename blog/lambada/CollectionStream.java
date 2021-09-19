package lambada;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alan Yin
 * @date 2019/12/25
 */

public class CollectionStream {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = list1.stream()
                .distinct()
                .map(i -> i * 2)
                .collect(Collectors.toList());
        System.out.println(list2);
    }
}
