package com.practice.bhargav;

public class ThreadCallBack {
    public static void main(String[] args) {

        Thread t = new Thread(new RunnableTask(() -> System.out.println("This will be run after the thread is finished processing")));
        t.start();
    }
}

@FunctionalInterface
interface FinishHandler{
    void handleFinished();
}

class RunnableTask implements Runnable{

    FinishHandler handler;

    public RunnableTask(FinishHandler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        System.out.println("Starting the runner task");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done running the thread");
        handler.handleFinished();
    }
}