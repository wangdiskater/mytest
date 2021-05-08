package mytest.jdk.collection;

import jdk.vm.ci.meta.Local;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description TreeSet是基于TreeMap实现的。TreeSet中的元素支持2种排序方式：自然排序 或者 根据创建TreeSet 时提供的 Comparator 进行排序。这取决于使用的构造方法。
 * @ClassName TreeSetTest
 * @Author wangDi
 * @date 2021-05-07 16:12
 */
public class TreeSetTest {


    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.of(1992, 1, 1);
        LocalDate localDate3 = LocalDate.of(2021, 7, 13);
        LocalDate localDate2 = LocalDate.of(1995, 5, 5);
        LocalDate localDate4 = LocalDate.of(1995, 5, 9);

        //TreeSet 按照日期排序
        Set<LocalDate> localDates = new TreeSet<>();
        localDates.add(localDate1);
        localDates.add(localDate3);
        localDates.add(localDate2);
        localDates.add(localDate4);
        printSet(localDates);
        System.out.println("-----");

        Set<LocalDate> localDates2 = new TreeSet<>(new Comparator<LocalDate>() {
            @Override
            public int compare(LocalDate o1, LocalDate o2) {
                int year1 = o1.getYear();
                int year2 = o2.getYear();
                // 年份高的排在前面
                // 月份就按插入的时候排
                return -(year1 - year2);
            }
        });

        boolean add3 = localDates2.add(localDate1);
        boolean add2 = localDates2.add(localDate3);
        boolean add1 = localDates2.add(localDate2);
        // 要去重所以没了
        boolean add = localDates2.add(localDate4);

        printSet(localDates2);


    }

    private static void printSet(Set<LocalDate> localDates) {
        localDates.forEach(System.out::println);
    }


}
