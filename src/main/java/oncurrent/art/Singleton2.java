package oncurrent.art;

/**
 * 类的加载机制，初始化锁
 * @Author: guodong
 * @Date: 2019/9/22
 */
public class Singleton2 {

    public static Singleton2 getSingleton() {
        return Holder.singleton;
    }

    private static class Holder {
        private  static Singleton2 singleton = new Singleton2();
    }

}
