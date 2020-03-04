package com.goalabs.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.stream.StreamSupport;

class MyCallableTask implements Callable{
    @Override
    public Object call() throws Exception {

//        Get the time of computation
        Long currentTime = System.currentTimeMillis();
        TimeUnit.MILLISECONDS.sleep(100);

        return  (System.currentTimeMillis()-currentTime);

    }
}

public class MyCallableExecutor {

    public ExecutorService MyService;

    public MyCallableExecutor(){
        this.MyService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallableExecutor tmp = new MyCallableExecutor();
        List<Future<Long>> myFuture  = new ArrayList<Future<Long>>();

        for(int i =0;i<100;i++){
            Future future = tmp.MyService.submit(new MyCallableTask());
            myFuture.add(future);
        }

        for (Future<Long> result : myFuture)
        {
            Long number = null;
            try {
                number = result.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("Main: Task %d\n", number);
        }
        tmp.MyService.shutdown();
        tmp.MyService.awaitTermination(1000,TimeUnit.MILLISECONDS);

    }

}
