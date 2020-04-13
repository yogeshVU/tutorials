package com.goalabs.paralleltasktutorial;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


//Source: https://github.com/PacktPublishing/Java-Concurrency-Multithreading-in-Practice/blob/master/src/main/java/com/packt/tfesenko/multithreading/section1
public class AppleTree {


    private final String treeLabel;
    private final int numberOfApples;

    public AppleTree(String treeLabel, int numberOfApples) {
        this.treeLabel = treeLabel;
        this.numberOfApples = numberOfApples;
    }



    public int pickApples(String workerName) {

        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("%s picked %d 🍏s from %s \n", workerName, numberOfApples, treeLabel);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return numberOfApples;
    }

    public int pickApples() {
        return pickApples(toLabel(Thread.currentThread().getName()));
    }

    public String toLabel(String threadName){

        HashMap<String, String> threadNametoLabel = new HashMap<>();
        threadNametoLabel.put("ForkJoinPool.commonPool-worker-1", "Alice");
        threadNametoLabel.put("ForkJoinPool.commonPool-worker-2", "Bob");
        threadNametoLabel.put("ForkJoinPool.commonPool-worker-3", "Carol");
        threadNametoLabel.put("ForkJoinPool.commonPool-worker-4", "Dan");

        return threadNametoLabel.getOrDefault(threadName, threadName);
    }

    public static AppleTree[] newTreeGarden(int size) {
        AppleTree[] appleTrees = new AppleTree[size];
        for (int i = 0; i < appleTrees.length; i++) {
            appleTrees[i] = new AppleTree("🌳#" + i,3);
        }
        return appleTrees;
    }
}
