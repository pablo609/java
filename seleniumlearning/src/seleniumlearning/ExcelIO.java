package seleniumlearning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelIO {
	@Test
	public void readExcelFile() throws Exception {
		File theFile = new File("C:\\Users\\pawel\\Downloads\\Finanse Myszy z Klotem1.xlsx");
		FileInputStream theFileStream = null;
		
		try {
			theFileStream = new FileInputStream(theFile);
		}
		catch(FileNotFoundException e) {
			System.out.println("File not Found!\n" + e.toString());
			throw e;
		}
		
		Workbook theWorkbook = new XSSFWorkbook(theFileStream);
		
		for(int i = 0; i < theWorkbook.getNumberOfSheets(); ++i) {
			Sheet theSheet = theWorkbook.getSheetAt(i);
			System.out.println("Sheet: " + theSheet.getSheetName());
			int rows = theSheet.getLastRowNum() - theSheet.getFirstRowNum();
			for(int j = 0; j < rows; ++j) {
				Row theRow = theSheet.getRow(j);
				String theText = theRow.getCell(0).toString();
				if(!theText.isEmpty())
					System.out.println(theText);
			}
		}
		
		theWorkbook.close();
		theFileStream.close();
	}
}
