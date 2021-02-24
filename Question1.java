/*Q1. Create and Run a Thread using Runnable Interface and Thread class. */
package com.company;

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnable class implements Runnable Interface");
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread class extends Threads class");
    }
}

public class Main {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        new MyThread().start();
    }
}

