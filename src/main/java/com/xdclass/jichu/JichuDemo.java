package com.xdclass.jichu;

/**
 * @author Obsession.yin
 * @date 2020/3/7
 * 两个不为0的数交换值
 */
public class JichuDemo {

    public static void main(String[] args) {

        swap2(5,10);
    }

    private static void swap(int a, int b) {
        System.out.printf("a=%d, b=%d",a,b);
        //a = 5 + 10 = 15
        a = a + b;
        //b = 15 - 10 = 5
        b = a - b;
        //a = 15 - 5 = 10
        a = a - b;
        System.out.printf("\na=%d, b=%d",a,b);
    }

    private static void swap2(int a, int b) {

        System.out.printf("a=%d, b=%d",a,b);
        // a1 = a^b
        a = a^b;
        // b = b^a^b
        b = b^a;
        // a = a1^b = a^b^a
        a = a^b;
        System.out.printf("\na=%d, b=%d",a,b);
    }
}
