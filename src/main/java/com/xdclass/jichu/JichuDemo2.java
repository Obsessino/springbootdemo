package com.xdclass.jichu;

/**
 * @author Obsession.yin
 * @date 2020/3/7
 * try  catch  finally
 */
public class JichuDemo2 {

    public static void main(String[] args) {
        test1();
        test2();
    }
    public static int test1() {
        int a = 1;
        try {
            System.out.println(a / 0);
            a = 2;
        } catch (ArithmeticException e) {
            a = 3;
            return a;
        } finally {
            a = 4;
        }
        return a;
    }
    public static int test2() {
        int a = 1;
        try {
            System.out.println(a / 0);

            a = 2;
        } catch (ArithmeticException e) {
            a = 3;
            return a;
        } finally {
            a = 4;
            return a;
        }
    }
}
