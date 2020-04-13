package com.goalabs.paralleltasktutorial;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class PickFruitTask extends RecursiveTask<Integer> {

    private final AppleTree[] appleTrees;
    private final int startInclusive;
    private final int endInclusive;

    private final int taskThreadshold = 4;

    public PickFruitTask(AppleTree[] array, int startInclusive, int endInclusive) {
        this.appleTrees = array;
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    @Override
    protected Integer compute() {

        if (endInclusive - startInclusive < taskThreadshold) {
            return doCompute();
        }


        int midpoint = startInclusive + (endInclusive - startInclusive) / 2;
        PickFruitTask leftSum = new PickFruitTask(appleTrees,startInclusive,midpoint);
        PickFruitTask rightSum = new PickFruitTask(appleTrees,midpoint+1,endInclusive);

        rightSum.fork(); // computed asynchronously

        return leftSum.compute()// computed synchronously: immediately and in the current thread
                + rightSum.join();
    }

    protected Integer doCompute() {

        return IntStream.rangeClosed(startInclusive, endInclusive)//
                .map(i -> appleTrees[i].pickApples())//
                .sum();
//          Equivalent with a "for" loop :)
//			int result = 0;
//			for (int i = startInclusive; i <= endInclusive; i++) {
//				result += array[i].pickApples();
//			}
//			return result;
    }


    public static void main(String[] args) {
//        Create the garden
        AppleTree[] appleTrees = AppleTree.newTreeGarden(12);

        // Instantiate the forkjoinpool
        ForkJoinPool pool = ForkJoinPool.commonPool();
        // instantiate the task
        PickFruitTask task = new PickFruitTask(appleTrees, 0, appleTrees.length - 1);
        // invoke the fork join on the task
        int result = pool.invoke(task);

        System.out.println();
        System.out.println("Total apples picked: " + result);
    }
}
