package POJO_GetAllUser_GET;

import java.util.ArrayList;

public class Root_GetAllUser {
	private Object page;
	private int per_page;
	private ArrayList<Result> results;
	private int total;
	private ArrayList<AllUser> all_users;

	public Object getPage() {
		return page;
	}

	public void setPage(Object page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
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

	public ArrayList<AllUser> getAll_users() {
		return all_users;
	}

	public void setAll_users(ArrayList<AllUser> all_users) {
		this.all_users = all_users;
	}
}
