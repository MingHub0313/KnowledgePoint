package com.base.page30;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @Name ReflectTest
 * @Author 18057
 * @Createed 9:53 2020/10/29
 * @Description Java 反射
 * @Version 1.0.0
 */
public class ReflectTest {

    /**
     * Question 1.什么是反射?
     * 是一种间接操作目标对象的机制.
     * 【核心是 JVM 在运行的时候才动态加载类】 并且对于任意一个类,都能够知道这个类的所有属性和方法 调用方法/访问属性.
     * 不需要提前在编译期知道运行的对象是谁,它允许运行中的Java程序获取类的信息,并且可以操作类的对象内部属性.
     *
     * 程序中对象的类型一般都是在编译期就确定下来的,而当我们的程序在运行时,可能需要动态的加载一些类,这些类因为之前没有用不到
     * 所以Jvm 还不会去加载,这时 使用 Java反射机制可以在运行期动态的创建对象并调用其属性.它是在运行时根据需要才加载.
     */

    /**
     * 反射机制 -- 在运行的时候 对于任意一个类,都能够知道这个类的所有属性和方法;对于一个对象,都可以调用它的任意一个方法和属性
     * 这种动态的获取信息以及动态调用对象的方法的功能被称为 Java 语言的反射机制.
     */

    /**
     * Question 2.获取 Class 对象的方法有哪几种?
     * <p>
     * Class.getClass()
     * <p>
     * ClassLoader.loadClass()
     * <p>
     * Class.forName()
     * <p>
     * 三种方式中 常用第三种
     * 第一种对象都有了还要反射干什么
     * 第二种需要导入类包 依赖太强 不导包就抛编译错误
     * 一般都使用第三种 一个字符串可以传入也可以写在配置文件中等多种方法
     * <p>
     * 注意:在运行期间 一个类,只有一个Class对象产生所以三种方式获取的class对象比较都是 true
     * <p>
     * Class.forName() 与 ClassLoader.loadClass() 比较
     * 初始化不同:
     * 1.Class.forName()会对类初始化,而 loadClass() 只会装载活链接
     * 2.forName()在类加载的时候就执行静态代码块(即初始化);loadClass 只有再调用 newInstance 方法的时候才会执行静态代码块.
     * <p>
     * 类加载器不同:
     * 1.Class.forName(String) 方法只有一个参数,使用调用者的类加载器来加载【用加载了调用forName()方法的代码的那个类加载器】
     * 2.ClassLoader.loadClass() 方法是一个实例方法(非静态方法),调用时需要自己指定类加载器.
     * <p>
     * <p>
     * 要想解剖一个类,必须先要获取到该类的字节码文件对象(class).
     * 而解剖使用的就是Class类中的方法.所以先要获取到每一个字节码文件对应的Class类型的对象.
     */

    @Test
    public void fanShe() {
        /**
         * 第一种方式获取 Class 对象  getClass()
         */
        Student student = new Student();
        //这一 new 产生一个 Student 对象 一个 Class对象.
        Class<? extends Student> aClass = student.getClass();
        //获取 Class 对象
        System.out.println("Name:" + aClass.getName());
        System.out.println("Methods:" + aClass.getMethods());

        /**
         * 第二种方式获取 Class 对象  .class
         */

        Class stuClass2 = Student.class;
        Student student2 = new Student();
        Class<? extends Student> aClass1 = student2.getClass();

        //判断第一种方式获取的Class对象和第二种方式获取的是否是同一个
        System.out.println(stuClass2 == aClass);
        System.out.println(stuClass2 == aClass1);

        /**
         * 第三种方式获取 Class 对象  Class.forName
         */

        try {
            //注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            Class stuClass3 = Class.forName("com.base.page30.Student");
            //判断三种方式是否获取的是同一个Class对象
            System.out.println(stuClass3 == stuClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Question 3.关于class对象和这个class类
     * <p>
     * Class对象的由来是将class文件读入内存,并为之创建一个Class对象
     * 1.当我们 new 一个对象时 jvm 会加载我们的.class
     * 2.jvm 会去我们本地磁盘找.class文件并加载到 jvm 内存中
     * 3.读入内存的过程中 同时 jvm会自动创建一个class对象这个必须有且自动创建,一个类只产生一个class对象.
     * 以后不管是 new 多少个 对象 与第一次产生的 class 对象是同一个.绝不会产生第二个.
     * 反射的本质理解: 【就是得到class对象后,反向获取对象的各种信息】
     * <p>
     * class类 -- 代表一个类,是Java 反射机制的起源和入口
     * 用于获取与类相关的各种信息,提供了获取类信息的相关方法
     * Class类继承Object类
     * Class类是所有类的共同图纸
     * 每个类有自己的对象,同时每个类也看做是一个对象,有共同的图纸class存放类的结构信息,能够通过相应方法取出相应的信息
     * 如: 类的名字、属性、方法、构造方法、父类和接口.
     */

    @Test
    public void test() {
        try {
            Class<?> aClass = Class.forName("com.base.page30.A");
            System.out.println(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        try {
            Class<?> bClass = systemClassLoader.loadClass("com.base.page30.B");
            System.out.println(bClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Question 4.判断是否为某个类的实例
     *
     * 一般我们使用 instanceof  关键字来判断是否为某个实例.
     * 同时我们也可以借助反射中Class对象的 isInstance() 方法来判断是否是某一个实例 该方法是 native方法
     *
     */

    /**
     * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员
     * 1.获取构造方法：
     * 1).批量的方法:
     * public Constructor[] getConstructors()：所有"公有的"构造方法
     * public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)
     * 2).获取单个的方法并调用:
     * public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法
     * public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有
     * 3).调用构造方法:
     * Constructor-->newInstance(Object... initArgs)
     */

    @Test
    public void constructors() throws Exception {
        //1.加载Class对象
        Class clazz = Class.forName("com.base.page30.Student");

        //2.获取所有公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] conArray = clazz.getConstructors();
        for (Constructor c : conArray) {
            System.out.println(c);
        }

        /**
         * **********************所有公有构造方法*********************************
         * public com.base.page30.Student(java.lang.String,java.lang.Integer)
         * public com.base.page30.Student()
         * public com.base.page30.Student(char)
         */

        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        conArray = clazz.getDeclaredConstructors();
        for (Constructor c : conArray) {
            System.out.println(c);
        }

        /**
         * ************所有的构造方法(包括：私有、受保护、默认、公有)***************
         * private com.base.page30.Student(java.lang.Integer)
         * protected com.base.page30.Student(boolean)
         * public com.base.page30.Student(java.lang.String,java.lang.Integer)
         * com.base.page30.Student(java.lang.String)
         * public com.base.page30.Student()
         * public com.base.page30.Student(char)
         */

        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor con = clazz.getConstructor(null);
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。
        System.out.println("con = " + con);

        /**
         * *****************获取公有、无参的构造方法*******************************
         * con = public com.base.page30.Student()
         * 调用了公有、无参构造方法执行了。。。
         */

        //调用构造方法
        Object obj = con.newInstance();
        //	System.out.println("obj = " + obj);
        //	Student stu = (Student)obj;

        System.out.println("******************获取私有构造方法，并调用*******************************");
        con = clazz.getDeclaredConstructor(char.class);
        System.out.println(con);
        //调用构造方法
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
        obj = con.newInstance('男');
        System.out.println(obj);

        /**
         * ******************获取私有构造方法，并调用*******************************
         * public com.base.page30.Student(char)
         * 姓名：男
         * Student{name='null', age=null, sex= }
         */

    }


    /**
     * 获取成员变量并调用：
     * <p>
     * 1.批量的
     * 1).Field[] getFields():获取所有的"公有字段"
     * 2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
     * 2.获取单个的：
     * 1).public Field getField(String fieldName):获取某个"公有的"字段；
     * 2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
     * <p>
     * 设置字段的值：
     * Field --> public void set(Object obj,Object value):
     * 参数说明：
     * 1.obj:要设置的字段所在的对象；
     * 2.value:要为字段设置的值；
     */

    @Test
    public void fields() throws Exception {
        //1.获取Class对象
        Class stuClass = Class.forName("com.base.page30.Student2");
        //2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fieldArray = stuClass.getFields();
        for (Field f : fieldArray) {
            System.out.println(f);
        }
        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        fieldArray = stuClass.getDeclaredFields();
        for (Field f : fieldArray) {
            System.out.println(f);
        }
        System.out.println("*************获取公有字段**并调用***********************************");
        Field f = stuClass.getField("name");
        System.out.println(f);
        //获取一个对象
        Object obj = stuClass.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();
        //为字段设置值
        f.set(obj, "刘德华");//为Student对象中的name属性赋值--》stu.name = "刘德华"
        //验证
        Student2 stu = (Student2) obj;
        System.out.println("验证姓名：" + stu.name);


        System.out.println("**************获取私有字段****并调用********************************");
        f = stuClass.getDeclaredField("phoneNum");
        System.out.println(f);
        f.setAccessible(true);//暴力反射，解除私有限定
        f.set(obj, "18888889999");
        System.out.println("验证电话：" + stu);

    }

    /**
     * 获取成员方法并调用：
     * 1.批量的：
     * public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
     * public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
     * 2.获取单个的：
     * public Method getMethod(String name,Class<?>... parameterTypes):
     * 参数：
     * name : 方法名；
     * Class ... : 形参的Class类型对象
     * public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
     * 调用方法：
     * Method --> public Object invoke(Object obj,Object... args):
     * 参数说明：
     * obj : 要调用方法的对象；
     * args:调用方式时所传递的实参；
     * ):
     */
    @Test
    public void methodClass() throws Exception {
        //1.获取Class对象
        Class stuClass = Class.forName("com.base.page30.Student3");
        //2.获取所有公有方法
        System.out.println("**********获取所有的”公有“方法**************");
        stuClass.getMethods();
        Method[] methodArray = stuClass.getMethods();
        for (
                Method m : methodArray) {
            System.out.println(m);
        }
        System.out.println("*********获取所有的方法，包括私有的************");
        methodArray = stuClass.getDeclaredMethods();
        for (
                Method m : methodArray) {
            System.out.println(m);
        }
        System.out.println("************获取公有的show1()方法****************");
        Method m = stuClass.getMethod("show1", String.class);
        System.out.println(m);
        //实例化一个Student对象
        Object obj = stuClass.getConstructor().newInstance();
        m.invoke(obj, "刘德华");

        System.out.println("************获取私有的show4()方法**************");
        m = stuClass.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);//解除私有限定
        Object result = m.invoke(obj, 20);
        //需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);
    }


    @Test
    public void main() {
        try {
            //1、获取Student对象的字节码
            Class clazz = Class.forName("com.base.page30.Student4");

            //2、获取main方法
            //第一个参数：方法名称，第二个参数：方法形参的类型，
            Method methodMain = clazz.getMethod("main", String[].class);
            //3、调用main方法
            // methodMain.invoke(null, new String[]{"a","b","c"});
            //第一个参数 对象类型 因为方法是static静态的 所以为null可以 第二个参数是String数组
            // 这里要注意在jdk1.4时是数组 jdk1.5之后是可变参数
            //这里拆的时候将  new String[]{"a","b","c"} 拆成3个对象。。。所以需要将它强转
            methodMain.invoke(null, (Object)new String[]{"a","b","c"});
            //方式一
            // methodMain.invoke(null, new Object[]{new String[]{"a","b","c"}});
            // 方式二
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 利用发射创建数值
     */

    @Test
    public void testArrayIn() throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.lang.String");
        Object array = Array.newInstance(cls,25);
        //往数组里添加内容
        Array.set(array,0,"hello");
        Array.set(array,1,"Java");
        Array.set(array,2,"fuck");
        Array.set(array,3,"Scala");
        Array.set(array,4,"Clojure");
        //获取某一项的内容
        System.out.println(Array.get(array,3));

    }

    /**
     * 我们利用反射和配置文件 可以使: 应用程序更新时 对源码无需进行任何修改
     * 我们只需要将新类发送给客户端 并修改配置文件即可
     * @throws Exception
     */

    @Test
    public void readFile() throws Exception {
        //通过反射获取Class对象
        Class stuClass = Class.forName(getValue("className"));
        //2获取show()方法
        Method m = stuClass.getMethod(getValue("methodName"));
        //3.调用show()方法
        m.invoke(stuClass.getConstructor().newInstance());
    }

    //此方法接收一个key，在配置文件中获取相应的value
    public static String getValue(String key) throws IOException {
        //获取配置文件的对象
        Properties pro = new Properties();
        //获取输入流
        FileReader in = new FileReader("F:\\study_java\\KnowledgePoint\\resources\\pro.txt");
        //将流加载到配置文件对象中
        pro.load(in);
        in.close();
        //返回根据key获取的value值
        return pro.getProperty(key);
    }

    /**
     * 通过反射越过泛型检查
     * 例如 有一个String泛型的集合 怎样能向这个集合中添加一个Integer类型的值？
     * @throws Exception
     */

    @Test
    public void genericCity() throws Exception{
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");

        //	strList.add(100);
        //获取ArrayList的Class对象 反向的调用add()方法 添加数据
        Class listClass = strList.getClass();
        //得到 strList 对象的字节码 对象
        //获取add()方法
        Method m = listClass.getMethod("add", Object.class);
        //调用add()方法
        m.invoke(strList, 100);

        //遍历集合
        for(Object obj : strList){
            System.out.println(obj);
        }
    }



}
