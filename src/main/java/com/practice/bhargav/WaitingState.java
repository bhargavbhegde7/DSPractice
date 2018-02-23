package com.practice.bhargav;

import sun.rmi.runtime.Log;

public class WaitingState implements Runnable {
    public static Thread t1;

    public static void main(String[] args) {
        t1 = new Thread(new WaitingState());
        t1.start();
    }

    public void run() {
        Thread t2 = new Thread(new DemoThreadWS());
        t2.start();

        try {
            //t2.join();
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            //Log.error("Thread interrupted", e);
            System.out.println("Thread interrupted");
        }
    }
}

class DemoThreadWS implements Runnable {
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            //Log.error("Thread interrupted", e);
            System.out.println("Thread interrupted");
        }

        //Log.info(WaitingState.t1.getState());
        System.out.println(WaitingState.t1.getState());
    }
}