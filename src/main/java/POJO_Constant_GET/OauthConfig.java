package POJO_Constant_GET;

import java.util.ArrayList;

public class OauthConfig {
	  public boolean setup_oauth_accounts;
	    public ArrayList<String> adwords_account_ids;
	    public ArrayList<String> adverts_account_ids;
		public boolean isSetup_oauth_accounts() {
			return setup_oauth_accounts;
		}
		public void setSetup_oauth_accounts(boolean setup_oauth_accounts) {
			this.setup_oauth_accounts = setup_oauth_accounts;
		}
		public ArrayList<String> getAdwords_account_ids() {
			return adwords_account_ids;
		}
		public void setAdwords_account_ids(ArrayList<String> adwords_account_ids) {
			this.adwords_account_ids = adwords_account_ids;
		}
		public ArrayList<String> getAdverts_account_ids() {
			return adverts_account_ids;
		}
		public void setAdverts_account_ids(ArrayList<String> adverts_account_ids) {
			this.adverts_account_ids = adverts_account_ids;
		}
}
