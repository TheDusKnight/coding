package OOD.MultiThread;

public class RunThread {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.run();

        Thread thread2 = new Thread(new MyRunnable());
        thread2.run();

        Thread thread3 = new Thread(() -> {
            System.out.println("lambda run");
        });
        thread3.run();
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread run");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("runnable run");
    }
}