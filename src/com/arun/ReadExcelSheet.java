package com.arun;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheet {

	public static void main(String[] args) {
		try {
			File file = new File("E://AM_COM/ReadExcel/src/sample.xlsx");
			FileInputStream fis = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fis);

			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				for (int count = 0; count < row.getLastCellNum(); count++) {
					Cell cell = row.getCell(count, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
							cell.setCellType(Cell.CELL_TYPE_STRING);
						}
						System.out.print(cell.getStringCellValue() + "\t");
					}
				}
				System.out.println();
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}