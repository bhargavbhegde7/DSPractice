package com.practice.bhargav;

class TaskEven implements Runnable {

    private int max;
    private Printer print;

    TaskEven(Printer print, int max) {
        this.print = print;
        this.max = max;
    }

    @Override
    public void run() {

        int number = 2;
        while (number <= max) {
            print.printEven(number);
            number += 2;
        }

    }

}
