package com.practice.bhargav;

import java.util.ArrayList;
import java.util.List;

/*
* https://howtodoinjava.com/core-java/multi-threading/how-to-work-with-wait-notify-and-notifyall-in-java/
* */
public class ProducerConsumerExampleWithWaitAndNotify {
    public static void main(String[] args) {
        List<Integer> taskQueue = new ArrayList<Integer>();
        int MAX_CAPACITY = 5;
        Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
        Thread tOddConsumer = new Thread(new OddConsumer(taskQueue), "Odd Consumer");
        Thread tEvenConsumer = new Thread(new EvenConsumer(taskQueue), "Even Consumer");
        tProducer.start();
        tOddConsumer.start();
        tEvenConsumer.start();
    }
}
