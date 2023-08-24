package POJO_AddDevloper_GET;

import java.util.ArrayList;
import java.util.Date;

public class Root_AddDevloper_GET {
	private String _id;
	private String client_id;
	private Object comments;
	private Contact contact;
	private Date created_at;
	private String description;
	private Logo logo;
	private String name;
	private Object rating;
	private ArrayList<Object> secondary_project_ids;
	private SyncDataHash sync_data_hash;
	private Date updated_at;
	private Object website;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public Object getComments() {
		return comments;
	}

	public void setComments(Object comments) {
		this.comments = comments;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Logo getLogo() {
		return logo;
	}

	public void setLogo(Logo logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getRating() {
		return rating;
	}

	public void setRating(Object rating) {
		this.rating = rating;
	}

	public ArrayList<Object> getSecondary_project_ids() {
		return secondary_project_ids;
	}

	public void setSecondary_project_ids(ArrayList<Object> secondary_project_ids) {
		this.secondary_project_ids = secondary_project_ids;
	}

	public SyncDataHash getSync_data_hash() {
		return sync_data_hash;
	}

	public void setSync_data_hash(SyncDataHash sync_data_hash) {
		this.sync_data_hash = sync_data_hash;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Object getWebsite() {
		return website;
	}

	public void setWebsite(Object website) {
		this.website = website;
	}
}
