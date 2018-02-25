package com.practice.bhargav;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
    private List<Integer> l1 = new ArrayList<>();
    private List<Integer> l2 = new ArrayList<>();

    Random random = new Random();

    Object lock1 = new Object();
    Object lock2 = new Object();

    public void stage1(){

        synchronized (lock1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            l1.add(random.nextInt(100));
        }
    }

    public void stage2(){
        synchronized (lock2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            l2.add(random.nextInt(100));
        }
    }

    public void process(){
        for(int i = 0; i<1000; i++){
            stage1();
            stage2();
        }
    }

    public void work(){
        System.out.println("Starting . . .");
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(()->{
            process();
        });

        Thread t2 = new Thread(()->{
            process();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("time took : "+(end-start)+" millis");
        System.out.println("List 1 : "+l1.size());
        System.out.println("List 2 : "+l2.size());
    }
}
