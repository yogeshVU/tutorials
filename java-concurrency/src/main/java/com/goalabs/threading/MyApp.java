package com.goalabs.threading;


class MyTask extends Thread{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Printing value from Thread: "+i);
        }
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Printing value: "+i);
        }
    }
}

public class MyApp {

    public static void main(String[] args){


        new Thread(new MyRunnable()).start();
        System.out.println("Starting the Task");
        MyTask a = new MyTask();
        a.start();

    }


}
