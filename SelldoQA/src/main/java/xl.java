import java.io.IOException;

import com.selldo.Utility.XLUtils;

public class xl {

	public static void main(String[] args) throws IOException {

		XLUtils xl=new XLUtils("/home/aniket/Downloads/SMS and Email variables list (1) (1).xlsx");
		//xl.getRowCount("sheet1");
		System.out.println(xl.getRowCount("Table 1"));
		
		for (int i = 1; i < xl.getRowCount("Table 1"); i++) {
			
			System.out.print(xl.getCellData("Table 1", i, 1)+" -> ");
			System.out.println("{{"+xl.getCellData("Table 1", i, 2)+"}}");

		}
	
	}

}
