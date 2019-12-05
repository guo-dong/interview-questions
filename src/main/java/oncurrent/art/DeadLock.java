package oncurrent.art;

/**
 * @Author: guodong
 * @Date: 2019/3/20
 */
public class DeadLock {

    public static final String A = "A";
    public static final String B = "B";


    static class Work1 implements Runnable {
        @Override
        public void run() {
            synchronized (A){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println(1);
                }
            }
        }
    }

    static class Work2 implements Runnable {
        @Override
        public void run() {
            synchronized (B){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A){
                    System.out.println(2);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Work1());
        Thread t2 = new Thread(new Work2());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
