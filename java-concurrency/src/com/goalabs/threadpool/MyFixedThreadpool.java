package com.goalabs.threadpool;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Runnable{

    private volatile int counter = 0;
    @Override
    public synchronized void run() {

        for(int i =0;i<100;i++){
            counter++;
        }
        System.out.println("counter "+counter);

    }
}

public class MyFixedThreadpool {

    public static void main(String[] args){
        int numberofcores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of Processors: "+ numberofcores);
        ExecutorService myservice = Executors.newFixedThreadPool(numberofcores);
        for(int i =0; i<1000;i++)
            myservice.execute(new MyTask());

        myservice.shutdown();

    }

}
