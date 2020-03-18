package com.xdclass.list;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Obsession.yin
 * @date 2020/3/8
 */
public class Demo1 {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put(null,"hjfd");
        System.out.println(map.get(null));
    }
}
