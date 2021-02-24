/*
Q2. Use sleep and join methods with thread.
*/
package com.company;

class MyThread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("MyThread class thread sleep!!!!");
            Thread.sleep(5000);
            System.out.println("MyThread class thread wakeUp!!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<5;i++){
            System.out.println("MyThread class :  < "+ i+" >");
        }
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for(int i=0;i<5;i++){
                System.out.println("Thread class :  < "+ i+" >");
            }
        });
        t1.start();
        t1.join();
        new MyThread().start();
    }
}

