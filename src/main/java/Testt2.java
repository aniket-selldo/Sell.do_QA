import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import com.selldo.Utility.XLUtilsHSSF;

public class Testt2

{
	public static void m() throws IOException {
		String fileName="acasacca";

		String fielPath = System.getProperty("user.dir") + "/DataFile/" + fileName + ".xls";
		try {
			File myObj = new File(fielPath);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		XLUtilsHSSF xl = new XLUtilsHSSF(fielPath);	
		xl.setCellData("Sheet1", 0, 0, fielPath);
	}
	
		public static void aa() throws IOException {
			try (Workbook wb = new HSSFWorkbook()) {
		      //Add two sheets into the workbook
			String fielPath = System.getProperty("user.dir") + "/DataFile/" + "asdasssssd" + ".xls";
		      wb.createSheet("My Excel Sheet 1");
		      wb.createSheet("My Excel Sheet 2");
		      //Save the workbook to a file
		      try (OutputStream fileOut = Files.newOutputStream(new File(fielPath).toPath())) {
		        wb.write(fileOut);
		      }
		    }}

	public static void main(String[] args) throws ConfigurationException, IOException {
		
		aa();
		
		
	}
}
