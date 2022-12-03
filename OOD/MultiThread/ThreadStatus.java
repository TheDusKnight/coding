package OOD.MultiThread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ThreadStatus {

    public static void main(String[] args) {
        Log log = LogFactory.getLog(ThreadStatus.class);

        Thread t = new Thread(() -> {
            System.out.println("runnable run");
        });
        System.out.println("hello");
        t.start();
        // wait until the thread finish
        try {
            // Thread.sleep(50);
            t.join();
        } catch (InterruptedException e) {
            log.error("sleep is interrupted!", e);
        }
        System.out.println("world");
    }
}
