import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Date_Format {

	public static String getDate(int a,String str,String of) {

		System.out.println(  new SimpleDateFormat(str).format(new Date().getTime()+(a * (1000 * 60 * 60 * 24))));
		String s ="";
		switch (of) {
		case "D":s= new SimpleDateFormat("dd").format(new Date().getTime()+(a * (1000 * 60 * 60 * 24)));  break;
		case "M":s= new SimpleDateFormat("M").format(new Date().getTime()+(a * (1000 * 60 * 60 * 24)));break;
		case "Y":s= new SimpleDateFormat("YYYY").format(new Date().getTime()+(a * (1000 * 60 * 60 * 24)));break;

		default:System.out.println("please select valid input");
			break;
		}
		return s;
		
	}
	public static String getDate(int a,String of) {

		String s ="";
		switch (of) {
		case "D":s= new SimpleDateFormat("dd").format(new Date().getTime()+(a * (1000 * 60 * 60 * 24)));  break;
		case "M":s= new SimpleDateFormat("M").format(new Date().getTime()+(a * (1000 * 60 * 60 * 24)));break;
		case "Y":s= new SimpleDateFormat("YYYY").format(new Date().getTime()+(a * (1000 * 60 * 60 * 24)));break;

		default:System.out.println("please select valid input");
			break;
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(getDate(-1,"D"));
	}
}
