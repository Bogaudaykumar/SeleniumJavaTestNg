package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
public class ExcelReader {


    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle style;
    String path;

    public ExcelReader(String path)
    {
        this.path=path;
    }
    public Map<String, String> getKeyValuePair(String sheetName, String key) throws IOException {
        fi= new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);

        Map<String, String> keyValuePair = new HashMap<>();

        for (Row row : sheet) {
            Cell keyCell = row.getCell(0);
            if (keyCell != null && keyCell.getStringCellValue().equalsIgnoreCase(key)) {
                Cell valueCell = row.getCell(1);
                Cell locatorTypeCell = row.getCell(2);
                if (valueCell != null && locatorTypeCell != null) {
                    keyValuePair.put("value", valueCell.getStringCellValue());
                    keyValuePair.put("locatorType", locatorTypeCell.getStringCellValue());
                    break;
                }
            }
        }
        workbook.close();
        fi.close();
        return keyValuePair;
    }


}