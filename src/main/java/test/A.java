package test;

/**
 * @Author: guodong
 * @Date: 2019/6/26
 */


public class A {
    public static void main(String[] args) {
        System.out.println(B.s);
    }
}


class B {

    public static final String s = new String("123");

    static {
        System.out.print("ABC");
    }


}
