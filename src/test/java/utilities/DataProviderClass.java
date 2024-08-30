package utilities;

import org.testng.annotations.DataProvider;

import java.util.List;

public class DataProviderClass {
    private ExcelReader ExcelReader;

    @DataProvider(name = "LoginData", parallel = true)
    public Object[][] excelDataProvider() {
        String filePath = ".\\src\\test\\java\\testcases\\readData.xlsx";
        String sheetName = "login";
        List<Object[]> data = ExcelReader.getExcelData(filePath, sheetName);
        if (!data.isEmpty()) {
            return data.toArray(new Object[0][]);
        } else {
            throw new RuntimeException("No data found in Excel file.");
        }
    }
}

