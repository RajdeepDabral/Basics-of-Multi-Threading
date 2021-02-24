/*
Q6. Return a Future from ExecutorService by using callable and use get(), isDone(), isCancelled()
    with the Future object to know the status of task submitted.
 */

package com.company;
import java.util.concurrent.*;

/*
isDone():- It Returns true if the task is complete and false otherwise

get():- Used to get the result of the task.
        If the task is complete, it returns the result immediately,
        otherwise it waits till the task is complete and then returns the result.

isCancelled() :- It Returns true if this task was cancelled before it completed normally
 */
class MyThread implements Callable<String>{
    private String name;

    public MyThread(String name){
        this.name=name;
    }

    @Override
    public String call() throws Exception {
        return "Hello @ "+this.name;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyThread t1 = new MyThread("Rajdeep");
        MyThread t2 = new MyThread("Suraj");
        ExecutorService executors = Executors.newSingleThreadExecutor();

        Future<String> future1 = executors.submit(t1);
        System.out.println("future1.isCancelled Before :"+future1.isCancelled());
        System.out.println("Future1 result : "+future1.get());
        System.out.println("future1.isCancelled After :"+future1.isCancelled()+"\n");

        Future<String> future2 =executors.submit(t2);
        System.out.println("future2.isDone Before :"+ future2.isDone());
        System.out.println("Future2 result : "+future2.get());
        System.out.println("future2.isDone After :"+ future2.isDone());


        executors.shutdown();
    }
}
