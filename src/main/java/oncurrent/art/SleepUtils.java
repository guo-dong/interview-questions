package oncurrent.art;

import java.util.concurrent.TimeUnit;

/**
 * @Author: guodong
 * @Date: 2019/2/14
 */
public class SleepUtils {

    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
