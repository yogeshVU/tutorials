package com.goalabs.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayInversion {

    public static int[] happyPath(){
        int array[] = new int[] {1,2,3,4,5,6};

        for(int i=0;i<array.length/2;i++){
            Object tmp = array[i];
            array[i] = array[(array.length-1)-i];
            array[(array.length-1)-i] = (int) tmp;
        }

        for(int i : array){
            System.out.println(i);
        }
        return array;
    }

    public static Integer[] usingCollections(Integer[] array) {
        Collections.reverse(Arrays.asList(array));
        return array;
    }

    public static void main(String[] args){
//        int array[] = ArrayInversion.happyPath();

        Integer[] array = {1,2,3,4,5,6};
//        String[] fruits = { "apples", "tomatoes", "bananas", "guavas", "pineapples", "oranges" };
        Integer[] inverseArray= ArrayInversion.usingCollections(array);
        for (Object a: inverseArray){
            System.out.println(a.toString());
        }

    }
}
