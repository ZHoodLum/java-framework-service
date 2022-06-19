package arithmetic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/25
 * @Description:分行发饼干 -  贪心算法
 */


public class GreedyAlgorithm {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println("原始数据");
        list.stream().forEach(System.out::print);


        list = (List) list.stream().filter(str -> !str.equals("2")).collect(Collectors.toList());
        System.out.println();
        System.out.println("lambda遍历");
        list.stream().forEach(System.out::print);


        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("2")) {
                iterator.remove();
            }
        }
        System.out.println();
        System.out.println("Iterator遍历");
        list.stream().forEach(System.out::print);
    }
}
