package POJO_Constant_GET;

import java.util.ArrayList;

public class LeadStages {
	 public ArrayList<PreSale> pre_sales;
	    public ArrayList<Sale> sales;
		public ArrayList<PreSale> getPre_sales() {
			return pre_sales;
		}
		public void setPre_sales(ArrayList<PreSale> pre_sales) {
			this.pre_sales = pre_sales;
		}
		public ArrayList<Sale> getSales() {
			return sales;
		}
		public void setSales(ArrayList<Sale> sales) {
			this.sales = sales;
		}
}
