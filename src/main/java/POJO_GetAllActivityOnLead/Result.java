package POJO_GetAllActivityOnLead;

public class Result {
	 private Followup followup;
	   private Feed feed;
	   private SiteVisit site_visit;
	   private Email email;
	   private Whatsapp whatsapp;
	   private Note note;

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Feed getFeed() {
		return feed;
	}

	public void setFeed(Feed feed) {
		this.feed = feed;
	}

	public SiteVisit getSite_visit() {
		return site_visit;
	}

	public void setSite_visit(SiteVisit site_visit) {
		this.site_visit = site_visit;
	}

	public Followup getFollowup() {
		return followup;
	}

	public void setFollowup(Followup followup) {
		this.followup = followup;
	}

	public Whatsapp getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(Whatsapp whatsapp) {
		this.whatsapp = whatsapp;
	}
}
