package com.base.page44;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Name ComparableAndComparatorTest
 * @Author 18057
 * @Createed 16:17 2020/11/3
 * @Description Comparable 接口 Comparator 接口
 * @Version 1.0.0
 */
@Slf4j
public class ComparableAndComparatorTest {

    /**
     * Comparable 是排序接口
     * 该 接口 中 有一个 方法 int compareTo(T o);
     * 实现 comparable 接口 必须重写 compareTo 方法 其返回值 是 根据 x.compareTo(y) 来 比较 x 与 y 的 大小;
     * 若 返回 负数 意味着 x 比 y 小;
     * 若 返回 0    意味着 x 等于 y ;
     * 若 返回 正数 意味着 x 比 y 大;
     */

    /**
     * Comparator 是 比较器接口
     * 我们若需要控制某个类的次序 而 该类本身不支持排序(即没有实现 Comparable 接口),那么我们就可以建立一个 该类的比较器
     * 该 接口 中 有两个方法 int compare(T o1, T o2);   boolean equals(Object obj);
     * 若一个类要实现 Comparator 接口 它一定要实现 compareTo(T o1,T o2) 方法 但可以不实现 equals(Object obj)方法.
     *      为什么可以不实现 equals 方法呢?因为任何类都继承于 java.lang.Object
     *
     *
     */

    /**
     * comparable 接口 和 comparator 接口的区别?
     * 两者都是被用来 对对象集合或者数组进行排序.
     * Comparable 接口 被 用来提供对象的自然排序 可使用它来提供基于单个(字段 不论是 Integer类型 还是 String 类型)逻辑的排序  --内部比较器
     * Comparator 接口 被 用来提供不同的排序算法 可根据制定字段选择需要使用的 Comparator 来对指定的对象集合进行排序.         --外部比较器
     */


    @Test
    public void comparableTest() {

        List<Student> students = new ArrayList<>();

        Student student1 = new Student("DiSi", 27);

        Student student2 = new Student("FiSa", 25);

        int number = student1.compareTo(student2);

        log.info("比较的结果 : {}", number);
        students.add(student1);
        students.add(student2);

        log.info("原来 students 的集合 顺序: {}", students);

        Collections.sort(students);

        log.info("经过 sort排序后 的集合 顺序: {}", students);

        log.error("=========================================");

        B b1 = new B("DiSi", 27);
        B b2 = new B("FiSa", 25);
        List<B> bs = new ArrayList<>();
        bs.add(b1);
        bs.add(b2);
        log.info("原来 bs 的集合 顺序 :{}", bs);
        // 默认升序
        bs.stream().sorted(Comparator.comparing(B::getAge)).collect(Collectors.toList());
        // jdk 1.8后 推荐使用更简单的方式来表达 lambda
        Collections.sort(bs, new Comparator<B>() {
            @Override
            public int compare(B o1, B o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        log.info("经过 sort 排序后的 bs 的集合 顺序 :{}", bs);
    }

}
