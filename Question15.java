/*
Q15. 
Use Reentract lock for coordinating 2 threads with signal(), signalAll() and wait().
*/
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Example{
    static int counter;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void increment() throws InterruptedException {
        lock.lock();
        try{
            counter++;
            System.out.println("Counter :"+ counter);
        }finally {

            lock.unlock();
        }
    }
    public void decrement(){
        lock.lock();
        try{
            if(counter==0){
            condition.signal();
        }else{
            condition.signalAll();
        }
        }finally {
            lock.unlock();
        }
    }

}

public class Program
{
    public static void main(String[] args)
    {
        Example example = new Example();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Runnable(){
            @Override
            public void run() {
                example.decrement();
            }
        });
        executorService.execute(new Runnable(){

            @Override
            public void run() {
                example.decrement();
            }
        });
        executorService.execute(new Runnable(){

            @Override
            public void run() {
                try {
                    example.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.shutdown();
        System.out.println("Counter :"+ example.counter);
    }
}



