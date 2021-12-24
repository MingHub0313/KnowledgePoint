package com.zmm.day0615;

/**
 * @Name MyMap
 * @Author 900045
 * @Created by 2020/6/15 0015
 */
public interface MyMap<K, V> {

    /**
     * 向集合中插入值
     *
     * @param k
     * @param v
     * @return
     */
    V put(K k, V v);

    /**
     * 根据Key 获取集合中的值
     *
     * @param k
     * @return
     */
    V get(K k);

    /**
     * 获取集合中元素个数
     *
     * @return
     */
    int size();

    /**
     * 清空
     */
    void clear();


    /**
     * 判断是否存在 某值
     *
     * @param value
     * @return
     */
    boolean containsValue(V value);


    /**
     * 判断是否存在 某键
     *
     * @param key
     * @return
     */
    boolean containsKey(K key);


    /**
     * 判断是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 用于获取集合中,键值对的对象
     *
     * @param <K>
     * @param <V>
     */
    interface Entry<K, V> {
        /**
         * 获取 Key
         *
         * @return
         */
        K getKey();

        /**
         * 获取 Value
         *
         * @return
         */
        V getValue();

        /**
         * 设置 Value
         *
         * @param value
         * @return
         */
        V setValue(V value);

        /**
         * 获取 next
         *
         * @return
         */
        Entry<K, V> getNext();

        /**
         * 设置 next
         *
         * @param next
         * @return
         */
        Entry<K, V> setNext(Entry<K, V> next);
    }


}
