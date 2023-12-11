import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;
import com.selldo.Utility.XLUtilsHSSF;

public class xl {
	enum Date_formatter {
		Full_Date("TodaysDate1"), Full_Date_Short("TodaysDate"), Month_int("M"), Month_short_String("M2"),
		Month_full_String("M3"), Day("D"), Year_Short("Y"), Year_Full("Y1"), Minute("m"), Hour("H"), AMPM("AMPM"),
		Week_Short_String("Week"), Week_Full_String("Week1");

		private final String dates;

		Date_formatter(String dates) {
			this.dates = dates;
		}

		public String getDates() {
			return dates;
		}
	}

	protected static String getDate(long a, Date_formatter of) {

		String s = "";
		switch (of.getDates()) {
		case "D":
			s = new SimpleDateFormat("dd").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "M":
			s = new SimpleDateFormat("M").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;// integer month
		case "M2":
			s = new SimpleDateFormat("MMM").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;// half month name
		case "M3":
			s = new SimpleDateFormat("MMMM").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;// Full month name
		case "Y":
			s = new SimpleDateFormat("YY").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "Y1":
			s = new SimpleDateFormat("YYYY").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "m":
			s = new SimpleDateFormat("mm").format(new Date().getTime() + (a * (1000 * 60)));
			break;
		case "H":
			s = new SimpleDateFormat("hh").format(new Date().getTime() + (a * (1000 * 60 * 60)));
			break;
		case "Week":
			s = new SimpleDateFormat("EEE").format(new Date().getTime() + (a * (1000 * 60 * 60)));
			break;
		case "Week1":
			s = new SimpleDateFormat("EEEE").format(new Date().getTime() + (a * (1000 * 60 * 60)));
			break;
		case "AMPM":
			s = new SimpleDateFormat("a").format(new Date().getTime() + (a * (1000 * 60 * 60)));
			break;
		case "TodaysDate":
			s = new SimpleDateFormat("dd/M/YY").format(new Date().getTime() + (a * (1000 * 60 * 60)));
			break;
		case "TodaysDate1":
			s = new SimpleDateFormat("dd/M/YYYY").format(new Date().getTime() + (a * (1000 * 60 * 60)));
			break;
		default:
			System.out.println("please select valid input");
			break;
		}
		return s;
	}

	public static String Random(String type, int size) {
		String Return = "";
		switch (type) {
		case "AN":
			Return = RandomStringUtils.randomAlphanumeric(size);
			break;// pX4Mv3KsJU
		case "A":
			Return = RandomStringUtils.randomAlphabetic(size);
			break;// ZLTRqGyuXk
		case "R":
			Return = RandomStringUtils.random(size);
			break;// 嚰险걻鯨贚䵧縓
		case "N":
			Return = randomNumber(size);
			break;// 3511779161
		default:
			break;
		}
		return Return;
	}

	public static String randomNumber(int val) {
		String st = "";
		for (int i = 0; i < val; i++) {
			st = st + getRandomNumber(1, 9);
		}
		return st;
	}

	protected String R(char... arr) {
		return RandomStringUtils.random(1, arr);
	}

	public String randomPhone() {
		return " " + R('7', '8', '9') + Random("N", 9);
	}

	public static String randomEmail() {
		String emaill = "aniket.khandizod@sell.do";
		String email[] = emaill.split("@");
		String name = email[0];
		String domain = email[1];
		return name + "+" + Random("AN", 10) + "@" + domain;
	}
	public static String createNewXLFile(String fileName) {
		String fielPath=System.getProperty("user.dir") + "/DataFile/"+fileName+".xls";
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
	return fielPath;
	}
	public static void CreateHeader(XLUtilsHSSF xl) throws IOException {
		int header =0;
		int i =0;
		//xl.fillGreenColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"First Name");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Last Name");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Primary Phone");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Primary Email");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Minimum possesion");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Maximum possesion");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Minimum budget");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Maximum budget");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Property types");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Locations");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"BHK");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Note");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Age");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Birthday");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Anniversary");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Industry");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Educational Details");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Professional Details");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Income");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Loan Details");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Address");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"State");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"City");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Country");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Status in Given Stage");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Lead Stages");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Stage Change Reasons");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Purpose");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Furnishing");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Facing");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Nri");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Transaction Type");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Funding Source");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Bathroom Preferences");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Married");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Manual Tags");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Gender");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Zip");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Street");
		//xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++,"Area");
		//xl.fillYellowColor("Sheet1",i,header);
	}

	public static void leadImport() throws IOException {

		XLUtilsHSSF xl = new XLUtilsHSSF(createNewXLFile("new Lead Import"));
		xl lx = new xl();
		Faker fk = new Faker();
		CreateHeader(xl);
		for (int i = 1; i < 100; i++) {
			int row = 0;
			// First Name
			xl.setCellData("Sheet1", i, row++, "" + "LeadBy");
			// Last Name
			xl.setCellData("Sheet1", i, row++, "" + "Import");
			// Phone Number
			xl.setCellData("Sheet1", i, row++, "" + "+91 " + lx.randomPhone());
			// Email
			xl.setCellData("Sheet1", i, row++, randomEmail());
			// Minimum possesion
			xl.setCellData("Sheet1", i, row++, "1");
			// Maximum possesion
			xl.setCellData("Sheet1", i, row++, "12");
			// Minimum budget
			xl.setCellData("Sheet1", i, row++, Random("N", 5));
			// Maximum budget
			xl.setCellData("Sheet1", i, row++, Random("N", 10));
			// Property types
			String PropertyType[] = { "studio", "villa", "apartment", "penthouse", "bunglow", "cottage", "duplex",
					"plot", "shop", "office", "row_house", "town_house", "extra", "all", };
			xl.setCellData("Sheet1", i, row++, PropertyType[getRandomNumber(0, PropertyType.length - 1)]);
			// Locations
			xl.setCellData("Sheet1", i, row++, Random("A", 10));
			// BHK
			String BHK[] = { "1 BHK", "2 BHK", "3 BHK", "4 BHK", "5 BHK", "6 BHK", "7 BHK" };
			xl.setCellData("Sheet1", i, row++, BHK[getRandomNumber(0, BHK.length - 1)]);
			// Note
			xl.setCellData("Sheet1", i, row++, fk.sentence());
			// Age
			xl.setCellData("Sheet1", i, row++, Random("N", 2));
			// Birthday
			xl.setCellData("Sheet1", i, row++, getDate(-1000, Date_formatter.Full_Date_Short));
			// Anniversary
			xl.setCellData("Sheet1", i, row++, getDate(-100, Date_formatter.Full_Date_Short));
			//Industry
			xl.setCellData("Sheet1", i, row++, fk.name());
			// Educational Details
			String [] educationDetails= {"school","graduation","post graduation","other"};
			xl.setCellData("Sheet1", i, row++, fk.firstName()+","+fk.firstName()+","+educationDetails[getRandomNumber(0,educationDetails.length-1)]);
			//Professional Details
			xl.setCellData("Sheet1", i, row++, fk.firstName()+","+fk.firstName()+","+fk.firstName());
			// INCOME Details
			String [] INCOMEDetails= {"personal","family"};
			xl.setCellData("Sheet1", i, row++, fk.firstName()+","+fk.firstName()+","+INCOMEDetails[getRandomNumber(0,INCOMEDetails.length-1)]);
			// Loan Details
			String [] LoanDetails= {"home loan","car loan","personal loan","education loan"};
			xl.setCellData("Sheet1", i, row++, Random("N",9)+","+fk.firstName()+","+LoanDetails[getRandomNumber(0,LoanDetails.length-1)]);
			// Address
			xl.setCellData("Sheet1", i, row++,fk.streetAddress(true));
			//State
			xl.setCellData("Sheet1", i, row++,"Goa");
			// City
			xl.setCellData("Sheet1", i, row++,"Panaji");
			// Country
			xl.setCellData("Sheet1", i, row++,"India");
			// Status in Given Stage
			xl.setCellData("Sheet1", i, row++,"");
			// Lead Stages
			xl.setCellData("Sheet1", i, row++,"Incoming");
			// Stage Change Reasons
			xl.setCellData("Sheet1", i, row++,"");
			// Purpose
			xl.setCellData("Sheet1", i, row++,"end_use");
			// Furnishing
			xl.setCellData("Sheet1", i, row++,"Furnished, Semi-Furnished");
			// Facing
			xl.setCellData("Sheet1", i, row++,"North,East");
			// Nri
			xl.setCellData("Sheet1", i, row++,"No");
			// Transaction Type
			xl.setCellData("Sheet1", i, row++,"lease");
			// Funding Source
			xl.setCellData("Sheet1", i, row++,"self");
			// Bathroom Preferences
			xl.setCellData("Sheet1", i, row++,"2,4");
			// Married 	
			xl.setCellData("Sheet1", i, row++,"Yes");
			// Manual Tags
			xl.setCellData("Sheet1", i, row++,fk.name());
			// Gender
			xl.setCellData("Sheet1", i, row++,"Male");
			// Zip
			xl.setCellData("Sheet1", i, row++,Random("N",6));
			// Street
			xl.setCellData("Sheet1", i, row++,fk.streetName());
			// Area
			xl.setCellData("Sheet1", i, row++,"12");
			
			System.out.println("Row " + i + " updated done");
		}
		System.out.println("<<<<<<Done>>>>>>");

	}

	public static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	public static void main(String[] args) throws IOException {
		 leadImport() ;
	}
}
