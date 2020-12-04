package com.alany.blog.lambada.stream;

import java.util.List;
import java.util.function.Predicate;

/**
 * Stream 常见用法
 *
 * @author Alan Yin
 * @date 2019/12/25
 */

public class StreamDemo {

    public static void main(String[] args) {

        // Stream 介绍
        // Stream是一个借口继承了BaseStream接口，BaseStream接口继承了AutoCloseable接口。
        // 它只能被消费一次，如果想要继续使用，需要重新创建一个流。如下会抛出异常。
//        List<String> stringList = Arrays.asList("a", "b", "c");
//        Stream<String> stream1 = stringList.stream();
//        stream1.forEach(System.out::println);
//        stream1.forEach(System.out::println);

        // ==================================================
        // 内部迭代实现机制
        // 外部迭代:首先调用Iterator方法，产生一个新的Iterator对象，进行控制迭代过程。
//        User u1 = new User("jack", 18, "hz");
//        User u2 = new User("rose", 19, "cs");
//        List<User> userList = Arrays.asList(u1, u2);
//        for (User user : userList) {
//            System.out.println(user.getName());
//        }

        /**
         * 内部迭代:首先调用stream方法，它的作用和iterator()方法一样，不过它返回的是内部迭代中相应的接口Stream。
         * 这样做的好处就是在迭代时要进行多次操作时可以不用多次循环，只需要迭代一次就好了。
         *
         * 像filter这种不产生新集合的方法叫做惰性求值方法，像count这样最终会从Stream产生值的方法叫作及早求值方法。
         */
//        // 不会真正触发计算
//        userList.stream()
//                .filter(user -> {
//                    System.out.println(user.getName());
//                    return user.getAge() > 18;
//                });
//        // 真正触发计算(如 count)
//        userList.stream()
//                .filter(user -> {
//                    System.out.println(user.getName());
//                    System.out.println(user.getAddress());
//                    return user.getAge()>18;
//                }).count();


        // ==================================================
        // 常用方法
        /**
         * collect 方法
         * 将Stream流转换为一个集合
         */
//        Stream<String> stream2 = Stream.of("a", "b", "c");
//        List<String> stringList = stream2.collect(Collectors.toList());
//        stringList.forEach(System.out::println);

        /**
         * filter方法
         * 过滤掉流中不符合条件的元素
         */
//        Stream<Integer> nums = Stream.of(18, 19, 20);
//        nums.filter(num -> num > 18)
//                .forEach(System.out::println);

        /**
         * map方法
         * 将流中的元素转换为另外一个元素
         */
//        Stream<Integer> nums2 = Stream.of(1, 2, 3);
//        nums2.map(num -> num + 100)
//                .forEach(System.out::println);

        /**
         * flatMap方法
         * 将底层的元素全部抽出来放到一起("把数据拍平")，如下将List中的元素全部抽取出来，流中只包含Integer元素
         */
//        List<Integer> numList1 = Arrays.asList(1, 2, 3);
//        List<Integer> numList2 = Arrays.asList(4, 5);
//        Stream.of(numList1, numList2)
//                .flatMap(num -> num.stream())
//                .forEach(System.out::println);

        /**
         * reduce方法
         * 将Stream流中的数据聚合成一个数据
         */
//        Stream<Integer> nums3 = Stream.of(1, 2, 3);
//        int age = nums3.reduce(0, (a, b) -> a + b);
//        System.out.println(age);

        /**
         * 创建无限流
         * Stream的API提供了两个静态方法创建无限流：iterate 和 generate。
         * 由两个静态方法创建的流会根据给定的函数按需创建流一般会使用limit限制流的大小。
         * iterate方法会对每个新生成的值都调用函数, generate 方法不会对每个新生成的值应用函数.
         */
//        // 从 0 开始，生成 10 个数据
//        Stream.iterate(0, n -> n + 2)
//                .limit(10)
//                .forEach(System.out::println);
//        System.out.println("====");
//        // 生成10个随机数
//        Stream.generate(Math::random)
//                .limit(10)
//                .forEach(System.out::println);

        /**
         * 其他方法:
         skip：跳过指定个数的流。
         limit：返回不超过给定长度的流。
         max：找到最大的元素
         min：找到最小的元素
         findFirst：找到第一个匹配元素
         findAny：获取任意一个元素
         anyMatch：是否存在一个匹配元素
         noneMatch：是否全部不匹配
         allMatch：是否全部匹配
         sorted：排序
         distinct：去重
         */

        // ==================================================
        // 以下为 Java 8 lambda 表达式10个示例
        /**
         * 例1、用lambda表达式实现Runnable
         *
         * 你可以使用lambda写出如下代码：
         * (params) -> expression
         * (params) -> statement
         * (params) -> { statements }
         */
//        // Java 8之前
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Before Java8");
//            }
//        }).start();
//
//        // java 8
//        new Thread(() -> System.out.println("java8")).start();

        /**
         * 例2、使用Java 8 lambda表达式进行事件处理
         */
        // 如果你用过Swing API编程，你就会记得怎样写事件监听代码。
        // 这又是一个旧版本简单匿名类的经典用例，但现在可以不这样了。你可以用lambda表达式写出更好的事件监听代码，如下所示：
        // Java 8之前：
//        JButton show = new JButton("show");
//        show.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Before Java8");
//            }
//        });
//        // java 8
//        show.addActionListener((e) -> {
//            System.out.println("java8 lambada");
//        });

//         // Java 8之前：
//        List<Integer> list = Arrays.asList(2, 1, 3);
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (o1 > o2) {
//                    return 1;
//                } else if (o1.equals(o2)) {
//                    return 0;
//                } else {
//                    return -1;
//                }
//            }
//        });
//        System.out.println(list);
//        // java 8
//        Collections.sort(list, (o1, o2) -> {
//            if (o1 > o2) {
//                return 1;
//            } else if (o1.equals(o2)) {
//                return 0;
//            } else {
//                return -1;
//            }
//        });
//        System.out.println(list);

        /**
         * 例3、使用lambda表达式对列表进行迭代
         *
         * 如果你使过几年Java，你就知道针对集合类，最常见的操作就是进行迭代，并将业务逻辑应用于各个元素，例如处理订单、交易和事件的列表。
         * 由于Java是命令式语言，Java 8之前的所有循环代码都是顺序的，即可以对其元素进行并行化处理。
         * 如果你想做并行过滤，就需要自己写代码，这并不是那么容易。
         * 通过引入lambda表达式和默认方法，将做什么和怎么做的问题分开了，这意味着Java集合现在知道怎样做迭代，并可以在API层面对集合元素进行并行处理。
         * 下面的例子里，我将介绍如何在使用lambda或不使用lambda表达式的情况下迭代列表。
         * 你可以看到列表现在有了一个 forEach() 方法，它可以迭代所有对象，并将你的lambda代码应用在其中。
         */
//        // Java 8之前
//        List<String> list = Arrays.asList("a", "b", "c");
//        for (String s : list) {
//            System.out.println(s);
//        }
//        // java 8
//        list.forEach(s -> System.out.println(s));
//        list.forEach(System.out::println);

        /**
         * 例4、使用lambda表达式和函数式接口Predicate
         *
         * Stream API的过滤方法也接受一个Predicate，这意味着可以将我们定制的 filter() 方法替换成写在里面的内联代码，这就是lambda表达式的魔力。
         * 另外，Predicate接口也允许进行多重条件的测试，下个例子将要讲到。
         */
//        // java 8
//        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
//
//        System.out.println("Languages which starts with J :");
//        filter(languages, (str) -> ((String) str).startsWith("J"));
//
//        System.out.println("Languages which ends with a :");
//        filter(languages, (str) -> ((String) str).endsWith("s"));
//
//        System.out.println("Print all languages :");
//        filter(languages, (str) -> true);
//
//        System.out.println("Print no language : ");
//        filter(languages, (str) -> false);
//
//        System.out.println("Print language whose length greater than 4:");
//        filter(languages, (str) -> ((String) str).length() > 4);

        /**
         * 例5、如何在lambda表达式中加入Predicate
         *
         * 上个例子说到，java.util.function.Predicate 允许将两个或更多的 Predicate 合成一个。
         * 它提供类似于逻辑操作符AND和OR的方法，名字叫做 and()、or()，用于将传入 filter() 方法的条件合并起来。
         * 例如，要得到所有以J开始，长度为四个字母的语言，可以定义两个独立的 Predicate 示例分别表示每一个条件，
         * 然后用 Predicate.and() 方法将它们合并起来，如下所示
         */
//        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
//        // 甚至可以用and()、or()逻辑函数来合并Predicate，
//        // 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
//        Predicate<String> startWithJ = (n) -> n.startsWith("J");
//        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
//        languages.stream()
//                .filter(startWithJ.and(fourLetterLong))
//                .forEach((n) -> System.out.println("result is :" + n));

        /**
         * 例6、Java 8中使用lambda表达式的Map和Reduce示例
         *
         * 本例介绍最广为人知的函数式编程概念map。它允许你将对象进行转换。
         * 例如在本例中，我们将 costBeforeTax 列表的每个元素转换成为税后的值。
         * 我们将 x -> x*x lambda表达式传到 map() 方法，后者将其应用到流中的每一个元素。
         * 然后用 forEach() 将列表元素打印出来。使用流API的收集器类，可以得到所有含税的开销。
         * 有 toList() 这样的方法将 map 或任何其他操作的结果合并起来。由于收集器在流上做终端操作，因此之后便不能重用流了。
         * 你甚至可以用流API的 reduce() 方法将所有数字合成一个，下一个例子将会讲到。
         */
//        // Java 8之前: 不使用lambda表达式为每个订单加上12%的税
//        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        for (Integer cost : costBeforeTax) {
//            double price = cost + 0.12 * cost;
//            System.out.println(price);
//        }
//
//        // java 8
//        costBeforeTax.stream()
//                .map((cost) -> cost + 0.12 * cost)
//                .forEach(System.out::println);

    }


    public static void filter(List<String> names, Predicate condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }
}


// Java 8之前

// java 8