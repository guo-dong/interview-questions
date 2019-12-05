package test;

/**
 * @Author: guodong
 * @Date: 2019/4/7
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverse("abc"));
        StringBuffer abc = new StringBuffer("abc");
        System.out.println(abc);
        System.out.println(abc.reverse());
        System.out.println(abc);
    }


    public static String reverse(String source) {

        if (source == null || source.isEmpty()) {
            return source;
        }
        char[] chars = new char[source.length()];
        for (int i = source.length()-1,j=0; i >=0; i--,j++) {
            chars[j] = source.charAt(i);
        }
        return String.valueOf(chars);
    }



}
