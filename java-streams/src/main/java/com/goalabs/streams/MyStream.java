package com.goalabs.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class MyStream {

    static class User {
        private String name;
        private Integer age = 30;
        private List<Integer> phoneNumber = Arrays.asList(120,10,20,30);

        public List<Integer> getPhoneNumbers(){
            return phoneNumber;
        }

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "name : " + name + " age : " + age;
        }
    }

    MyStream(){
        System.out.println("Creating MyStream Object");
    }


    void intro1(){
        // 1. Integer Stream
        IntStream
                .range(1, 10)
                .forEach(System.out::println);

    }

    void intro2(){
        IntStream.range(1,10)
                .skip(2)
                .filter(x -> x!=3)
                .forEach(x->System.out.println(x));
    }

    void intro3(){
        // 3. Integer Stream with sum

        System.out.println(IntStream.range(1,10).map(x-> x).sum());
    }

    void intro4(){
        // 4. Stream.of, sorted and findFirst
        Stream.of("Yogesh","Mahesh","Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(x -> System.out.println(x));
    }

    void intro5(){
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
//        Convert arrays to stream
        Arrays.stream(names)	// same as Stream.of(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
    }

    void intro6(){

        // 6. average of squares of an int array
        Arrays.stream(new int[] {2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
    }

    void intro7(){
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");

        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
    }

    void intro8(){
        List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");

//        for (String name : names) {
//            if (!name.equals("Sam")) {
//                System.out.println(name);
//            }
//        }

        names.stream()
                .filter(MyStream::isNotSam)
                .forEach(System.out::println);

    }


    void intro9(){

        List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");

//        System.out.println("Imperative Style: ");
//
//        for (String name : names) {
//            if (!name.equals("Sam")) {
//                User user = new User(name);
//                System.out.println(user);
//            }
//        }

//        System.out.println("Functional Style: ");

        names.stream()
                .filter(MyStream::isNotSam)
                .map(User::new)
                .forEach(System.out::println);

        List<User> userList = names.stream()
                .filter(MyStream::isNotSam)
                .map(User::new)
                .collect(Collectors.toList());

        int sum = userList.stream()
                .mapToInt(User::getAge)
                .sum();

        System.out.println(sum);


        Optional<Integer> stringOptional = userList.stream()
                .map(user -> user.getPhoneNumbers().stream())
                .flatMap(integerStream -> integerStream.filter(phoneNo -> !phoneNo.equals(10)))
                .findFirst();

        stringOptional.ifPresent(System.out::println);

    }


    private static boolean isNotSam(String name) {
        return !name.equals("Sam");
    }


    @Override
    public String toString() {
        return "MyStream{}";
    }

    public static void main(String[] args) {
        System.out.println("Hello World to the Java Streams");
        MyStream a = new MyStream();
        System.out.println(a.toString());

//        a.intro1();
//        a.intro2();
        a.intro9();
    }
}

