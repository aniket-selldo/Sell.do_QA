package importPack;

import java.io.IOException;

import com.github.javafaker.Faker;
import com.selldo.Utility.XLUtilsHSSF;

public class LeadXLfileGenerator extends XL_Utils {

	public String leadImport(int fileCount) throws IOException {
		String path = System.getProperty("user.dir") + "/DataFile/Lead import.xls";
		String path2 = createNewXLFile("LeadImport");
		XLUtilsHSSF xl = new XLUtilsHSSF(path2);
		Faker fk = new Faker();
		CreateHeaderForLeadImport(xl);
		for (int i = 1; i < fileCount; i++) {
			int row = 0;
			// First Name
			xl.setCellData("Sheet1", i, row++, "" + fk.firstName());
			// Last Name
			xl.setCellData("Sheet1", i, row++, "" + fk.lastName());
			// Phone Number
			xl.setCellData("Sheet1", i, row++, "" + "+91 " + randomPhone());
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
			xl.setCellData("Sheet1", i, row++, "25");
			// Birthday
			xl.setCellData("Sheet1", i, row++, getDate(-1000, Date_formatter.Full_Date_Short));
			// Anniversary
			xl.setCellData("Sheet1", i, row++, getDate(-100, Date_formatter.Full_Date_Short));
			// Industry
			xl.setCellData("Sheet1", i, row++, fk.name());
			// Educational Details
			String[] educationDetails = { "school", "graduation", "post-graduation", "other" };
			xl.setCellData("Sheet1", i, row++, fk.firstName() + "," + fk.firstName() + ","
					+ educationDetails[getRandomNumber(0, educationDetails.length - 1)]);
			// Professional Details
			String ProfessionalDetails[] = { "self-employed", "government-servant", "company-employee", "other",
					"retired", "housewife", "student" };
			xl.setCellData("Sheet1", i, row++, ProfessionalDetails[getRandomNumber(0, ProfessionalDetails.length - 1)]
					+ "," + fk.firstName() + "," + fk.firstName());
			// INCOME Details
			String[] INCOMEDetails = { "personal", "family" };
			xl.setCellData("Sheet1", i, row++,
					Random("N", 10) + "," + INCOMEDetails[getRandomNumber(0, INCOMEDetails.length - 1)]);
			// Loan Details
			String[] LoanDetails = { "home-loan", "car-loan", "personal-loan", "education-loan" };
			xl.setCellData("Sheet1", i, row++, Random("N", 9) + "," + fk.firstName() + ","
					+ LoanDetails[getRandomNumber(0, LoanDetails.length - 1)]);
			// Address
			xl.setCellData("Sheet1", i, row++, fk.streetAddress(true));
			// State
			xl.setCellData("Sheet1", i, row++, "Goa");
			// City
			xl.setCellData("Sheet1", i, row++, "Panaji");
			// Country
			xl.setCellData("Sheet1", i, row++, "India");
			// Status in Given Stage
			xl.setCellData("Sheet1", i, row++, "");
			// Lead Stages
			xl.setCellData("Sheet1", i, row++, "Incoming");
			// Stage Change Reasons
			xl.setCellData("Sheet1", i, row++, "");
			// Purpose
			xl.setCellData("Sheet1", i, row++, "end_use");
			// Furnishing
			xl.setCellData("Sheet1", i, row++, "Furnished, Semi-Furnished");
			// Facing
			xl.setCellData("Sheet1", i, row++, "North,East");
			// Nri
			xl.setCellData("Sheet1", i, row++, "No");
			// Transaction Type
			xl.setCellData("Sheet1", i, row++, "lease");
			// Funding Source
			xl.setCellData("Sheet1", i, row++, "self");
			// Bathroom Preferences
			xl.setCellData("Sheet1", i, row++, "2,4");
			// Married
			xl.setCellData("Sheet1", i, row++, "Yes");
			// Manual Tags
			xl.setCellData("Sheet1", i, row++, fk.name());
			// Gender
			xl.setCellData("Sheet1", i, row++, "Male");
			// Zip
			xl.setCellData("Sheet1", i, row++, Random("N", 6));
			// Street
			xl.setCellData("Sheet1", i, row++, fk.streetName());
			// Area
			xl.setCellData("Sheet1", i, row++, "12");

			System.out.println("Row " + (i + 1) + " updated done");
		}
		System.out.println("<<<<<<Done>>>>>>");
		return path2;

	}

}
