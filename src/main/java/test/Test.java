package test;

import java.io.*;

/**
 * @Author: guodong
 * @Date: 2019/2/25
 */
public class Test {

    private static final String FROM_FILE_NAME = "C:\\Users\\guodong\\Desktop\\贵银联换签失败.txt";
    private static final String TO_FILE_NAME = "C:\\Users\\guodong\\Desktop\\2.txt";

    public static void main(String[] args) throws IOException {
        insertPerXFormat(1000);

    }

    public static void insertPerXFormat(final int perLine)  throws IOException {
        int groupCount = 0;
        int count = 0;
        String str;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FROM_FILE_NAME))) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(TO_FILE_NAME))) {
                while ((str = bufferedReader.readLine()) != null) {
                    String[] ss = str.split("\\|");
                    bufferedWriter.write("\""+ss[2]+"\",");
                    bufferedWriter.newLine();
                }



            }
        }
        System.out.println(count);
        System.out.println(groupCount);
    }

}
