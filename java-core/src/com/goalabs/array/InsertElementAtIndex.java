package com.goalabs.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertElementAtIndex {

    public static Integer[] insertElement(Integer[] tmpArray, int index,int newElement) {
        Integer[] newArray = new Integer[tmpArray.length+1];
        List<Integer> newList = new ArrayList<>(Arrays.asList(tmpArray));
        newList.add(index, newElement);
        return newList.toArray(newArray);
    }

    public static void main(String[] args){
        Integer[] test = new Integer[]{1,2,3,4,5};
        Integer[] newTest = InsertElementAtIndex.insertElement(test,1,100);

        for(Integer a : newTest){
            System.out.println(a);
        }

    }


}
