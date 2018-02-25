package com.practice.bhargav;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{

    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting task : "+id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending task : "+id);
    }
}

/*
*
1 thread - 15 sec
2 thread - 9 sec
3 thread - 6 sec
4 thread - 6 sec
5 thread - 3 sec
6 thread - 3 sec
*
* */

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(6);

        for(int i = 0; i < 5; i++){
            executor.submit(new Task(i));
        }

        executor.shutdown();

        System.out.println("All tasks submitted");

        double startTime = System.currentTimeMillis();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("time taken : "+(System.currentTimeMillis() - startTime));
        System.out.println("All tasks completed");
    }
}
