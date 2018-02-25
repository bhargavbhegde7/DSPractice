package com.practice.bhargav;

public class TrySynch1 {

    private int count = 0;

    public synchronized void getCountPlus1(){
        count++;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++){
            TrySynch1 te = new TrySynch1();
            te.doWork();
        }
    }

    private void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++){
                    getCountPlus1();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++){
                    getCountPlus1();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
