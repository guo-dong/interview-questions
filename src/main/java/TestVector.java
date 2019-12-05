import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @Author: guodong
 * @Date: 2019/6/3
 */
public class TestVector {

    public static void main(String[] args) {
        // 初始化一个list，放入5个元素
        final List<Integer> list = new Vector<>();
        for(int i = 0; i < 5; i++) {
            list.add(i);
        }

        // 线程一：通过Iterator遍历List
        new Thread(new Runnable() {
            @Override
            public void run() {
                // synchronized来锁住list，remove操作会在遍历完成释放锁后进行
                while (true){
                    synchronized (list) {
                        Iterator var1 = list.iterator();
                        while (var1.hasNext()){
                            System.out.println(var1.next());
                        }

                        /*for(int item : list) {
                            System.out.println("遍历元素：" + item);
                            // 由于程序跑的太快，这里sleep了1秒来调慢程序的运行速度
                            *//*
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            *//*
                        }
                        */
                    }
                }

            }
        }).start();

        // 线程二：remove一个元素
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    // 由于程序跑的太快，这里sleep了1秒来调慢程序的运行速度
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.clear();
                }

            }
        }).start();

        // 线程二：remove一个元素
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    // 由于程序跑的太快，这里sleep了1秒来调慢程序的运行速度
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add(1);
                    list.add(2);
                }

            }
        }).start();
    }

}
