package importPack;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.github.javafaker.Faker;
import com.selldo.Utility.XLUtilsHSSF;

import API.APIs;

public class SiteVisitXLFileGenerator extends XL_Utils {
	

	public String FileGeneratorForSiteVisit(int val) throws IOException {
		Faker fk = new Faker();
		String path = createNewXLFile("SiteVisitImport");
		XLUtilsHSSF xl = new XLUtilsHSSF(path);
		createHeaderForSiteVisitImport(xl);
		for (int i = 1; i <= val; i++) {
			int header = 0;
			String salesid = prop("Sales_id_Amura");
			String email = randomEmail();
			String phone = randomPhone();
			// Lead_crm_id
			String leadID = new APIs().createLead(prop("Amura_website_api_Amura"), salesid, email, phone)
					.getSell_do_lead_id();
			xl.setCellData("Sheet1", i, header++, leadID);
			// Lead Email
			xl.setCellData("Sheet1", i, header++, randomEmail());
			// Lead Phone
			xl.setCellData("Sheet1", i, header++,"+91 "+ randomPhone());
			// Sales ID
			xl.setCellData("Sheet1", i, header++, prop("Sales_id_Amura"));
			// Project Ids
			xl.setCellData("Sheet1", i, header++, prop("Project_id_Amura"));
			// Scheduled on
			String ScheduledOnDate = new SimpleDateFormat("dd/MM/YYYY-hh:mm:ss")
					.format(new Date().getTime() + (-1 * (1000 * 60 * 60)));// in past 1 hr
			xl.setCellData("Sheet1", i, header++, ScheduledOnDate);
			// Ends on
			String EndsOnDate = new SimpleDateFormat("dd/MM/YYYY-hh:mm:ss")
					.format(new Date().getTime() + (10 * (1000 * 60)));// Above 10 min from now
			xl.setCellData("Sheet1", i, header++, EndsOnDate);
			// Agenda
			xl.setCellData("Sheet1", i, header++, fk.sentence());
			// Sitevisit status
			String selectedStatus = null;
			String SVStatus[] = { "conducted", "scheduled" };
			xl.setCellData("Sheet1", i, header++, selectedStatus = SVStatus[getRandomNumber(0, SVStatus.length)]);
			if (selectedStatus.equalsIgnoreCase("conducted")) {
				String ConductedOnDate = new SimpleDateFormat("dd/MM/YYYY-hh:mm:ss")
						.format(new Date().getTime() + (0 * (1000 * 60 * 60 * 24)));
				// conducted on
				xl.setCellData("Sheet1", i, header++, ConductedOnDate);
			} else {
				header++;
			}
			// Notes
			xl.setCellData("Sheet1", i, header++, fk.sentence());
			// pickup
			String selection = null;
			String pickUp[] = { "yes", "no" };
			xl.setCellData("Sheet1", i, header++, selection = pickUp[getRandomNumber(0, pickUp.length)]);
			// pickup location
			if (selection.equalsIgnoreCase("yes")) {
				String pickUpLocation[] = { "Hinjewadi", "Balewadi" };
				xl.setCellData("Sheet1", i, header++, pickUpLocation[getRandomNumber(0, pickUpLocation.length)]);
				// pickup time
				String pickupOnDate = new SimpleDateFormat("dd/MM/YYYY-hh:mm:ss")
						.format(new Date().getTime() + (1 * (1000 * 60)));
				xl.setCellData("Sheet1", i, header++, pickupOnDate);
			} else {
				header++;
			}
			System.out.println("Row " + i + " Updated");
		}
		System.out.println("File Generation completed");
		return path;
	}

}
