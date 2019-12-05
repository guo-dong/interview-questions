package core;

/**
 * @Author: guodong
 * @Date: 2019/9/6
 */
public class Parent {

    private int a;
    private static int aa = 88;

    static {
        System.out.println("父类代码块" + aa);
    }

    public Parent() {
        this(11);
        System.out.println("父类构造函数" + a);
    }

    public Parent(int a) {
        this.a = a;
        System.out.println("父类带参构造函数" + a);
    }

    public void print() {
        System.out.println("父类函数");
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

}
