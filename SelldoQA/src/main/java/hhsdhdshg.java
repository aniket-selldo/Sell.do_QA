import org.testng.annotations.Test;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

import Enums.WFEvent;
import WorkFlow.WorkFlowListPage;
import WorkFlow.WorkFlowPage;

public class hhsdhdshg extends BaseTest {

	@Test
	public void a() throws InterruptedException {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("Aniket_SM"), prop.getProperty("Aniket_SM_PSWD"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);
		clientLogin.logout();
		login.login(prop.getProperty("Aniket_SM"), prop.getProperty("Aniket_SM_PSWD"));
		clientLogin.clientLogin("Aniket Automation");

		WorkFlowPage wfp = new WorkFlowPage(driver);
		wfp.goToWF();
		wfp.clickOnNewWF();
		String WFName = Random(10);
		wfp.fillWFForm(WFName, Random(100));
		wfp.clickOnGetStart();
		wfp.selectTamplete(WFEvent.Followup_Scheduled);
		wfp.clickOnAddAction();
		wfp.clickOnAddActionButton();
		wfp.enterAction("Add Note");
		wfp.enterValue("XYZ");
		wfp.clickOnSaveAllButton();
		wfp.goToWF();
		
		WorkFlowListPage WorkFlowList = new WorkFlowListPage(driver);
		WorkFlowList.clearFilter();
		WorkFlowList.Activate_OR_Deactivate_WorkFlow(WFName);
		clientLogin.logout();
		
		
		
		

	}
}
