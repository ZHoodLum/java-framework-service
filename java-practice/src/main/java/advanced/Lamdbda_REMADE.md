# lamdba表达式
[TOC]



---

## Java6概述
新特性有：
* 支持lambda表达式
* 函数式接口
* 新的Stream API
* 新的日期 API
* 其他特性

## lamdba表达式说明
Lambda 表达式（lambda expression）是一个匿名函数，Lambda表达式基于数学中的λ演算得名，直接对应于其中的lambda抽象（lambda abstraction），是一个匿名函数，即没有函数名的函数。Lambda表达式可以表示闭包（注意和数学传统意义上的不同）

lambda表达式： 特殊的匿名内部类，语法简介

lambda表达式允许把函数作为一个方法的参数（函数作为方法参数传递，将代码像数据一样传递）

## lambda表达式的使用语法
```
<函数式接口> <变量名> = (参数1,参数2) -> { 
    //方法体 
}
```
lambda引入了新的操作符： -> ,也叫箭头操作符，->将表达式分成了两个部分
左侧：(参数1,参数2...)表示参数列表
右侧：{} 内部是方法体

注意事项：
* 形参列表的数据类型会自动推断
* 如果形参为空，只需要保留()就行
* 如果形参只有一个，()可以省略，只需要参数的名称就可以
* 如果执行语句只有一句的话，无返回值，{}也可以省略；若有返回值，则若想省去{},则必须同时省略return,切执行语句也必须保证只有一句
* lambda不会生成一个单独的内部类文件

eg:
创建标记接口
```java
package advanced.lambda;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/1 8:07
 * @Description:创建标记接口
 */
public class ComparatorCreate {
    public static void main(String[] args) {
        //普通写法
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        TreeSet<String> tree = new TreeSet<>(comparator);

        //lambda表达式写法1
        Comparator<String> comparator1 = (String o1, String o2) -> {
            return o1.length() - o2.length();
        };
        TreeSet<String> tree1= new TreeSet<>(comparator1);


        //lambda表达式写法2
        Comparator<String> comparator2 = (o1, o2) -> o1.length() - o2.length();
        TreeSet<String> tree2= new TreeSet<>(comparator2);

    }
}
```

创建线程
```java
package advanced.lambda;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/1 8:02
 * @Description:创建线程
 */
public class ThreadCreate {
    public static void main(String[] args) {
        //普通写法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程1开始运行....");
            }
        };
        new Thread(runnable).start();

        //lambda表达式写法1
        Runnable runnable1 = () -> {
            System.out.println("子线程2开始运行....");
        };
        new Thread(runnable1).start();

        //lambda表达式写法2
        Runnable runnable2 = () -> System.out.println("子线程2开始运行....");
        new Thread(runnable2).start();

        //lambda表达式写法3
        new Thread(() -> System.out.println("子线程3开始运行....")).start();
    }
}
```


## 函數式接口
定义：如果一个接口只有一个抽象方法，则该接口称之为函数式接口，函数式接口可以使用Lambda表达式
Lambda表达式会被匹配到这个抽象方法上。

使用注解@FunctionInterface注解检测接口是否符合函数式接口

eg：
创建线程
```java
package advanced.lambda.functionInterface;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/5 7:44
 * @Description:函数式接口的使用
 */
public class InterfaceTypeDemo {

    public static void main(String[] args) {
        /**************************消費型接口consumer****************************/
        //消费型接口
        //匿名内部类的方式
        Consumer<Double> consumer = new Consumer<Double>() {
            @Override
            public void accept(Double money) {
                System.out.println("上网" + money);
            }
        };
        happy(consumer, 100);

        //优化lambda表达式的方法 因为只有一个参数  直接去掉方法和参数即可
        Consumer<Double> consumer1 = money -> {
            System.out.println("上网" + money);
        };
        happy(consumer1, 100);

        //优化2  直接通过方法调用
        happy(money -> System.out.println("消费" + money), 200);

        /**************************supplier 攻击型接口****************************/
        int[] arr = getNum(() -> new Random().nextInt(110), 5);
        System.out.println("110以内随机数5个是：" + Arrays.toString(arr));

    }
    //消費i型接口consumer
    public static void happy(Consumer<Double> consumer, double money) {
        consumer.accept(money);
    }


    //supplier 攻击型接口
    public static int[] getNum(Supplier<Integer> supplier, int count) {
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = supplier.get();
        }
        return arr;
    }


}
```


## 常见的函数式接口
函数式接口|参数类型|返回类型|说明
:---|:---|:---|:---
Consumer<T>消费型接口|T|void|void accept(T t)；对类型为T的对象应用操作
Supplier<T>供给型接口|无|T|T get();返回类型为T的对象
Function<T,R>函数型接口|T|R|R apply(T t);对象类型为T的对象应用操作，并返回类型为R类型的对象
Predicate<T>断言型接口|T|boolean|boolean test(T t);确定类型为T的对象是否满足条件，并返回boolean类型

## 方法引用
方法引用是lambda表达式的一种简写形式。如果lambda表达式方法体中只是调用一个特定的已经存在的方法，则可以使用方法引用。

常见形式：
* 对象::实例方法
* 类::静态方法
* 类::实例方法
* 类::new

此时的操作符也是JDK8新增的符号 ::
eg:
创建对象
```java
package advanced.lambda.entity;

import lombok.Data;

import java.util.Objects;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/5 8:19
 * @Description:
 */

@Data
public class MessageEntity {
    String sex;
    String name;
    Double money;

    public MessageEntity(String sex, String name, Double money) {
        this.sex = sex;
        this.name = name;
        this.money = money;
    }

    public MessageEntity() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return sex.equals(that.sex) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sex, name);
    }
}
```
使用JDK8新增的符号 ::
```java
package advanced.lambda;

import advanced.lambda.entity.MessageEntity;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/5 8:08
 * @Description:方法引用的操作符号的使用 ::
 * * 对象::实例方法
 * * 类::静态方法
 * * 类::实例方法
 * * 类::new
 */
public class OperatorColon {
    public static void main(String[] args) {
        //对象::实例方法
        //如果接口的方法只调用一个方法，并且这个方法的特点和接口的特征一样，就可以使用::操作符
        Consumer<String> consumer = money -> System.out.println("上网" + money);
        consumer.accept("对象::实例方法1  hello");

        //优化
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("对象::实例方法2  world");

        //类::静态方法 不常用
        //比较两个数
        Comparator<Integer> comparable = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println("类::静态方法1" + comparable);

        Comparator<Integer> comparable2 = Integer::compare;
        System.out.println("类::静态方法2" + comparable2);

        //类::实例方法
        Function<MessageEntity, String> function = e -> e.getName();
        System.out.println("类::实例方法1" + function.apply(new MessageEntity("男", "职业选手小明",123.01)));

        Function<MessageEntity, String> function1 = MessageEntity::getName;
        System.out.println("类::实例方法1" + function1.apply(new MessageEntity("男", "职业选手小明2",123.3)));


        //类::new
        Supplier<MessageEntity> supplier = () -> new MessageEntity();
        Supplier<MessageEntity> supplier1 = MessageEntity::new;
    }
}
```


## Stream
流stream中保存对集合或者数组数据的操作。和集合类似，但集合中报错的是数据。

这里的流指的是：原料-->工序1-->工序2-->工序n等等之后----->形成了产品

这就叫流！！！

## Stream特点
* Stream自己不会存储元素
* 不会改变源对象。相反，他们会返回一个持续有结果的新的Stream
* Stream操作是延迟执行的。这就意味着他们会等到需要结果的时候才会执行


## Stream使用步骤
* 创建：新建一个流
* 中间操作：在一个或者多个步骤中，将初始Stream转化到另一个Stream的中间操作
* 终止操作：使用一个终止操作来产生一个结果，该操作会强制他之前的延迟操作立即执行。在这个之后，该Stream就不能使用了。

## 创建Stream
* 通过Collection对象的stream()或parallelStream()方法
* 通过Arrays类的stream方法
* 通过Stream接口的of()、iterate()、generate()方法
* 通过Instream、LongStream、DoubleStream接口中的of、range、rangeClosed方法

```java
package advanced.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/6 7:23
 * @Description:流的创建方式
 */
public class StreamCreate {
    public static void main(String[] args) {

        System.out.println("//* 通过Collection对象的stream()或parallelStream()方法");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        arrayList.add("world");
        Stream<String> stream = arrayList.stream();
//        stream.forEach(s -> System.out.println(s));
        stream.forEach(System.out::println);



        System.out.println("//* 通过Arrays类的stream方法");
        String[] arr = {"aaa", "bbb"};
        Stream<String> stream1 = Arrays.stream(arr);
        stream1.forEach(System.out::println);


        System.out.println("//* 通过Stream接口的of()、iterate()、generate()方法");
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 55, 646);
        integerStream.forEach(s -> System.out.println(s));

        System.out.println("迭代流");
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 2);
        iterate.limit(10).forEach(System.out::println);

        System.out.println("生成流");
        Stream<Object> generate = Stream.generate(() -> new Random().nextInt(20));
        generate.limit(11).forEach(System.out::println);


        System.out.println("* IntStream、LongStream、DoubleStream接口中的of、range、rangeClosed 方法\n");
        IntStream intStream = IntStream.of(123, 123, 565);
        intStream.forEach(System.out::println);

        //0到122的值  开口
        IntStream range = IntStream.range(0, 123);
        range.forEach(System.out::println);

        //表示0到123的值 闭口
        IntStream intStream1 = IntStream.rangeClosed(0, 123);
        intStream1.forEach(System.out::println);
    }
}
```

## 中间操作Stream
* filter、limit、skip、distinct、sorted
* map
* parallel


```java
package advanced.lambda.entity;

import lombok.Data;

import java.util.Objects;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/5 8:19
 * @Description:
 */

@Data
public class MessageEntity {
    String sex;
    String name;
    Double money;

    public MessageEntity(String sex, String name, Double money) {
        this.sex = sex;
        this.name = name;
        this.money = money;
    }

    public MessageEntity() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return sex.equals(that.sex) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sex, name);
    }
}

```
```java
package advanced.lambda;

import advanced.lambda.entity.MessageEntity;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/6 7:41
 * @Description:流的中间操作
 */
public class StreamMiddle {
    public static void main(String[] args) {
        ArrayList<MessageEntity> arrayList = new ArrayList<>();
        arrayList.add(new MessageEntity("男", "周总",123.01));
        arrayList.add(new MessageEntity("男", "周总",1232.00));
        arrayList.add(new MessageEntity("中", "二哈",1232.03));
        arrayList.add(new MessageEntity("女", "张总",1233.50));
        arrayList.add(new MessageEntity("女", "王总",1234.60));

        //中间操作 filter 过滤、limit 限制、skip 跳过、distinct 去重、sorted 排序
        System.out.println("---------filter 过滤----------");
        arrayList.stream()
                .filter(s -> s.getSex().equals("男"))
                .forEach(System.out::println);

        System.out.println("---------limit 限制----------");
        arrayList.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("---------skip 跳过----------");
        arrayList.stream()
                .skip(1)
                .forEach(System.out::println);

        System.out.println("---------distinct 去重 需要在对象MessageEntity中重写HashCode和equals方法啊才可以----------");
        arrayList.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("---------sorted 排序----------");
        arrayList.stream()
                .sorted((q1, q2) -> Double.compare(q1.getMoney(), q1.getMoney()))
                .forEach(System.out::println);

        System.out.println("---------map----------");
        arrayList.stream()
                .map(e -> e.getName())
                .forEach(System.out::println);

        System.out.println("---------parallel 采用的是多线程 效率高----------");
        arrayList.parallelStream()
                .forEach(System.out::println);

        System.out.println("*****************************串行流和并行流*****************************");
        ArrayList<String> arrayList1 = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            arrayList1.add(UUID.randomUUID().toString());
        }

        //串行 用时 4毫秒
        long startTime = System.currentTimeMillis();
        long count = arrayList1.stream().count();
        System.out.println(count);
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - startTime));


        //并行  用时1毫秒
        long startTime1 = System.currentTimeMillis();
        long count1 = arrayList1.parallelStream().count();
        System.out.println(count1);
        long endTime1 = System.currentTimeMillis();
        System.out.println("用时：" + (endTime1 - startTime1));

    }
}
```

## 终止操作Stream
* forEach、min、max、count
* reduce、collect
```java
package advanced.lambda;

import advanced.lambda.entity.MessageEntity;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/6 8:08
 * @Description: 流的终止操作
 */
public class StreamStop {
    public static void main(String[] args) {
        ArrayList<MessageEntity> arrayList = new ArrayList<>();
        arrayList.add(new MessageEntity("男", "周总",123.01));
        arrayList.add(new MessageEntity("男", "周总",1232.00));
        arrayList.add(new MessageEntity("中", "二哈",1232.03));
        arrayList.add(new MessageEntity("女", "张总",1233.50));
        arrayList.add(new MessageEntity("女", "王总",1234.60));

        //所有操纵延迟执行
        System.out.println("---------------终止操作 forEach ---------------");
        arrayList.stream()
                .filter(s -> {
                    System.out.println("执行过滤条件");
                    return s.getSex().equals("男");
                })
                .forEach(System.out::println);

        System.out.println("---------------终止操作 min 工资最低---------------");
        Optional<MessageEntity> optionalMin = arrayList.stream()
                .min((e1, e2) -> Double.compare(e1.getMoney(), e2.getMoney()));
        System.out.println(optionalMin.get());

        System.out.println("---------------终止操作 max 工资最高---------------");
        Optional<MessageEntity> optionalMax = arrayList.stream()
                .max((e1, e2) -> Double.compare(e1.getMoney(), e2.getMoney()));
        System.out.println(optionalMax.get());

        System.out.println("---------------终止操作 count 员工个数---------------");
        long count = arrayList.stream().count();
        System.out.println(count);
    }
}
```


## 新时间API
之前的时间API存在问题:线程安全问题、设计混乱

本地化日期时间API：
* LocalDate
* LocalTime
* LocalDateTime
```java
package advanced.lambda;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/11 23:14
 * @Description:时间的线程安全问题
 */
public class DateSimpleDateFormat {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyMMdd");

        //创建线程池
        ExecutorService pools = Executors.newFixedThreadPool(9);
        Callable<Date> callable = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                //Exception in thread "main" java.util.concurrent.ExecutionException: java.lang.NumberFormatException: For input string: ""
                //	at java.util.concurrent.FutureTask.report(FutureTask.java:122)
                //	at java.util.concurrent.FutureTask.get(FutureTask.java:192)
                //	at advanced.lambda.DateSimpleDateFormat.main(DateSimpleDateFormat.java:35)
                //Caused by: java.lang.NumberFormatException: For input string: ""
                //会报错  线程安全问题除非加入synchronized上锁  才不会发生上面的问题
                synchronized (simpleDateFormat) {
                    return simpleDateFormat.parse("20210712");
                }
            }
        };

        //将时间存放在List集合中
        List<Future<Date>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Date> funcTrue = pools.submit(callable);
            list.add(funcTrue);
        }

        for (Future<Date> funcTrue : list) {
            System.out.println(funcTrue.get());
        }

        //==========================JDK1.8特性==================================================//
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> callable1 = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20210713", dateTimeFormatter);
            }
        };

        //将时间存放在List集合中
        List<Future<Date>> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Date> funcTrue = pools.submit(callable);
            list.add(funcTrue);
        }

        for (Future<Date> funcTrue : list1) {
            System.out.println(funcTrue.get());
        }

        //关闭线程池
        pools.shutdown();



        //==============================本地化日期时间API=======================================//
        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDateTime localDateTime2 = LocalDateTime.of(year,month,dayOfMonth,hour,mintue);
        System.out.println(localDateTime);
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonthValue());

        //当前时间加2天
        LocalDateTime localDateTime1 = localDateTime.plusDays(2);
        //减少两天
        LocalDateTime localDateTime2 = localDateTime.minusDays(1);


        //==============================本时间戳与时区======================================//

        //Instant 时间戳
        Instant instant = Instant.now();
        System.out.println("现在打印的时间与实际时间应该差8个小时，与格林尼治的时间就是差8个小时的："+instant.toString());

        //加十秒
        Instant instant1 = instant.plusSeconds(10);
        //减十秒
        Instant instant2 = instant.minusSeconds(10);

        //ZoneID 时区
        Set<String> strings = ZoneId.getAvailableZoneIds();
        for (String str : strings) {
            System.out.println("所有时区：" + str);
        }

        System.out.println("中国时区" + ZoneId.systemDefault().toString());



        //==============================Date、Instant、LocalDateTime 的转换======================================//
        //1 Date --> Instant
        Date date = new Date();
        Instant instant3 = date.toInstant();
        System.out.println("Date转换为Instant：" + instant3);

        //Instant --> localDateTime
        LocalDateTime localDateTime3 = LocalDateTime.ofInstant(instant3, ZoneId.systemDefault());
        System.out.println("Instant --> localDateTime 当前时间"+localDateTime3);

        //localDateTime  -->  Instant 先获取时区在转换为instatn
        Instant instant4 = localDateTime3.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant4);

        //Instant -->  Date
        Date date1 = Date.from(instant4);
        System.out.println("Instant -->  Date 当前的时间是：" + date1);


        //============================== DateTimeFormatter 时间格式化======================================//
        //时间格式化字符串
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //当前时间格式化
        String format = dateTimeFormatter1.format(LocalDateTime.now());
        System.out.println("时间格式化字符串" + format);


        //把字符转解析城市间
        LocalDateTime parse = LocalDateTime.parse("2021/07/12 23:54:12", dateTimeFormatter1);
        System.out.println("把字符转解析城市间" + parse);

    }
}
```


## Instant 时间戳

## ZoneID 时区

## Date、Instant、LocalDateTime 的转换

## DateTimeFormatter 时间格式化

## lambda遍历List集合
```java
package advanced.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：ZDY
 * @Date：Created on 2021/4/17 11:43
 * @Description:
 */
public class LambdaIterator {
    public static void main(String[] args) {
        List<Map<String, String>> list = new ArrayList<>();

        Map<String, String> map = new HashMap();
        map.put("b", "2222");
        map.put("a", "aaaa");
        map.put("c", "ffff");
        map.put("d", "gggg");

        list.add(map);

        list.forEach(n -> {
            n.forEach((key, value) -> {
                System.out.println(key + "----" + value);
            });
        });

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("asd,dd,a22,123");

        String[] strings = stringBuffer.toString().split(",");
        for (String n : strings) {
            System.out.print(n + " ");
        }


        System.out.println("===========================");
        String appName = "global_Gatewayasdasd_dasd_GLO";
        if (appName.toUpperCase().contains("GLOBAL") || appName.toLowerCase().contains("global")) {
            System.out.println("YESYESYES22");
        } else {
            System.out.println("NONONO22");
        }

    }

}
```



### 函数式接口的使用
创建接口
```java
package advanced.lambda.functionInterface;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/4 8:20
 * @Description:创建一个接口，用于使用lambda表达式
 */

@FunctionalInterface
public interface CreateInterfaceService {
     void active();
//    String hello();
}
```

创建实现类
```java
package advanced.lambda.functionInterface;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/4 8:21
 * @Description:
 */

@Slf4j
public class DemoServiceImpl {

    public static void main(String[] args) {
        CreateInterfaceService createInterfaceService = new CreateInterfaceService() {
            @Override
            public void active() {
                log.info("你好，我是lambda表达式");
            }
        };
        runMethod(createInterfaceService);

        System.out.println("我是分割綫！！！！！");


        CreateInterfaceService createInterfaceService2 = () -> {
            System.out.println("你好，我是lambda表达式");
        };
        runMethod(createInterfaceService2);


    }

    //調用靜態方法
    public static void runMethod(CreateInterfaceService createInterfaceService) {
        createInterfaceService.active();
    }
}
```