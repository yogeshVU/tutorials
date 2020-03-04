package com.goalabs.threading;

class ThreadedPrinter extends Thread{
    @Override
    public synchronized void run() {
        for(int i=0;i<10;i++){
            System.out.println("Printing value from Thread: "+i+": "+Thread.currentThread().getName());
        }
    }
}

class RunnablePrinter implements Runnable{
    @Override
    public synchronized void run() {
        for(int i=0;i<10;i++){
            System.out.println("Printing value: "+i+": "+Thread.currentThread().getName());
        }
    }
}

class MyDocument{
    private ThreadedPrinter ptr;
    private Runnable rptr;

    public MyDocument(ThreadedPrinter tempPtr){
        this.ptr = tempPtr;
    }

    public MyDocument(RunnablePrinter tempPtr){
        this.rptr = tempPtr;
    }

    public void submit(){
        if(this.ptr!=null)
        this.ptr.start();

        if(this.rptr!=null)
            this.rptr.run();
    }

}



public class MySynchronize {

    public static void main(String[] args){
        MyDocument d1 = new MyDocument(new ThreadedPrinter());
        MyDocument d2 = new MyDocument(new ThreadedPrinter());

//        d1.submit();
//        d2.submit();

        MyDocument d3 = new MyDocument(new RunnablePrinter());
        MyDocument d4 = new MyDocument(new RunnablePrinter());

        d3.submit();
        d4.submit();

    }

}
