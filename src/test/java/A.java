

public class A {
    public static void main(String[] args) {
        System.out.println(B.a);
    }
}


class B {
    public static String a = "123";
    static {
        System.out.print("ABC");
    }
}