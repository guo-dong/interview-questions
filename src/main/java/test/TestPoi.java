package test;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: guodong
 * @Date: 2019/3/1
 */
public class TestPoi {

    public static void main(String[] args) throws IOException {


//        traverseSheet("C:\\Users\\guodong\\Desktop\\20190228115320613_36_2.xls");
        System.out.println("======================================================================");
        System.out.println();
        traverseSheet("C:\\Users\\guodong\\Desktop\\20190228115320613_36_2 - 副本.xls");


    }

    private static void traverseSheet(String filePath ) throws IOException {
        FileInputStream stream = new FileInputStream(filePath);
        HSSFWorkbook workbook = new HSSFWorkbook(stream);//读取现有的Excel
        HSSFSheet sheet= workbook.getSheet("模板");//得到指定名称的Sheet
        for (Row row : sheet)
        {
            for (Cell cell : row)
            {

//                DataFormatter formatter = new DataFormatter();
                cell.setCellType(CellType.STRING);
//                System.out.print(cell +"("+ NumberFormat.getInstance().format(cell.getNumericCellValue())+")" + "\t" );
                System.out.print(cell  + "\t" );
//                System.out.print(cell +"("+ formatter.formatCellValue(cell)+")" + "\t" );


            }
            System.out.println();
        }
    }


}
