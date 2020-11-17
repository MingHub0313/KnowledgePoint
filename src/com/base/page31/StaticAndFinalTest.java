package com.base.page31;

import org.junit.Test;

/**
 * @Name StaticAndFinalTest
 * @Author 18057
 * @Createed 11:06 2020/10/30
 * @Description static 和 final 的区别
 * @Version 1.0.0
 */
public class StaticAndFinalTest {

    /**
     * static:
     *  修饰变量:静态变量随着类加载时被完成初始化,内存中只有一个 且JVM也只会为它分配一次内存,所有类共享静态变量;
     *  修饰方法:在类加载的时候就存在,不依赖任何实例;static方法必须实现,不能用 abstract 修饰;
     *  修饰代码块:在类加载完成之后就会执行代码块中的内容;
     *  父类静态代码块 > 子类静态代码块 > 父类非静态代码块 > 父类构造方法 > 子类非静态代码块 > 子类构造方法.
     *
     *  静态成员变量==>静态代码块==>成员变量==>构造代码块==>构造方法  (成员变量和构造代码块谁在前面谁先执行)
     *
     * final:
     *  修饰变量:
     *          编译期常量:类加载的过程完成初始化,编译后带入到任何计算式中,只能是基本类型
     *          运行时常量:基本数据类型或者引用数据类型,引用不可变,但引用的对象内容可变
     *  修饰方法:不能被重写 不能被子类修改;
     *  修饰类:不能被继承;
     *  修饰参数:final形参不可变.
     *
     *  static修饰的属性强调它们只有一个  final修饰的属性表面是一个常数(创建后不能被修改)
     *  static final 修饰的属性表示一旦给值 就不可修改,并且可以通过类名访问.
     *  static final 修饰方法表示方法不能重写 可以在不 new 对象的情况下调用.
     *
     *  final的好处:
     *              1).final 关键字提高了行能, Jvm 和 Java 应用都会缓存 final 变量;
     *              2).final变量可以安全的在多线程环境下进行共享,而不需要额外的同步开销;
     *              3).使用 final 关键字 Jvm会对方法、变量以及类进行优化.
     */

    @Test
    public void finalTest(){

        // 1.final 修饰的属性 可以在编译期进行初始化 也可以在运行期初始化.但是一旦初始化后就不能被改变
        final Integer age;
        age = 23;
        //age = 34;
        final String name = "张三";
        //name = "李四";

        System.out.println("姓名:"+name+"年龄:"+age);

        // 2.final 修饰的属性跟具体对象有关 在运行期初始化的final属性 不同的对象可以有不同的值.

        // 3.final修饰方法时 该方法在子类中不能被重写

        // 4.final 修饰类时 该类不能被继承.

        /**
         * 对于基本类型 final会将值变为一个常数(创建后不能被修改);但是对于对象句柄(引用或指针) final会将句柄变为一个常数
         * 进行声明时,必须将句柄初始化到一个具体的对象.而且不能再将句柄指向另一个对象.
         */

    }

    @Test
    public void staticTest(){
        // 1.static修饰的属性时 初始化在编译期(类加载的时候) 初始化后能改变
        // 2.static修饰的属性所有对象都只要一个值【强调只有一个】
        // 3.static修饰的属性、方法、代码块跟该类的具体对象无关,不创建对象也能调用static修饰的属性、方法等
        // 4.static和"this、super"势不两立 static跟具体对象无关 而this、super正好跟具体对象有关
        // 5.static不可以修饰局部变量

        Person.funStatic();
        System.out.println("****************");
        Person p1 = new Person("p1初始化");

        /**
         * static成员book2成员变量初始化
         * static成员book4成员变量初始化
         * static修饰的funStatic方法
         * ****************
         * book1成员变量初始化
         * book3成员变量初始化
         * p1初始化
         *
         * 说明:
         * 1.当我们没有创建对象 而是通过类去调用类方法时,尽管该方法没有使用到任何的类成员,类成员还是在方法调用之前就初始化了
         * --->结论:第一次使用一个类时 就会触发该类的(static)成员初始化
         * 2.当我们使用了类的方法,完成类的成员的初始化后 再 new 该类的对象时 static修饰的类成员没有再次初始化
         * --->结论: static 修饰的类成员,在程序运行过程中 只需要初始化一次即可.
         */

        //========================用途=========================
        /**
         * 1.用來修饰成员变量 将其变为类的成员  从而实现所有对象对于该成员的共享
         * 2.用来修饰方法 将其变为类的方法 可以直接使用 类名.方法名的方式调用 --常用于工具类
         * 3.静态代码块 将多个类成员放在一起初始化 使得程序更加规整
         * 4.静态导包用法 将类的方法直接导入到当前类中 从而直接使用 方法名 即可调用类方法
         */
    }


    /**
     * Question 1.静态变量和实例变量的区别?
     *
     * 在语法定义上: 静态变量前要加 static 关键字 而实例变量前不加
     * 在程序运行时的区别:
     *              实例变量属于某个对象的属性 必须创建了实例对象 其中的实例变量才会被分配空间 才能使用这个实例变量
     *              静态变量不属于实例对象 而是属于类 所以也称为类对象 只要程序加载了类的字节码文件 不用创建任何实例
     *              静态变量就会被分配空间 静态变量就可以被使用.
     *   总结: 【实例变量必须创建对象后才可以通过这个对象来使用,静态变量则可以直接使用类名来引用】
     */

    /**
     * Question 2.是否可以从一个 static 方法内部发出对 非static 方法的调用?
     * 不可以 .因为非static方法要与对象关联在一起 必须创建一个对象后 才可以在该对象上进行方法调用
     * 而static方法调用时不需要创建对象 可以直接调用.
     * 【一个static方法被调用时 可能还没有创建任何实例 所以一个 static 方法内部不可以发出对非 static 方法的调用】
     */

}
