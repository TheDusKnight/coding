package OOD.MultiThread;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new YouThread();
        t.start();
        Thread.sleep(1000); // 暂停1毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }
}

class YouThread extends Thread {
    @Override
    public void run() {
        Thread helloThread = new HelloThread();
        helloThread.start();
        try {
            helloThread.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted by main thread");
        }
        helloThread.interrupt();
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("interrupted by YouThread");
                break;
            }
        }
    }
}
