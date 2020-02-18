package com.goalabs.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyLinkedHashMap1 {
    public static void getValue1(LinkedHashMap<Integer,String> tmpMap){

        for(Map.Entry<Integer,String> m: tmpMap.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

    }

    public static void getValues2(LinkedHashMap<Integer,String> tmpMap){
        System.out.println(tmpMap.keySet());
        System.out.println(tmpMap.values());

    }

    public static void main(String[] args){
        LinkedHashMap<Integer,String> hm=new LinkedHashMap<Integer,String>();

        hm.put(100,"Amit");
        hm.put(101,"Vijay");
        hm.put(102,"Rahul");

        MyLinkedHashMap1.getValue1(hm);
        MyLinkedHashMap1.getValues2(hm);

    }
}
