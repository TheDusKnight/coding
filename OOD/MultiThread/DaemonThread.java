package OOD.MultiThread;

import java.time.LocalTime;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new TimerThread();
        t.setDaemon(true);
        t.start();
        Thread.sleep(3000);
        System.out.println("exit main thread");
    }

}

class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
