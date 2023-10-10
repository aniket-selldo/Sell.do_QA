import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class testt {
	
	public static void m1() {
		File htmlFile = new File("/home/aniket/eclipse-workspace/SelldoQA/reports/AutomationReport.html");
		try {
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		double arr[] = { 2880.0, 20.0, 20.0, 4800.0, 50.0, 1224000000.0, 66000.0, 1452.0, 92.4, 277.20000000000005,
				11520.0, 1000.0, 1500.0 };
		double sum = 0.0;
		
		
		
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		System.out.println("Sum of all the elements of an array: " + sum);
		System.out.println("1) " + BigDecimal.valueOf(sum).toPlainString());
	
	}
}

