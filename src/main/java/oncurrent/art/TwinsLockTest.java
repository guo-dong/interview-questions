package oncurrent.art;


import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * @Author: guodong
 * @Date: 2019/2/18
 */
public class TwinsLockTest {

    public static void main(String[] args) {

        final Lock lock = (Lock) new TwinsLock();
        class Worker extends Thread {
            public void run(){
                while(true){
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
