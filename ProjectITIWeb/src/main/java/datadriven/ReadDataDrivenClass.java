package datadriven;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ReadDataDrivenClass {

    public Object [][] readData() throws InvalidFormatException, IOException {
        File myfile =new File(".\\testData\\cartcheckout.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(OPCPackage.open(myfile)); // XSSFWorkbook class to be able to work on Excel sheet
        XSSFSheet mysheet =wb.getSheet("Sheet1");
      //  DataFormatter formatter =new DataFormatter();

        int rowNo= mysheet.getPhysicalNumberOfRows();
        int columnsNo=mysheet.getRow(0).getLastCellNum();
       // Cell cell =mysheet.getRow(rowNo).getCell(columnsNo);

        String [][] myDataArray =new String[rowNo-1][columnsNo];

        //to add the data
        for (int i= 1; i<rowNo; i++){
            for (int a =0; a<columnsNo;a++){
                XSSFRow row =mysheet.getRow(i);
                myDataArray[i-1][a]=row.getCell(a).getStringCellValue();

            }
        }
        return myDataArray;
    }

}
