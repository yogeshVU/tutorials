package com.goalabs.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyMap1 {

//     This uses entryset method for traversing
    public static void getValue1(  Map<Integer,String>  tmpMap){
        for( Map.Entry m : tmpMap.entrySet() ){
            System.out.println(m.getKey()+" -- "+m.getValue());
        }
    }

    // This uses the stream....
    public static void getValue2(Map <Integer, String> tmpMap){
        tmpMap.entrySet()
                //Returns a sequential Stream with this collection as its source
                .stream()
                //Sorted according to the provided Comparator
                .sorted(Map.Entry.comparingByKey())
                //Performs an action for each element of this stream
                .forEach(System.out::println);
    }

    // This uses the iterator function...
    public static void getValue3(Map<Integer,String> tmpMap){


        Set myset = tmpMap.entrySet();
        Iterator itr = myset.iterator();

        while (itr.hasNext()){
            Map.Entry tmp = (Map.Entry)itr.next();
            System.out.println(tmp.getKey()+ " *** " + tmp.getValue());
        }
    }

    // This uses the lambda method...
    public static void getValue4(Map<Integer,String> tmpMap){
        tmpMap.forEach( (k,v) -> System.out.println(k+ "^^^" + v));
    }

    public static void main(String[] args){
        Map<Integer,String> mymap = new HashMap<>();
        mymap.put(1,"a");
        mymap.put(2,"b");
        mymap.put(3,"c");
        mymap.put(4,"d");

        MyMap1.getValue1(mymap);
        MyMap1.getValue2(mymap);
        MyMap1.getValue3(mymap);
        MyMap1.getValue4(mymap);

    }

}
