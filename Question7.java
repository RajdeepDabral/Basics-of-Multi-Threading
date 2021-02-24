/*
Q7. Submit List of tasks to ExecutorService and wait for the completion of all the tasks.
 */

package com.company;
import java.util.concurrent.*;

class MyThread implements Runnable{
    private String name;

    public MyThread(String name){
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println("Hello @ "+name);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyThread t1 = new MyThread("Rajdeep");
        MyThread t2 = new MyThread("Suraj");
        MyThread t3 = new MyThread("Mohit");
        MyThread t4 = new MyThread("Pankaj");
        MyThread t5 = new MyThread("Neha");
        MyThread t6 = new MyThread("Deepak");

        ExecutorService executors = Executors.newSingleThreadExecutor();
        executors.submit(t1);
        executors.submit(t2);
        executors.submit(t3);
        executors.submit(t4);
        executors.submit(t5);
        executors.submit(t6);

        executors.shutdown();

        executors.awaitTermination(1,TimeUnit.HOURS);
        System.out.println("######Main End######");
    }
}
