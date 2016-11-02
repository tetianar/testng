package dataProvider;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Tetiana_Romaniv on 11/1/2016.
 */
public class ReaderXls {
    private InputStream input;
    private HSSFWorkbook workBook;

    public ReaderXls() {
        try {
            input = new FileInputStream("src\\test\\resources\\Data.xls");
            workBook = new HSSFWorkbook(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[][] parse(String nameSheet, boolean isLong) {
        Sheet sheet = workBook.getSheet(nameSheet);
        int rows = sheet.getPhysicalNumberOfRows();
        int column = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] result = new Object[rows][column];

        for (int i = 0; i < rows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < column; j++) {
                Cell cell = row.getCell(j);
                if (isLong) {
                    result[i][j] = (long) cell.getNumericCellValue();
                } else {
                    result[i][j] = cell.getNumericCellValue();
                }
            }
        }

            return result;
        }
    }




