package com.practice.bhargav;

import java.util.List;

public class OddConsumer implements Runnable{
    private final List<Integer> taskQueue;

    public OddConsumer(List<Integer> sharedQueue)
    {
        this.taskQueue = sharedQueue;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                consume();
            } catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException
    {
        synchronized (taskQueue)
        {
            while (taskQueue.isEmpty())
            {
                System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                taskQueue.wait();
            }
            if(taskQueue.get(0)%2 != 0)
            {
                //Thread.sleep(1000);
                int i = (Integer) taskQueue.remove(0);
                System.out.println("Odd Consumed: " + i);
                taskQueue.notifyAll();
            }

        }
    }
}
