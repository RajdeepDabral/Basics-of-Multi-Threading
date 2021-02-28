/*
Q9 . Increase concurrency with Thread pools using newCachedThreadPool() and newFixedThreadPool().
*/
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


class MyTask1 implements Runnable{
    @Override
    public void run() {

        System.out.println("Task1 started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task1 ended!!!");
    }
}
class MyTask2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Task2 started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task2 ended!!!");
    }
}

public class Program {
    public static void main(String [] args){
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        for(int i=0;i<=10;i++){
            MyTask1 task1 = new MyTask1();
            executorService1.execute(task1);
        }


        ExecutorService executorService2 = Executors.newFixedThreadPool(5);

        for(int i=0;i<=10;i++){
            MyTask2 task2 = new MyTask2();
            executorService1.execute(task2);
        }

        executorService1.shutdown();
        executorService2.shutdown();

        while(!executorService1.isTerminated()  || !executorService2.isTerminated() ){
            //loop
        }
        System.out.println("All Assigned tasks are  completed!!!!!!");
    }
}

