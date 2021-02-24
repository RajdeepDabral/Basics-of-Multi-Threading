/*
Q4. Try shutdown() and shutdownNow() and observe the difference
 */


package com.company;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
shutdown() :- It will just tell the executor service that it can't accept new tasks,
              but the already submitted tasks continue to run
*/

/*
shutdownNow() :- It will do the same AND will try to cancel the already submitted tasks
                 by interrupting the relevant threads.
                 Note that if your tasks ignore the interruption, shutdownNow will behave exactly the same way as shutdown.
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
                Thread.sleep(1000);
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
        MyThread t3 = new MyThread("t3");
        ExecutorService executors = Executors.newSingleThreadExecutor();
        executors.submit(t1);
        executors.submit(t2);
        executors.submit(t3);
        executors.shutdown();
       //executors.shutdownNow();
    }
}

