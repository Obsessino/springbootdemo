package com.xdclass.jichu;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Obsession.yin
 * @date 2020/3/7
 *
 * 找出某⽬录下的所有⼦⽬录以及⼦⽂件并打印到控制台上
 */
public class DiguiPrintFile {

    public static void main(String[] args) {

        List<String> paths = new ArrayList<>();
        getAllFilePath(new File("E:\\demo"),paths);
        for (String path : paths){
            System.out.println(path);
        }
    }

    private static void getAllFilePath(File filePath, List<String> paths) {
        File[] files = filePath.listFiles();
        for(File file : files){
            if(file.isDirectory()){
                paths.add(file.getPath());
                getAllFilePath(file,  paths);
            }else {
                paths.add(file.getPath());
            }
        }
    }
}