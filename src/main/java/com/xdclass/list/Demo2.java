package com.xdclass.list;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Obsession.yin
 * @date 2020/3/9
 */
public class Demo2 {

    public static void main(String[] args) {

        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("abc");
        list.add("123");
        list.add("456");
        list.add("789");
        list.add("000");
        list.add("111");
        System.out.println(list.size);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
