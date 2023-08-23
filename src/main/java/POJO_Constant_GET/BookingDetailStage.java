package POJO_Constant_GET;

import java.util.ArrayList;

public class BookingDetailStage {
	public String _id;
	public ArrayList<Object> drop_off_reasons;
	public boolean is_default;
	public String name;
	public String stage_type;
	public ArrayList<String> to_stages;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public ArrayList<Object> getDrop_off_reasons() {
		return drop_off_reasons;
	}

	public void setDrop_off_reasons(ArrayList<Object> drop_off_reasons) {
		this.drop_off_reasons = drop_off_reasons;
	}

	public boolean isIs_default() {
		return is_default;
	}

	public void setIs_default(boolean is_default) {
		this.is_default = is_default;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage_type() {
		return stage_type;
	}

	public void setStage_type(String stage_type) {
		this.stage_type = stage_type;
	}

	public ArrayList<String> getTo_stages() {
		return to_stages;
	}

	public void setTo_stages(ArrayList<String> to_stages) {
		this.to_stages = to_stages;
	}
}
