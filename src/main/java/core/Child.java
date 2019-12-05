package core;

/**
 * @Author: guodong
 * @Date: 2019/9/6
 */
public class Child extends Parent {

    private int b;
    private static int bb = 100;

    static {
        System.out.println("子类代码块" + bb);
    }

    public Child() {
        this(12);
        System.out.println("执行子类构造函数" + b);
    }

    public Child(int b) {
        this.b = b;
        System.out.println("子类带参构造函数" + b);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("子类函数");
    }

}
