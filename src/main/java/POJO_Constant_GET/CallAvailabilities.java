package POJO_Constant_GET;

import java.util.ArrayList;

public class CallAvailabilities {
	  public int start_hour;
	    public int end_hour;
	    public int start_minute;
	    public int end_minute;
	    public boolean available;
	    public ArrayList<Object> week_off_days;
		public int getStart_hour() {
			return start_hour;
		}
		public void setStart_hour(int start_hour) {
			this.start_hour = start_hour;
		}
		public int getEnd_hour() {
			return end_hour;
		}
		public void setEnd_hour(int end_hour) {
			this.end_hour = end_hour;
		}
		public int getStart_minute() {
			return start_minute;
		}
		public void setStart_minute(int start_minute) {
			this.start_minute = start_minute;
		}
		public int getEnd_minute() {
			return end_minute;
		}
		public void setEnd_minute(int end_minute) {
			this.end_minute = end_minute;
		}
		public boolean isAvailable() {
			return available;
		}
		public void setAvailable(boolean available) {
			this.available = available;
		}
		public ArrayList<Object> getWeek_off_days() {
			return week_off_days;
		}
		public void setWeek_off_days(ArrayList<Object> week_off_days) {
			this.week_off_days = week_off_days;
		}
}
