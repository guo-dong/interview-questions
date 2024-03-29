package oncurrent.art;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: guodong
 * @Date: 2019/2/15
 */
public class WaitNotify {

    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock){
                //当条件不满足时，继续wait，同时释放了lock 的锁
                while (flag){
                    try {
                        System.out.println(Thread.currentThread()+"flag is true.wait @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                        lock.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //条件满足时，完成工作
                System.out.println(Thread.currentThread()+" flag is false. running @ "+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            //加锁，拥有lock的Monitor
            synchronized (lock){
                //获取lock的锁，然后就进行通知，同时不会释放lock的锁
                //直到当前线程释放了lock之后，WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread()+" hold lock. notify @ "+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.second(1);
            }
            //再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread() + " hold lock again. sleep @ "+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(1);
            }
        }
    }
}
