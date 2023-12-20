package A_Experiment;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
		



		System.out.println("Add numers");
		Scanner sc = new Scanner(System.in);

		long userName = sc.nextLong();

		long countDigit = userName;

		int countNumberOfDigit = 0;
		while (countDigit != 0) {
			countNumberOfDigit++;
			countDigit /= 10;
		}

		System.out.println(countNumberOfDigit);
	
	
		System.out.println("sdhckdsjc");
	}
}
