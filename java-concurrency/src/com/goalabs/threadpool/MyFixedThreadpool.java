package com.goalabs.threadpool;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MyTask implements Runnable{

    public static volatile int counter = 0;
    @Override
    public synchronized void run() {

//        for(int i =0;i<100;i++){
            counter++;
//        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("counter "+counter);

    }
}

public class MyFixedThreadpool {

    public static void main(String[] args) throws InterruptedException {
        int numberofcores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of Processors: "+ numberofcores);
        long startProcessingTime = System.currentTimeMillis();

        ExecutorService myservice = Executors.newFixedThreadPool(numberofcores);

        for(int i =0; i<1000;i++)
            myservice.execute(new MyTask());

        long endProcessingTime = System.currentTimeMillis();

        long totaltime = endProcessingTime - startProcessingTime;


        myservice.shutdown();
        myservice.awaitTermination(300, TimeUnit.SECONDS);
        System.out.println("Total Completion time is: "+totaltime);
        System.out.println("Counter Value: "+MyTask.counter);


    }

}
