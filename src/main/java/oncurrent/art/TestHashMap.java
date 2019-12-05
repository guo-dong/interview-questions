package oncurrent.art;

import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: guodong
 * @Date: 2019/2/19
 */
public class TestHashMap {

    public static void main(String[] args) throws InterruptedException {
        final HashMap<String,String> map = new HashMap<>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(),"");
                        }
                    },"ftf"+i).start();
                }
            }
        },"ftf");
        t.start();
        t.join();
    }
}
