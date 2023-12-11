package A_Experiment;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.script.ScriptException;

public class aqw {
	
	protected static String getDate(long a, String of) {

		String s = "";
		switch (of) {
		case "D":
			s = new SimpleDateFormat("dd").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "M":
			s = new SimpleDateFormat("M").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "Y":
			s = new SimpleDateFormat("YYYY").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24 )));
			break;
		case "m":
			s = new SimpleDateFormat("mm").format(new Date().getTime() + (a * (1000 * 60 )));
			break;
		case "H":
			s = new SimpleDateFormat("hh").format(new Date().getTime() + (a * (1000 * 60 * 60 )));
			break;

		default:
			System.out.println("please select valid input");
			break;
		}
		return s;
	}

	public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
		
//		for (int i = 0; i < 50; i++) {
//			System.out.print((i)+") ");
//			System.out.print(getDate(i,"D")+" ");
//			System.out.print(getDate(i,"M")+" ");
//			System.out.println(getDate(i,"Y"));
//			
//		}
		System.out.println(getDate(-59,"M")+" "+getDate(-59,"D"));
//		System.out.println(getDate(2,"Y"));
//		System.out.println(1000 * 60 * 60 * 24);
		
	}
}
