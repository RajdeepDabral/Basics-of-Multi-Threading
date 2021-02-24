/*
Q13. Coordinate 2 threads using wait() and notify().
*/

package com.company;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BankClass {
    private int balance;
    public BankClass(){
        balance=0;
    }
    public synchronized void deposit(int balance) throws InterruptedException {
        Thread.sleep(1000);
        this.balance=balance;
        System.out.println("Notify thread balance is added!!!");
        notify();
    }
    public synchronized void withDraw(int balance) throws InterruptedException {
        if(this.balance==0){
            System.out.println("Thread wait balance is zero!!!");
            wait();
        }
        this.balance=this.balance-balance;
        System.out.println("Remaining Balance : "+this.balance);
    }
}
class Bank{
    public static void main(String [] args){
        BankClass boi = new BankClass();
        Runnable r1 = () -> {
                try {
                    boi.withDraw(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        };
        Runnable r2 = ()-> {
                try {
                    boi.deposit(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        };

        ExecutorService executors = Executors.newFixedThreadPool(2);
        executors.submit(r1);
        executors.submit(r2);

        executors.shutdown();
    }
}

