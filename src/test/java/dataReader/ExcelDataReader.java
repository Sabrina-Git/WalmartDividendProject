package dataReader;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExcelDataReader {

    private static final Path WORKBOOK = Paths.get(
            System.getProperty("user.dir"), "src", "test", "ExternalFiles", "LoginData.xlsx");

    private static final String DEFAULT_SHEET = "Sheet1";

    private static final DataFormatter FORMATTER = new DataFormatter();

    private ExcelDataReader() {
    }

    /**
     * Reads every row of the sheet that actually holds data, cell values trimmed.
     * <p>
     * Rows that look empty in Excel but still exist in the file because they carry
     * leftover formatting (LoginData.xlsx has two of them, at rows 5 and 15) are
     * skipped. That is why {@code getPhysicalNumberOfRows()} is not used here: it
     * counts row records rather than rows with content, and it also skips gaps, so
     * it can never be trusted as a loop bound.
     */
    public static List<List<String>> readSheet(String sheetName) throws IOException {
        try (FileInputStream fis = new FileInputStream(WORKBOOK.toFile());
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException(
                        "Sheet '" + sheetName + "' not found in " + WORKBOOK);
            }

            List<List<String>> rows = new ArrayList<>();
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                List<String> values = readRow(sheet.getRow(i));
                if (!values.isEmpty()) {
                    rows.add(values);
                }
            }
            return rows;
        }
    }

    public static List<List<String>> readSheet() throws IOException {
        return readSheet(DEFAULT_SHEET);
    }

    /**
     * @return the row's trimmed cell values, or an empty list if the row is null or
     *         every cell is blank.
     */
    private static List<String> readRow(Row row) {
        if (row == null) {
            return Collections.emptyList();
        }

        List<String> values = new ArrayList<>();
        boolean hasContent = false;
        for (int c = 0; c < row.getLastCellNum(); c++) {
            // DataFormatter renders numbers and dates the way Excel shows them and
            // returns "" for a null cell, so numeric cells cannot blow up here the
            // way getStringCellValue() would.
            String value = FORMATTER.formatCellValue(
                    row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL)).trim();
            hasContent |= !value.isEmpty();
            values.add(value);
        }
        return hasContent ? values : Collections.<String>emptyList();
    }

    public static int getRowCount() throws IOException {
        return readSheet().size();
    }

    public static int getColumnCount() throws IOException {
        List<List<String>> rows = readSheet();
        return rows.isEmpty() ? 0 : rows.get(0).size();
    }

    /**
     * @param rowNum  0-based index among the non-blank rows (0 is the header row)
     * @param cellNum 0-based column index
     */
    public static String getData(int rowNum, int cellNum) throws IOException {
        List<List<String>> rows = readSheet();

        if (rowNum < 0 || rowNum >= rows.size()) {
            throw new IllegalArgumentException(
                    "Row " + rowNum + " is out of range; the sheet has " + rows.size() + " rows");
        }
        List<String> row = rows.get(rowNum);

        if (cellNum < 0 || cellNum >= row.size()) {
            throw new IllegalArgumentException(
                    "Column " + cellNum + " is out of range; row " + rowNum
                            + " has " + row.size() + " columns");
        }
        return row.get(cellNum);
    }

//------------------------------------------------------------------------
    public static String getData1(int row, int column) throws IOException {

        String path = System.getProperty("user.dir")
                + "/src/test/ExternalFiles/LoginData.xlsx";

        try (FileInputStream file = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            return new DataFormatter().formatCellValue(
                    workbook.getSheet("Sheet1")
                            .getRow(row)
                            .getCell(column)
            );
        }
    }


//-------------------------------------------------------------


    public static void main(String[] args) throws IOException {
//        List<List<String>> rows = readSheet();
//        System.out.println("rows: " + rows.size());
//        System.out.println("columns: " + getColumnCount());
//        rows.forEach(System.out::println);
        System.out.println(getData(0,0));
    }
}
