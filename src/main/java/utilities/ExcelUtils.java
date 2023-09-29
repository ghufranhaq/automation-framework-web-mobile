package utilities;

import config.DataConfig;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    public static List<Object[]> getTestData(String sheetName) {
        List<Object[]> data = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(DataConfig.EXCEL_FILE_PATH);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Object[] rowData = new Object[row.getLastCellNum()];
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    rowData[j] = cell.getStringCellValue();
                }
                data.add(rowData);
            }

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
