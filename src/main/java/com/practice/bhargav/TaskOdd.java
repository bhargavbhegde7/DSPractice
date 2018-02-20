package com.practice.bhargav;

class TaskOdd implements Runnable {

    private int max;
    private Printer print;

    TaskOdd(Printer print, int max) {
        this.print = print;
        this.max = max;
    }

    @Override
    public void run() {

        int number = 1;
        while (number <= max) {
            print.printOdd(number);
            number += 2;
        }

    }

}
