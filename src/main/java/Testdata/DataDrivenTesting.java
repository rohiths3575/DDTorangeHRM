package Testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataDrivenTesting {

	
	XSSFWorkbook wb;
@DataProvider(name = "excelfile")

	public Object[][] Exceldata() {
		File f1=new File(System.getProperty("user.dir")+"//testdata//data.xlsx");
		FileInputStream fs;
		Object data[][] = null;
		try {
			fs = new FileInputStream(f1);
			wb=new XSSFWorkbook(fs);
			
			XSSFSheet sheet=wb.getSheet("Userdata");
			int rows=sheet.getPhysicalNumberOfRows();
			int col=sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println(rows+""+""+col);
			data =new Object[rows-1][col];
			for(int i=1;i<rows;i++)
			{
				for(int j=0;j<col;j++)
				{
					data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(data[i-1][j]);
				}
//				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return data;
	}
}
