package com.practice.bhargav;

public class PrintEvenOddTester {

    public static void main(String... args) {
        Printer print = new Printer();
        Thread tOdd = new Thread(new TaskOdd(print, 10));
        Thread tEven = new Thread(new TaskEven(print, 10));
        tOdd.start();
        tEven.start();
    }

}

class Printer {

    boolean isOdd = false;

    synchronized void printEven(int number) {

        while (isOdd == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Even:" + number);
        isOdd = false;
        notifyAll();
    }

    synchronized void printOdd(int number) {
        while (isOdd == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Odd:" + number);
        isOdd = true;
        notifyAll();
    }

}