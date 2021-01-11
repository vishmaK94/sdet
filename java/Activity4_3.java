package session4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;*/

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Activity4_3 {

	private static String FILE_NAME = "resources/TestSheet.xlsx";
	
	public static void main(String[] args) throws IOException {
		
		File excelFile = new File(FILE_NAME);
		excelFile.createNewFile();
		
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheetName = workBook.createSheet("VII Markseet");
		
		Object[][] studentMarks = {
				{"Name", "Math", "Physics", "Chemistry"},
				{"John", 71, 53, 89},
				{"Jenny", 88, 45, 55},
				{"Mark", 48, 24, 54}
		};
		
		int rowNum = 0;
		for(Object[] rows : studentMarks) {
			Row row = sheetName.createRow(rowNum);
			int colNum = 0;
			for(Object colVal : rows) {
				Cell cell = row.createCell(colNum);
				
				if(colVal instanceof String) {
					cell.setCellValue((String)colVal);
				} else if(colVal instanceof Integer) {
					cell.setCellValue((Integer)colVal);
				}				
				colNum++;
			}			
			rowNum++;
		}
		
		try {
			
			FileOutputStream output = new FileOutputStream(FILE_NAME);
			workBook.write(output);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Execution complete!");
		}

	}

}
