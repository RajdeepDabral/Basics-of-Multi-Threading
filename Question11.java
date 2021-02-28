/*
Q11 . Use Synchronize block to enable synchronization between multiple threads trying to access method at same time.
*/
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class MyTask implements Runnable{
    private static int counter;
    @Override
    public void run() {
        synchronized (this){
            for(int i=0;i<100;i++){
                counter++;
            }
        }
    }
    public int getCounter(){
        return counter;
    }
}

public class Program {
    public static void main(String [] args){

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new MyTask());
        executorService.execute(new MyTask());
        executorService.execute(new MyTask());
        executorService.execute(new MyTask());
        executorService.execute(new MyTask());

        executorService.shutdown();
        while(!executorService.isTerminated()){
            //loop
        }
        System.out.println("All Assigned tasks are  completed!!!!!");

        System.out.println("counter : "+new MyTask().getCounter());
    }
}

