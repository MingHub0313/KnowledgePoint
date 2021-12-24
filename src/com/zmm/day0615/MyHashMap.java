package com.zmm.day0615;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Name MyHashMap
 * @Author 900045
 * @Created by 2020/6/15 0015
 */
public class MyHashMap<K, V> implements MyMap<K, V> {


	/**
	 * HashMap 类中有以下主要成员变量：
	 * ● 	transient int size;
	 * 		○记录 Map 中 K-V(键值对)对的个数
	 * ●	loadFactor
	 * 		○ 装载因子 用来衡量 HashMap 满的程度。loadFactor 的默认值为 0.75f
	 * 			(static final float DEFAULT_LOAD_FACTOR = 0.75f;)
	 * ● 	int threshold;
	 * 		○ 临界值 当实际 KV 个数超过 threshold 时 HashMap 会将容量扩容 threshold ＝ 容量 * 加载因子
	 * 			(static final int TREE_THRESHOLD = 8;)
	 * ●	capacity;
	 * 		○ 容量 如果不指定 默认容量是 16
	 * 			(static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;)
	 *
	 * 	CASE1:	HashMap 中的size 和 capacity 之间的区别:
	 * 		HashMap就像是一个 "桶",那么 capacity 就是这个 "桶" ,当前最多可以装多少元素,而 size 表示这个桶已经装了多少元素.
	 *
	 * 	如果开发者通过构造函数之指定一个数字作为容量,那么Hash会选择大于该数字的第一个 2的幂 作为容量.
	 * 		(1 -> 1、7 -> 8、9 -> 16)
	 *
	 * 	CASE2:	loadFactor 和 threshold:
	 * 		HashMap有扩容机制,就是当达到扩容条件时会进行扩容,从16扩容到32、64、128...
	 * 		当 HashMap 中的元素个数(size)超过临界值(threshold)时就会自动扩容.
	 * 			threshold = loadFactor * capacity.
	 *
	 * 		loadFactor 是装载因子,表示 HashMap 满的程度,默认值为 0.75f
	 * 		设置成 0.75有一个好处,那就是0.75 正好是 3/4 ,而 capacity 又是 2的幂.所以 两个数的乘积都是整数.
	 *
	 * 	CASE3:	为什么要设置 HashMap 的初始化容量
	 * 		如果没有设置初始容量大小,随着元素的不断增加,HashMap 会发生多次扩容,而 HashMap 中的扩容机制决定了每次扩容
	 * 		都需要重建hash表,是非常影响性能的.
	 *
	 * 	CASE4:	HashMap 中容量的初始化
	 * 		默认情况下,当我们设置 HashMap 的初始化容量时,实际上 HashMap 会采用第一个大于该数值的 2的幂 作为初始化容量.
	 * 		当我们通过 HashMap(int initialCapacity) 设置初始化容量的时候, HashMap 也不一定会直接采用我们传入的数值,而是经过计算
	 * 		得到一个新值,目的是提高 hash 的效率 (1 -> 1、7 -> 8、9 -> 16).
	 * 		【在 JDK1.7和 JDK1.8中,HashMap初始化这个容量的时机不同】:
	 * 			JDK1.8: 在调用 HashMap 的构造函数定义 HashMap 的时候,就会进行容量的设定
	 * 			JDK1.7:	要等到第一次 put 操作时才进行这一操作.
	 * 		但不论是什么版本 在计算初始化容量的算法如出一辙,主要:
	 * 		int n = cap - 1;
	 * 		n |= n >>> 1;   // 先进行右移一位(即减一),然后再 或 运算 [运算规则：0|0=0;  0|1=1;  1|0=1;  1|1=1;]
	 *
	 * 		例: 5->8、9->16、19->32、37->64
	 *
	 * 		5	0000	0000	0000	0101
	 * 		7	0000	0000	0000	0111		Step 1，5->7
	 * 		8	0000	0000	0000	1000		Step 2，7->8
	 *
	 * 		9	0000	0000	0000	1001
	 * 		15	0000	0000	0000	1111		Step 1，9->15
	 * 		16	0000	0000	0001	0000		Step 2，15->16
	 *
	 * 		19	0000	0000	0001	0011
	 * 		31	0000	0000	0001	1111		Step 1，19->31
	 * 		32	0000	0000	0010	0000		Step 2，31->32
	 *
	 * 		37	0000	0000	0010	0101
	 * 		63	0000	0000	0011	1111		Step 1，37->63
	 * 		64	0000	0000	0100	0000		Step 2，63->64
	 *
	 * 		特殊情况不能套用该公式:该数本身就是 2 的幂自身.【为了让所有的数都满足公式,将参数先减 一 然后再套用公式】
	 * 		对应 Step 1的代码实现:
	 * 			n |= n >>> 1;
	 * 			n |= n >>> 2;
	 * 			n |= n >>> 4;
	 * 			n |= n >>> 8;
	 * 			n |= n >>> 16;
	 * 			说明:对一个二进制数依次向右移位,然后与原值取或.【其目的对于一个数字的二进制,从第一个不为0的位开始,把后面的所有位都设置成1】
	 * 		对应 Step 2的代码实现:
	 * 			return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	 * 			说明:极限值判断,然后把 Step1 得到的数值 + 1.
	 *
	 *
	 * 		十进制    0		  1		  2		  3		  4		  5		  6		  7		  8		  9
	 * 		二进制	0000	0001	0010	0011	0100	0101	0110	0111	1000	1001
	 *
	 * 	CASE5:	HashMap初始化容量设置多少合适
	 * 		根据《阿里巴巴开发手册》中推荐 使用 HashMap(int initialCapacity) 初始化.
	 * 		那么到底初始化的时候,要指定多少合适呢?
	 * 		1).塞多少个元素就设置成多少的容量.	比如准备塞 7 个元素 ,那就 new HashMap(7).
	 * 			但是阅读源码就会知道我们传入的参数不一定就是 HashMap的容量,因为代码中还会重新计算出最符合的数值.
	 *
	 * 		2).	JDK会默认帮我们计算一个相对合理的值当作初始容量(合理值:找到第一个比用户传入的值大的2的幂)
	 * 			此时我们还需要注意一个参数 loadFactor(负载因子),当 HashMap 的元素个数(size)超过	threshold = loadFactor * capacity;
	 * 			也就是说,如果我们设置的默认值是7,经过 JDK处理之后, HashMap 的容量会被设置成 8 ,但是,
	 * 			这个 HashMap 在元素达到 8 * 0.75 = 6 的时候就会进行一次扩容,这明显是我们不希望见到的.
	 *
	 * 		参考 JDK8 中的 putAll 方法中实现的算法:
	 * 			(int) ((float) expectedSize / loadFactor + 1.0F);
	 * 			比如我们计划向 HashMap 中放入 7 个元素的时候,我们通过算法得到 7 / 0.075 + 1 = 10,
	 * 			10 经过JDK处理之后,会被设置成 16 ,这就大大的减少了扩容的几率.
	 *
	 * 		当 HashMap 内部维护的哈希表的容量达到 75%时(默认情况下),会触发 rehash,而 rehash的过程是比较耗费时间的.
	 * 		使用这个公式可以有效的减少冲突也可以减小误差.
	 *
	 */


	static final int MAXIMUM_CAPACITY = 1 << 30;

	public static void main(String[] args) {

		HashMap<String, String> hashMap = Maps.newHashMapWithExpectedSize(2);
		//特殊情况 这些数本身就是 2 的幂自身 套用公式就会出现错误. --->先将传参减一
		int n = 9-1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		//【其目的对于一个数字的二进制,从第一个不为0的位开始,把后面的所有位都设置成1】
		int m = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    	System.out.println(m);
	}

	/**
	 * 根据Hash 算法实现,理论上只需要一次查询即可定位到指定数据 (Hash 冲突)
	 * 1.需要 存储数据的 Entry 对象
	 * 2.定义 Entry  类型的数组 默认长度为 16
	 * 3.put 也有可能是修改
	 * 4.扩容 性能是很低下的
	 * 总结 :
	 */

    /**
     * 第二步  用于存放 Entry 数据   --->为什么直接定义好16的长度? 可以先不定义好 ,在进行插入值/或者初始化时定义
     */
    private Entry<K, V>[] table = null;
    /**
     * 记录HashMap 的元素个数
     */
    private int size;

    /**
     * HashMap 集合中数组的默认长度 2^4 位移算法
     */
    private static int defaultLength = 1 << 4;

    /**
     * 默认加载因子 0.75  ----我们存放元素的个数(size) 是我们数组长度的0.75的时候 数组需要扩容
     */
    private static double defaultLoad = 0.75;

    /**
     * 选择合适的长度 不能过大 占内存
     *
     * @param defaultLength
     */
    public MyHashMap(int defaultLength) {
        super();
    }

    @Override
    public V put(K k, V v) {
        // 要将数据插入 HashMap 集合中   思考 --->如何存储数据结构
        //16位数组 存放链表(严格说存放链表的头结点)  数组+链表的结构
        if (table == null) {
            table = new Entry[defaultLength];
        }

        if (size >= defaultLength * defaultLoad) {
            // 重新散列
            resize();
        }

        //1.分院 --- 确定 Key/Value 存放的数组的下标位置 --> Hash计算  & 或者 模

        int index = getIndex(k, defaultLength);

        //判断是否是修改?
        //根据下标获取 entry 对象
        MyMap.Entry<K, V> entry = table[index];
        //判断key 是否存在 如果存在 则是修改 , 不存在 则是新增
        while (entry != null) {
            if (entry.getKey().equals(k)) {
                // 修改 value
                return entry.setValue(v);
            } else {
                //如果不是则判断链表的下一个元素
                entry = entry.getNext();
            }
        }


        //2.创建 Entry 元素,并存放在 table的index 下标上  next 是什么? 以前的值 (所以在链表头结点出的值一定是最后进来的值) 即原本的值
        table[index] = new Entry<>(k, v, table[index]);
        this.size++;

        return v;
    }

    private void resize() {

        // 重新散列
        if (size >= defaultLength * defaultLoad) {
            System.out.println("-----------------扩容开始----------------");
            // 定义新的 table 用于临时存储扩容的 Entry 对象
            Entry<K, V>[] newTable = new Entry[defaultLength << 1];
            // 定义一个临时变量 用于存储每一个下标的 Entry 对象
            MyMap.Entry<K, V> entry = null;
            // 遍历 old 的 table
            for (int i = 0; i < table.length; i++) {
                // 存储每一个 Entry 对象
                entry = table[i];
                // while 中的 五行代码每一行都是精髓
                while (entry != null) {
                    //拿到节点重新散列 (拿到 entry 的 key ,以及临时 table的长度 计算新的下标)
                    int index = getIndex(entry.getKey(), newTable.length);

                    // 记住 entry 并不是简单的 key value 还有一个 next 指针 需要处理 next (需要改掉)
                    // 中间变量  相当于将 a  b 的值 互换 即  c = a ,a = b , b = c ;
                    MyMap.Entry<K, V> oldEntry = entry.getNext();
                    // 最重要的一步
                    entry.setNext(newTable[index]);

                    // a = b
                    newTable[index] = (Entry<K, V>) entry;

                    //继续下一个节点 b = c
                    entry = oldEntry;
                }
            }
            table = newTable;
            defaultLength = newTable.length;
        }
    }

    /**
     * 计算 下标
     * HashCode 是根据对象的地址或者字符串的值,计算出来的int 类型的数值
     * 特点:
     * 1.同一对象多次调用hashCode()方法,必须返回相同的数值   [储存哪个位置  在哪个位置获取] 即调用多次
     * 2.如果两个对象根据 equals() 方法比较是相等的,那么两个对象调用hashCode()方法返回的结果必须相等
     * 3.如果两个对象根据equals() 方法比较是不相等的,那么两个对象调用hashCode()方法返回的结果不一定不相等
     *
     * @param k
     * @return
     */
    private int getIndex(K k, int length) {
        // HashMap 是允许 null 值 和 null key
        if (k == null) {
            return 0;
        }
        // 计算的 hashCode码值 过大  如何处理
        // 常用 : &(与)算法---与后的值一定不会大于这两个数的最小值 [0,最小值]      模算法----取模后得到的值一定是比这个模小 [0,取模数)
        // 00000100  4      00000111	7
        // 00000010  2		00000010	2
        // 00000000  0		00000010	2
        int hash = k.hashCode();
        return hash & (length - 1);
    }

    @Override
    public V get(K k) {
        if (table != null) {
            // 获取下标 但这个下标可能代表好多值
            int index = getIndex(k, defaultLength);
            MyMap.Entry<K, V> entry = table[index];
            while (entry != null) {
                //计算的 index 并不代表就是 要查询 key 所对应的值 因此还需要判断 key
                //如果 该对象中的 key 与 所需要查询的 key 一直 则直接返回 该对象中的 value 值
                if (entry.getKey() != null && entry.getKey().equals(k)) {
                    return entry.getValue();
                } else {
                    // 如果不等 获取该 entry 下一个 entry 对象 进行循环判断 ,当有相等时即 return 返回
                    entry = entry.getNext();
                }
            }
        }
        return null;
    }

    @Override
    public void clear() {
        Entry<K, V>[] tab;
        if ((tab = table) != null && size > 0) {
            size = 0;
            for (int i = 0; i < tab.length; ++i) {
                tab[i] = null;
            }
        }
    }

    @Override
    public boolean containsValue(V value) {
        // 判断 该 值 是否存在  将 table 赋值
        Entry<K, V>[] tab = table;
        // 判断 tab 是否为空 和 大小是否大于0
        if (tab != null && size > 0) {
            // 遍历 tab
            for (MyMap.Entry<K, V> e : tab) {
                // 遍历其 Entry 链表中的所有元素 getNext()
                for (; e != null; e = e.getNext()) {
                    V v = e.getValue();
                    if (v == value) {
                        return true;
                    } else if (value != null && value.equals(v)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsKey(K key) {
        // 1.计算该key 对应的 hashCode
        int index = getIndex(key, defaultLength);
        return getEntry(index, key);
    }


    private boolean getEntry(int hash, K key) {
        Entry<K, V>[] tab = table;
        if (tab != null) {
            MyMap.Entry<K, V> entry = table[hash];
            while (entry != null) {
                if (entry.getKey() != null && entry.getKey().equals(key)) {
                    return true;
                } else {
                    entry = entry.getNext();
                }
                if (entry == key) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        Entry<K, V>[] tab = table;
        return (tab == null) ? true : false;
    }

    @Override
    public int size() {
        return this.size;
    }


    /**
     * 第一步
     *
     * @param <K>
     * @param <V>
     */
    static class Entry<K, V> implements MyMap.Entry<K, V> {

        K key;
        V value;
        MyMap.Entry<K, V> next;

        /**
         * 拿到存放的位置后 , 只需要将 key / value 存放进来
         * 首先得先有一个 key / value  ---> 创建一个 key/value 对象 来 存储
         * 对象如何去创建 我们有一个 Entry ,通过 Entry 的构造方法 来创建
         *
         * @param key
         * @param value
         * @param next
         */
        public Entry(K key, V value, MyMap.Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public final K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public final String toString() {
            return key + "=" + value;
        }

        @Override
        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof MyMap.Entry) {
                MyMap.Entry<?, ?> e = (MyMap.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public MyMap.Entry<K, V> getNext() {
            return this.next;
        }

        @Override
        public MyMap.Entry<K, V> setNext(MyMap.Entry<K, V> next) {
            MyMap.Entry<K, V> oldNext = next;
            this.next = next;
            return oldNext;
        }
    }

}
