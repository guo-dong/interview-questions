package test;

import java.io.*;

/**
 * @Author: guodong
 * @Date: 2019/2/25
 */
public class SqlFormat {

    private static final String FROM_FILE_NAME = "C:\\Users\\guodong\\Desktop\\sql.sql";
    private static final String TO_FILE_NAME = "C:\\Users\\guodong\\Desktop\\sql_update.sql";

    public static void main(String[] args) throws IOException {
        insertPerXFormat(1000);

    }

    public static void insertPerXFormat(final int perLine)  throws IOException {
        int groupCount = 0;
        int count = 0;
        String str;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FROM_FILE_NAME))) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(TO_FILE_NAME))) {
                bufferedWriter.write("delete from CARDNO_20181224;");
                bufferedWriter.newLine();
                bufferedWriter.write("commit;");
                bufferedWriter.newLine();
                bufferedWriter.newLine();
                while ((str = bufferedReader.readLine()) != null) {
                    if (count % perLine == 0 ) {
                        bufferedWriter.write("insert  all");
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(str);
                    bufferedWriter.newLine();
                    count++;
                    if (count % perLine == 0 ) {
                        bufferedWriter.newLine();
                        bufferedWriter.write("select 1 from dual;");
                        bufferedWriter.newLine();
                        bufferedWriter.write("commit;");
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        groupCount++;
                    }

                }

                if (count % perLine != 0) {
                    bufferedWriter.write("select 1 from dual;");
                    bufferedWriter.newLine();
                    bufferedWriter.write("commit;");
                    bufferedWriter.newLine();
                }
                bufferedWriter.newLine();
                bufferedWriter.write("update CARDNO_20181224 set cardno2=f_encrypt(cardno2);");
                bufferedWriter.newLine();
                bufferedWriter.write("commit;");
                bufferedWriter.newLine();
                bufferedWriter.newLine();
                bufferedWriter.write("update T_PAY_EXPPAYAGR_N n set status=8 where n.acquirerusrno in (select cardno2 from CARDNO_20181224 ) and status =1;");
                bufferedWriter.newLine();
                bufferedWriter.write("commit;");
                bufferedWriter.newLine();

            }
        }
        System.out.println(count);
        System.out.println(groupCount);
    }

}
