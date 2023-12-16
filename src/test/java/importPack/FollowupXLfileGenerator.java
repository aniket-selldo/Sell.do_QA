package importPack;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.github.javafaker.Faker;
import com.selldo.Utility.XLUtilsHSSF;

import API.APIs;

public class FollowupXLfileGenerator extends XL_Utils {

	public static void fileGenerate(int rows, String useFor) throws IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
		String path2 = createNewXLFile("FolloupImport");
		XLUtilsHSSF xl = new XLUtilsHSSF(path2);
		Faker fk = new Faker();
		createHeaderForFolloupImport(xl, useFor);
		if (useFor.equalsIgnoreCase("Full")) {
			for (int i = 1; i < rows; i++) {
				int row = 0;
				// Lead_crm_id
				String salesid = prop("Sales_id");
				String email = randomEmail();
				String phone = randomPhone();
				xl.setCellData("Sheet1", i, row++,
						"" + new APIs().createLead(salesid, email, phone).getSell_do_lead_id());
				// Lead Email
				xl.setCellData("Sheet1", i, row++, email);
				// Lead Phone
				xl.setCellData("Sheet1", i, row++, "+91 " + phone);
				// Sales ID
				xl.setCellData("Sheet1", i, row++, salesid.trim());
				// Scheduled on // 1 HR ahead date
				String date = new SimpleDateFormat("dd/MM/YY-hh:mm:ss")
						.format(new Date().getTime() + (1 * (1000 * 60 * 60)));
				xl.setCellData("Sheet1", i, row++, date);
				// Subject
				xl.setCellData("Sheet1", i, row++, fk.sentence());
				// Followup Type
				String FUType[] = { "call", "whatsapp", "email" };
				xl.setCellData("Sheet1", i, row++, FUType[getRandomNumber(0, FUType.length)]);
				// Project Ids
				xl.setCellData("Sheet1", i, row++, prop("Project_id"));
				// Agenda
				xl.setCellData("Sheet1", i, row++, fk.sentence());
				// Followup Status
				String FUStatus[] = { "scheduled", "conducted" };
				xl.setCellData("Sheet1", i, row++, FUStatus[getRandomNumber(0, FUStatus.length)]);
				// Acted On
				String date2 = new SimpleDateFormat("dd/MM/YY-hh:mm:ss")
						.format(new Date().getTime() + (1 * (1000 * 60 * 60 * 24)));
				xl.setCellData("Sheet1", i, row++, date2);
				// Cancellation Reason
				xl.setCellData("Sheet1", i, row++, "");
				System.out.println("Row " + i + " is updated");
			}
			System.out.println("<<<< FU File Updated for " + useFor + " >>>>");
		} else if (useFor.equalsIgnoreCase("Schedule")) {
			for (int i = 1; i < rows; i++) {
				int row = 0;
				// Lead_crm_id
				String salesid = prop("Sales_id");
				String email = randomEmail();
				String phone = randomPhone();
				// Lead CRM ID
				xl.setCellData("Sheet1", i, row++,
						"" + new APIs().createLead(salesid, email, phone).getSell_do_lead_id());
				// Scheduled on // 1 HR ahead date
				String date = new SimpleDateFormat("dd/MM/YY-hh:mm:ss")
						.format(new Date().getTime() + (1 * (1000 * 60 * 60)));
				xl.setCellData("Sheet1", i, row++, date);
				// Subject
				xl.setCellData("Sheet1", i, row++, fk.sentence());
				// Followup Type
				String FUType[] = { "call", "whatsapp", "email" };
				xl.setCellData("Sheet1", i, row++, FUType[getRandomNumber(0, FUType.length)]);
				// Agenda
				xl.setCellData("Sheet1", i, row++, fk.sentence());
				// Followup Status
				String FUStatus[] = { "scheduled", "conducted" };
				xl.setCellData("Sheet1", i, row++, FUStatus[0]);
				System.out.println("Row " + i + " is updated");
			}
			System.out.println("<<<< FU File Updated for " + useFor + " >>>>");
		}

	}

	public static void main(String[] args) throws IOException {
		fileGenerate(10, "Schedule");
	}

}
