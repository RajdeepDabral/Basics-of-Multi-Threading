/*
Q8. Schedule task using schedule(), scheduleAtFixedRate() and scheduleAtFixedDelay()
*/
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


class MyTask1 implements Runnable{
    @Override
    public void run() {

        System.out.println("Task1 started");
        System.out.println("Task1 executed by schedule method");
        System.out.println("Task1 ended!!!");
    }
}
class MyTask2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Task2 started");
        System.out.println("Task2 executed by scheduleAtFixedRate method");
        System.out.println("Task2 ended!!!");
    }
}
class MyTask3 implements Runnable{
    @Override
    public void run() {
        System.out.println("Task3 started");
        System.out.println("Task3 executed by scheduleWithFixedDelay method");
        System.out.println("Task3 ended!!!");
    }
}

public class Program {
    public static void main(String [] args){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(new MyTask1(),0, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new MyTask2(),1,5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(new MyTask3(),1,5, TimeUnit.SECONDS);
    }
}

