package importPack;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EXP {
	
	public static void main(String[] args) throws IOException {
		 XSSFWorkbook workbook=new XSSFWorkbook(); 
         XSSFSheet sheet=workbook.createSheet("sheet1"); 
           
         XSSFRow row=sheet.createRow(1); 
           
         // Background color 
         XSSFCellStyle style=workbook.createCellStyle(); 
         style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex()); 
         style.setFillPattern(FillPatternType.DIAMONDS); 
         style.setWrapText(true);
           
         XSSFCell cell=row.createCell(1); 
         cell.setCellValue("welcomehbjasjchjjchj"); 
         cell.setCellStyle(style);  
         
           
         // foreground color 
         style=workbook.createCellStyle(); 
         style.setFillForegroundColor(IndexedColors.YELLOW.getIndex()); 
         style.setFillPattern(FillPatternType.FINE_DOTS); 
           
         cell=row.createCell(2); 
         cell.setCellValue("Geeks"); 
         cell.setCellStyle(style);             
           
         FileOutputStream file = new FileOutputStream("/home/aniket/eclipse-workspace/SelldoQA/DataFile/site_visit_import_sample-d398357ba342eca62afad176f12fe3e0977bb1c4389aa664d1162ccfe203cc10 (2).xls"); 
         workbook.write(file); 
         file.close(); 
         System.out.println("Style Created");
	}
}
