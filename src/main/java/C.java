import java.util.HashMap;

/**
 * @Author: guodong
 * @Date: 2018/5/9
 */
public class C extends B {

    public static void main(String[] args) {
        B b = new C();
        HashMap<String, String> map = new HashMap<>();
        map.put("abc","adf");
        map.clone();
        C c = (C) b;
        c.bMethod();
        c.cMethod();
    }

    public void cMethod(){
        System.out.println("c method");
    }

}
