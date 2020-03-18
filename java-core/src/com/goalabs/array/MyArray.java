package com.goalabs.array;
import java.util.Arrays;


public class MyArray {

    static int[] initializeArrayInLoop() {

        int array[] = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;

    }

    static int[][] initializeMultiDimensionalArrayInLoop() {
        int array[][] = new int [2][5];
        int counter = 0;
        for( int i = 0; i< 2; i++){
            for (int j = 0; j< 5;j++){
                array[i][j] = counter;
                counter++;
            }
        }
        return array;
    }

    static String[] initializeArrayAtTimeOfDeclarationMethod1() {

        String array[] = new String[]{"Yogesh", "Mahesh","Test1"};
//        String array[] = new String[] { "Toyota", "Mercedes", "BMW", "Volkswagen", "Skoda" };
        return array;
    }

    static int[] initializeArrayAtTimeOfDeclarationMethod2() {
        int[] array = new int[] { 1, 2, 3, 4, 5 };
        return array;
    }

    static int[] initializeArrayAtTimeOfDeclarationMethod3() {
        int array[] = { 1, 2, 3, 4, 5 };
        return array;
    }

    static long[] initializeArrayUsingArraysFill() {
        long array[] = new long[5];
        Arrays.fill(array, 30);
        Arrays.fill(array,0,2,12);


        return array;
    }

    static int[] initializeArrayRangeUsingArraysFill() {
        int array[] = new int[5];
        Arrays.fill(array, 0, 3, -50);
        return array;
    }

    static int[] initializeArrayUsingArraysCopy() {
        int array[] = { 1, 2, 3, 4, 5 };
        int[] copy = Arrays.copyOf(array, 5);
        return copy;
    }

    static int[] initializeLargerArrayUsingArraysCopy() {
        int array[] = { 1, 2, 3, 4, 5 };
        int[] copy = Arrays.copyOf(array, 6);
        return copy;
    }

    static int[] initializeArrayUsingArraysSetAll() {
        int[] array = new int[20];

        Arrays.setAll(array, p -> p > 9 ? 0 : p);
        return array;
    }


    public static void main(String[] args){

//        int myarray [] = MyArray.initializeArrayInLoop();
//        for(int a: myarray){
//            System.out.println(a);
//        }

//        int myarray[][] = MyArray.initializeMultiDimensionalArrayInLoop();
//        for(int arr[] : myarray){
//            for(int ar: arr){
//                System.out.println(ar);
//            }
//        }
//
//          String array[] = MyArray.initializeArrayAtTimeOfDeclarationMethod1();
//
//        for(String a: array){
//            System.out.println(a);
//        }


       long array[]= MyArray.initializeArrayUsingArraysFill();
       for(long a: array){
           System.out.println(a);
       }

    }

}