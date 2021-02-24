/*
Q10. Use Synchronize method to enable synchronization between multiple threads
       trying to access method at same time.
 */

package com.company;
import java.util.concurrent.*;

class StringOpr {
    public static synchronized void perform(String strname) throws InterruptedException {
        System.out.println("String is : "+strname);
        System.out.println("String length "+" : "+strname.length());
        Thread.sleep(1000) ;
        System.out.println("String toUpperCase "+" : "+strname.toUpperCase());
        Thread.sleep(1000) ;
        System.out.println("String toLowerCase "+" : "+strname.toLowerCase());
        Thread.sleep(1000) ;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Runnable r1=  () -> {
                try {
                    StringOpr.perform("Rajdeep");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        };
        Runnable r2=  () -> {
            try {
                StringOpr.perform("suraj");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r3=  () -> {
            try {
                StringOpr.perform("Rohit");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r4=  () -> {
            try {
                StringOpr.perform("neha");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService executors = Executors.newFixedThreadPool(2);

        executors.submit(r1);
        executors.submit(r2);
        executors.submit(r3);
        executors.submit(r4);

        executors.shutdown();
    }
}
