package com.goalabs.paralleltasktutorial;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.stream.IntStream;

public class ForkJoinRecursiveAction extends RecursiveAction {


    private final AppleTree[] appleTrees;
    private final int startInclusive;
    private final int endInclusive;

    private final int taskThreadshold = 4;

    public ForkJoinRecursiveAction(AppleTree[] appleTrees, int startInclusive, int endInclusive) {
        this.appleTrees = appleTrees;
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    protected void doCompute() {
//
//            IntStream.rangeClosed(startInclusive, endInclusive)//
//                .map(i -> appleTrees[i].pickApples());

            IntStream.rangeClosed(startInclusive,endInclusive)
                    .forEach(i -> appleTrees[i].pickApples());
//          Equivalent with a "for" loop :)
//			int result = 0;
//			for (int i = startInclusive; i <= endInclusive; i++) {
//				result += array[i].pickApples();
//			}
//			return result;
    }

    @Override
    protected void compute() {
            if (this.endInclusive - this.startInclusive < taskThreadshold){
                doCompute();
                return;
            }

            int midPoint = startInclusive + (endInclusive-startInclusive)/2;
            ForkJoinRecursiveAction leftSum = new ForkJoinRecursiveAction(appleTrees,startInclusive,midPoint);
            ForkJoinRecursiveAction rightSum = new ForkJoinRecursiveAction(appleTrees,midPoint+1,endInclusive);

            rightSum.fork(); // computed asynchronously
            leftSum.compute();// computed synchronously: immediately and in the current thread
            rightSum.join();
    }


    public static void main(String[] args){

        AppleTree[] myTrees = AppleTree.newTreeGarden(10);
        ForkJoinRecursiveAction action = new ForkJoinRecursiveAction(myTrees,0,myTrees.length-1);

        ForkJoinPool pool = ForkJoinPool.commonPool();

        pool.invoke(action);

    }
}
