import java.util.HashMap;

/**
 * @Author: guodong
 * @Date: 2018/5/8
 */
public class NumberTest {


    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap();
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 = new String("hello");
        System.out.println(s1==s2);
        System.out.println(s3==s2);


       /*
        System.out.println(Float.MIN_VALUE);
        System.out.println(-Float.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Double.MIN_VALUE);

        //a = a + b 与 a += b 的区别(答案)
        byte a = 127;
        byte b = 127;

//        b = a+b;
        b+=a;
        System.out.println(b);
        System.out.println(3*0.1f==0.3f);
        System.out.println(3*0.1);
        double d = 0.1;
        System.out.println(d);
        float f =  1;
        System.out.println(f);
        System.out.println(0.1d*3);
        double d1 = 0.1;
        System.out.println(d1);
        double s = 0.1*3;
        System.out.println(s);
        */
    }

}
