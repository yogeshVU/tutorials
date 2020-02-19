package com.goalabs.array;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class InsertElementArray {

    public static Integer[] addElementUsingArraysCopyOf(Integer[] srcArray, int elementToAdd) {
        Integer[] destArray = Arrays.copyOf(srcArray,srcArray.length+1);
        destArray[destArray.length - 1] = elementToAdd;
        return destArray;
    }

    public static Integer[] addElementUsingArrayList(Integer[] srcArray, int elementToAdd) {
//        Create a new array
        Integer[] destArray = new Integer[srcArray.length + 1];
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(srcArray));
        arrayList.add(elementToAdd);

        return arrayList.toArray(destArray);
    }

    public static Integer[] addElementUsingSystemArrayCopy(Integer[] srcArray, int elementToAdd) {
        Integer[] destArray = new Integer[srcArray.length + 1];

        System.arraycopy(srcArray, 0, destArray, 0, srcArray.length);

        destArray[destArray.length - 1] = elementToAdd;

        return destArray;
    }


    public static void main(String[] args){

        Integer[] tmp1 = new Integer[]{1,2,3,4,5};
        Integer[] newtmp1 = InsertElementArray.addElementUsingArraysCopyOf(tmp1, 6);
        for(Integer a: newtmp1){
            System.out.println(a);
        }
        


    }

}
