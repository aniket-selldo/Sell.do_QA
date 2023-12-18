package importPack;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import com.selldo.Utility.XLUtilsHSSF;

public class XL_Utils {

	public String prop(String propee) {
		Configurations configs = new Configurations();
		Configuration config = null;
		try {
			config = configs.properties(new File(System.getProperty("user.dir") + "/config.properties"));
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		if (propee.equalsIgnoreCase("Email")) {
			List<String> ls = new ArrayList<>();
			ls.add("aniket.khandizod@sell.do");
			ls.add("prerana.hotkar@sell.do");
			ls.add("hakim.rangwala@sell.do");
			ls.add("sagar.shejal@sell.do");
			ls.add("shyam.pandav@sell.do");
			ls.add("parth.bharadiya@sell.do");
			String systemName = System.getProperty("user.name");
			String value = ls.stream().filter(S -> S.startsWith(systemName.substring(0, 5))).findFirst().get();
			config.setProperty("Email", value);
		}
		return config.getString(propee);
	}

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

	protected String getDate(long a, Date_formatter of) {

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

	public String Random(String type, int size) {
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

	public String randomNumber(int val) {
		String st = "";
		for (int i = 0; i < val; i++) {
			st = st + getRandomNumber(1, 9);
		}
		return st;
	}

	public String R(char... arr) {
		return RandomStringUtils.random(1, arr);
	}

	public String randomPhone() {
		return "" + R('7', '8', '9') + Random("N", 9);
	}

	public String randomEmail() {
		String emaill = prop("Email");
		String email[] = emaill.split("@");
		String name = email[0];
		String domain = email[1];
		return name + "+" + Random("AN", 10) + "@" + domain;
	}

	public int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	public String createNewXLFile(String fileFor) throws IOException {
		String fielPath = null;
		try (Workbook wb = new HSSFWorkbook()) {
			// Add two sheets into the workbook
			fielPath = System.getProperty("user.dir") + "/ImportJunk/" + fileFor + " " + Random("A", 10) + ".xls";
			wb.createSheet("Sheet1");
			// Save the workbook to a file
			try (OutputStream fileOut = Files.newOutputStream(new File(fielPath).toPath())) {
				wb.write(fileOut);
			}
		}
		return fielPath;
	}

	public void CreateHeaderForLeadImport(XLUtilsHSSF xl) throws IOException {
		int header = 0;
		int i = 0;
		// xl.fillGreenColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "First Name");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Last Name");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Primary Phone");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Primary Email");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Minimum possesion");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Maximum possesion");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Minimum budget");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Maximum budget");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Property types");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Locations");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "BHK");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Note");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Age");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Birthday");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Anniversary");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Industry");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Educational Details");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Professional Details");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Income");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Loan Details");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Address");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "State");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "City");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Country");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Status in Given Stage");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Lead Stages");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Stage Change Reasons");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Purpose");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Furnishing");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Facing");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Nri");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Transaction Type");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Funding Source");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Bathroom Preferences");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Married");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Manual Tags");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Gender");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Zip");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Street");
		// xl.fillYellowColor("Sheet1",i,header);
		xl.setCellData("Sheet1", i, header++, "Area");
		// xl.fillYellowColor("Sheet1",i,header);
	}

	public void createHeaderForFolloupImport(XLUtilsHSSF xl, String foruse) throws IOException {
		int header = 0;
		int i = 0;
		if (foruse.equalsIgnoreCase("Full")) {
			xl.setCellData("Sheet1", i, header++, "Lead_crm_id");
			xl.setCellData("Sheet1", i, header++, "Lead Email");
			xl.setCellData("Sheet1", i, header++, "Lead Phone");
			xl.setCellData("Sheet1", i, header++, "Sales ID");
			xl.setCellData("Sheet1", i, header++, "Scheduled on");
			xl.setCellData("Sheet1", i, header++, "Subject");
			xl.setCellData("Sheet1", i, header++, "Followup Type");
			xl.setCellData("Sheet1", i, header++, "Project Ids");
			xl.setCellData("Sheet1", i, header++, "Agenda");
			xl.setCellData("Sheet1", i, header++, "Followup Status");
			xl.setCellData("Sheet1", i, header++, "Acted On");
			xl.setCellData("Sheet1", i, header++, "Cancellation Reason");
			System.out.println("Header updated for " + foruse);
		} else if (foruse.equalsIgnoreCase("Schedule")) {
			xl.setCellData("Sheet1", i, header++, "Lead_crm_id");
			xl.setCellData("Sheet1", i, header++, "Scheduled on");
			xl.setCellData("Sheet1", i, header++, "Subject");
			xl.setCellData("Sheet1", i, header++, "Followup Type");
			xl.setCellData("Sheet1", i, header++, "Agenda");
			xl.setCellData("Sheet1", i, header++, "Followup Status");
			System.out.println("Header updated for " + foruse);

		} else if (foruse.equalsIgnoreCase("Conducted")) {

		}
	}

	public void createHeaderForSiteVisitImport(XLUtilsHSSF xl) throws IOException {
		int header = 0;
		int i = 0;
		// Lead_crm_id
		xl.setCellData("Sheet1", i, header++, "Lead_crm_id");
		// Lead Email
		xl.setCellData("Sheet1", i, header++, "Lead Email");
		// Lead Phone
		xl.setCellData("Sheet1", i, header++, "Lead Phone");
		// Sales ID
		xl.setCellData("Sheet1", i, header++, "Sales ID");
		// Project Ids
		xl.setCellData("Sheet1", i, header++, "Project Ids");
		// Scheduled on
		xl.setCellData("Sheet1", i, header++, "Scheduled on");
		// Ends on
		xl.setCellData("Sheet1", i, header++, "Ends on");
		// Agenda
		xl.setCellData("Sheet1", i, header++, "Agenda");
		// Sitevisit status
		xl.setCellData("Sheet1", i, header++, "Sitevisit status");
		// conducted on
		xl.setCellData("Sheet1", i, header++, "conducted on");
		// Notes
		xl.setCellData("Sheet1", i, header++, "Notes");
		// pickup
		xl.setCellData("Sheet1", i, header++, "pickup");
		// pickup location
		xl.setCellData("Sheet1", i, header++, "pickup location");
		// pickup time
		xl.setCellData("Sheet1", i, header++, "pickup time");

	}
}
