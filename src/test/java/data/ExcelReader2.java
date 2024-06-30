package data;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader2 {

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
        // Get the sheet named "Register" from the workbook
        XSSFSheet sheet = wb.getSheet("Register");

        // Initialize a list to hold non-empty rows of data
        List<String[]> data = new ArrayList<>();

        // Get the total number of rows in the sheet (including the header)
        int totalNumberOfRows = sheet.getLastRowNum() + 1; // Add 1 because getLastRowNum() is zero-based

        // Get the first row (assuming it's the header row) to determine the total number of columns
        XSSFRow headerRow = sheet.getRow(0);
        if (headerRow == null) {
            throw new IOException("Header row is missing in the Excel sheet.");
        }
        int totalNumberOfCols = headerRow.getLastCellNum(); // getLastCellNum() returns the count of columns

        // Loop through the rows, starting from the second row (index 1) to skip the header
        for (int r = 1; r < totalNumberOfRows; r++) {
            // Get the current row
            XSSFRow row = sheet.getRow(r);
            if (row == null) {
                continue; // Skip if the row is null
            }

            // Initialize an array to hold cell values for the current row
            String[] rowData = new String[totalNumberOfCols];
            boolean rowIsEmpty = true;

            // Loop through the columns
            for (int c = 0; c < totalNumberOfCols; c++) {
                XSSFCell cell = row.getCell(c);
                if (cell == null) {
                    rowData[c] = ""; // Handle empty cells
                } else {
                    // Get the cell value and store it in the array
                    rowData[c] = cell.toString();
                    if (!cell.toString().isEmpty()) {
                        rowIsEmpty = false; // Mark row as non-empty if any cell has a value
                    }
                }
            }

            // Add the row data to the list if the row is not empty
            if (!rowIsEmpty) {
                data.add(rowData);
            }
        }

        // Convert the list to a 2D array
        String[][] arrayExcelData = new String[data.size()][totalNumberOfCols];
        for (int i = 0; i < data.size(); i++) {
            arrayExcelData[i] = data.get(i);
        }

        // Close the workbook and file input stream to free up resources
        wb.close();
        fis.close();
        // Return the data array
        return arrayExcelData;
    }
}
