package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    // Method to get the FileInputStream for the Excel file
    private FileInputStream getFileInputStream() throws FileNotFoundException {
        // Construct the file path to the Excel file
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/UserData.xlsx";
        // Create a File object representing the Excel file
        File srcFile = new File(filePath);
        // Initialize the FileInputStream with the File object
        return new FileInputStream(srcFile);
    }

    // Method to read data from the Excel file and return it as a 2D array
    public Object[][] getExcelData() throws IOException {
        // Get the FileInputStream for the Excel file
        FileInputStream fis = getFileInputStream();
        // Create an XSSFWorkbook object to represent the workbook
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        // Get the sheet named "Login" from the workbook
        XSSFSheet sheet = wb.getSheet("Login");

        // Get the total number of rows in the sheet (including the header)
        int totalNumberOfRows = sheet.getLastRowNum() + 1; // Add 1 because getLastRowNum() is zero-based
        // Define the total number of columns (assuming 2 for this example)
        int totalNumberOfCols = 2;
        // Initialize a 2D array to hold the Excel data (excluding the header row)
        String[][] arrayExcelData = new String[totalNumberOfRows - 1][totalNumberOfCols]; // Exclude header row

        // Loop through the rows, starting from the second row (index 1) to skip the header
        for (int i = 1; i < totalNumberOfRows; i++) {
            // Loop through the columns
            for (int j = 0; j < totalNumberOfCols; j++) {
                // Get the current row
                XSSFRow row = sheet.getRow(i);
                // Get the cell value and store it in the array (adjusting the index to exclude the header)
                arrayExcelData[i - 1][j] = row.getCell(j).toString(); // Adjust index to exclude header
            }
        }

        // Close the workbook and file input stream to free up resources
        wb.close();
        fis.close();
        // Return the data array
        return arrayExcelData;
    }
}
