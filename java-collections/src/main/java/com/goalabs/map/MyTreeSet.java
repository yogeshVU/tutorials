package com.goalabs.map;

import java.util.SortedSet;
import java.util.TreeSet;


class MyTreeSet{

    public static void example1(){
             // Creating a TreeSet with a custom Comparator (Case Insensitive Order)
             SortedSet<String> fruits = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

             /*
                 The above TreeSet with the custom Comparator is the concise form of the following:
                 SortedSet<String> fruits = new TreeSet<>(new Comparator<String>() {
                     @Override
                     public int compare(String s1, String s2) {
                         return s1.compareToIgnoreCase(s2);
                     }
                 });
             */
     
             // Adding new elements to a TreeSet
             fruits.add("Banana");
             fruits.add("Apple");
             fruits.add("Pineapple");
             fruits.add("Orange");
     
             System.out.println("Fruits Set : " + fruits);
    }

    public static void example2(){

        TreeSet<Integer> ts1 = new TreeSet<Integer>(); 
  
        // Elements are added using add() method 
        ts1.add(1); 

        ts1.add(2); 
        ts1.add(3); 
        ts1.add(-1); 

  
        // Duplicates will not get insert 
        ts1.add(3); 
  
        // Elements get stored in default natural 
        // Sorting Order(Ascending) 
        System.out.println(ts1); 
    }

    public static void main(String[] args) {
        
        MyTreeSet.example1();
        MyTreeSet.example2();
    }
    
}