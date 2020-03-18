package com.xdclass.jichu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author Obsession.yin
 * @date 2020/3/7
 * 拷贝 文件
 * JDK 1.7 之后 资源实现了 AutoCloseable  就可可自动关闭
 * 在 try（）中定义资源，可以多个
 */
public class StreamFile {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        try(
                FileInputStream fin =  new FileInputStream("C:\\Users\\dell\\Desktop\\test.txt");
                BufferedInputStream bufi = new BufferedInputStream(fin);
                FileOutputStream fou = new FileOutputStream("C:\\Users\\dell\\Desktop\\copy.txt");
                BufferedOutputStream bufo = new BufferedOutputStream(fou);
                ) {
        int size;
        byte[] by = new byte[1024];
        while((size = bufi.read(by)) != -1){
                bufo.write(by,0,size);
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
