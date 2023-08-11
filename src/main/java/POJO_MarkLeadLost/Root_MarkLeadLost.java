package POJO_MarkLeadLost;

public class Root_MarkLeadLost {
	private String stage;
	private String stage_change_reason;
	private CancelActivities cancel_activities;

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getStage_change_reason() {
		return stage_change_reason;
	}

	public void setStage_change_reason(String stage_change_reason) {
		this.stage_change_reason = stage_change_reason;
	}

	public CancelActivities getCancel_activities() {
		return cancel_activities;
	}

	public void setCancel_activities(CancelActivities cancel_activities) {
		this.cancel_activities = cancel_activities;
	}
}
