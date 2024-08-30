package utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReader {

    public static List<Object[]> getExcelData(String filePath, String sheetName) {
        List<Object[]> data = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(".\\src\\test\\java\\testcases\\ReadData.xlsx");
             Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheet("login");
            int rowCount = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    List<Object> rowData = new ArrayList<>();
                    for (Cell cell : row) {
                        rowData.add(getCellValue(cell));
                    }
                    data.add(rowData.toArray());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    return cell.getNumericCellValue();
                }
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                switch (cell.getCachedFormulaResultType()) {
                    case STRING:
                        return cell.getStringCellValue();
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            return cell.getDateCellValue();
                        } else {
                            return cell.getNumericCellValue();
                        }
                    case BOOLEAN:
                        return cell.getBooleanCellValue();
                    default:
                        return "";
                }
            default:
                return "";
        }
    }
}