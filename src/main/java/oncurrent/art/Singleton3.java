package oncurrent.art;

/**
 * 预加载
 * @Author: guodong
 * @Date: 2019/9/22
 */
public class Singleton3 {

    private final static Singleton3 singleton = new Singleton3();

    public static Singleton3 getSingleton(){
        return singleton;
    }

    private Singleton3(){
    }

}
