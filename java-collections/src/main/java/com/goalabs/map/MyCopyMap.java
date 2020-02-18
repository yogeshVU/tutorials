package com.goalabs.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map;

import edu.emory.mathcs.backport.java.util.TreeMap.Entry;

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
    

    public static <Integer,String> LinkedHashMap<Integer,String> copyUsingPut(LinkedHashMap<Integer,String> tmpMap){
        Set<Map.Entry<Integer,String>> myset = tmpMap.entrySet();
        LinkedHashMap<Integer,String> newTmpMap = new LinkedHashMap<Integer,String>();

        for (Map.Entry<Integer,String> tmpEntry: myset){
            newTmpMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return newTmpMap;
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

        tmp3.put(13, "value");    
        LinkedHashMap<Integer,String> tmp4 = MyCopyMap.copyUsingPut(tmp3);
        MyCopyMap.traverseMap(tmp4);

    }
}
