/*
Q16. Create a deadlock and Resolve it using tryLock().
*/
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class A {

    private ReentrantLock lock=new ReentrantLock();

    public void foo(B b){
        try {
            lock.tryLock(1000L, TimeUnit.MILLISECONDS);
            System.out.println("class A foo()");
            b.last();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void last(){
        try {
            lock.tryLock(1000L,TimeUnit.MILLISECONDS);
            System.out.println("class A last()");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class B {

    private ReentrantLock lock = new ReentrantLock();

    public void bar(A a) {
        try {
            lock.tryLock(1000L, TimeUnit.MILLISECONDS);
            System.out.println("class B bar()");
            a.last();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void last() {
        try {
            lock.tryLock(1000L, TimeUnit.MILLISECONDS);
            System.out.println("class B last()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Program implements Runnable {

    A a = new A();
    B b = new B();

    public void init() {
        a.foo(b);
    }

    @Override
    public void run() {
        b.bar(a);
    }

    public static void main(String[] args) {
        Program program = new Program();
        new Thread(program).start();
        program.init();
    }
}



