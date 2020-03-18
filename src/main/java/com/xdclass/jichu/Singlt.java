package com.xdclass.jichu;

/**
 * @author Obsession.yin
 * @date 2020/3/13
 *
 * 单例
 */
public class Singlt {

    private static volatile  Singlt singlt = null;

    private Singlt(){

    }

    public static Singlt getInstance(){
        if (singlt == null){
            synchronized (Singlt.class){
                if(singlt == null){
                    singlt = new Singlt();
                }
            }
        }
        return  singlt;
    }
}
