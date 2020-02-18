package com.goalabs.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MyCopyMap {
    public static <Integer,String> LinkedHashMap<Integer,String> myCopy1(LinkedHashMap<Integer,String> tmpMap) {

        // tmpMap.forEach( (k,v) -> System.out.println(k.toString() + "--" +v));
        return (LinkedHashMap<Integer,String>) tmpMap.clone();
    }


    public static <Integer, String> LinkedHashMap<Integer, String> copyUsingPutAll(LinkedHashMap<Integer,String> tmpMap) {
        LinkedHashMap<Integer,String> shallowCopy = new LinkedHashMap<Integer,String>();
        shallowCopy.putAll(tmpMap);
        return shallowCopy;
    }
    

    public static void traverseMap(HashMap<Integer,String> tmpMap){

        tmpMap.forEach((k,v) -> System.out.println(k.toString() + "~~" + v ));
    }


    public static void main(String[] args) {
        
        LinkedHashMap<Integer,String> myHashMap = new LinkedHashMap<Integer,String>();
        for(Integer i=0; i<10;i ++){
            myHashMap.put(i, "Hello_"+i.toString());
        }
        LinkedHashMap<Integer,String> tmp2 = MyCopyMap.myCopy1(myHashMap);
        myHashMap.put(12, "HelloDoctor");
        // MyCopyMap.traverseMap(tmp2);

        LinkedHashMap<Integer,String> tmp3 = MyCopyMap.copyUsingPutAll(myHashMap);
        MyCopyMap.traverseMap(tmp3);


    }
}
