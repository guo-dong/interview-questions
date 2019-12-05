package oncurrent.art;

/**
 * 双重锁，延迟加载
 * @Author: guodong
 * @Date: 2019/4/6
 */
public class Singleton {

    private static volatile Singleton singleton = null;
    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null ) {
            synchronized (Singleton.class){
                if (singleton == null ) {
                    singleton = new Singleton();
                }
            }

        }
        return singleton;
    }

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.hashCode());
    }


}
