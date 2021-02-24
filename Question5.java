/*
Q5. Use isShutDown() and isTerminated() with ExecutorService.
 */

package com.company;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
isShutdown() :- It returns true if this executor has been shut down otherwise it returns false
*/

/*
isTerminated() :- It returns true if all the tasks have been completed following shut down.
                Here, we must notice that isTerminated() never returns true unless either shut down or
                shutdownNow was called first
 */

class MyThread implements Runnable {
    private String id;

    public MyThread(String id){
        this.id=id;
    }
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("MyThread id :"+this.id + "< "+i+" >");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        ExecutorService executors = Executors.newSingleThreadExecutor();
        System.out.println("Is Executors Terminated: "+executors.isTerminated());
        executors.submit(t1);
        executors.submit(t2);
        System.out.println("Is Executors ShutDown : "+executors.isShutdown());
        executors.shutdown();
        System.out.println("Is Executors ShutDown : "+executors.isShutdown());
        Thread.sleep(1000);
        System.out.println("Is Executors Terminated: "+executors.isTerminated());
    }
}
