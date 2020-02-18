package com.goalabs.map;

import java.util.Iterator;
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

    public static void example3() {
        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);
        numbers.add(42);
        numbers.add(49);
        numbers.add(50);

        System.out.println("numbers TreeSet : " + numbers);

        // Remove an element from the TreeSet
        boolean isRemoved = numbers.remove(49);
        if(isRemoved) {
            System.out.println("After Removing 49 : " + numbers);
        }

        // Remove all elements divisible by 3
        numbers.removeIf(number -> number % 3 == 0);
        System.out.println("After removeIf() : " + numbers);


        // Retrieve and remove the first element from the TreeSet
        Integer num = numbers.pollFirst();
        System.out.println("Removed first element " + num + " from the TreeSet : " + numbers);

        // Retrieve and remove the last element from the TreeSet
        num = numbers.pollLast();
        System.out.println("Removed last element " + num + " from the TreeSet : " + numbers);
        
    }

    public static void example4() 
    { 
        // Creating an empty TreeSet 
        TreeSet<String> set = new TreeSet<String>(); 
  
        // Use add() method to add elements into the Set 
        set.add("Welcome"); 
        set.add("To"); 
        set.add("Geeks"); 
        set.add("4"); 
        set.add("Geeks"); 
  
        // Displaying the TreeSet 
        System.out.println("TreeSet: " + set); 
  
        // Creating an iterator 
        Iterator<String> value = set.iterator(); 
  
        // Displaying the values after iterating through the set 
        System.out.println("The iterator values are: "); 
        while (value.hasNext()) { 
            System.out.println(value.next()); 
        } 
    } 

    public static void main(String[] args) {
        
        MyTreeSet.example1();
        MyTreeSet.example2();

        MyTreeSet.example3();
        MyTreeSet.example4();
    }
    
}