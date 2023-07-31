package POJO_GetAllActivityOnLead;

import java.util.ArrayList;

public class Root_GetAllLeadActivity {
	private Object page;
	private Object per_page;
	private ArrayList<Result> results;
	private int total;

	public Object getPage() {
		return page;
	}

	public void setPage(Object page) {
		this.page = page;
	}

	public Object getPer_page() {
		return per_page;
	}

	public void setPer_page(Object per_page) {
		this.per_page = per_page;
	}

	public ArrayList<Result> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
