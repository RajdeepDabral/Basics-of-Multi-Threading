/*
Q12. Use Atomic Classes instead of Synchronize method and blocks.
*/
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;
    import java.util.concurrent.atomic.AtomicInteger;


    class MyTask implements Runnable{
        private static AtomicInteger counter =  new AtomicInteger(0);
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                    counter.getAndIncrement();
            }
        }
        public int getCounter(){
            return counter.get();
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

            System.out.println("Atomic Integer counter : "+new MyTask().getCounter());
        }
    }

