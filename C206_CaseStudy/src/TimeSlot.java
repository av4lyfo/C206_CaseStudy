
public class TimeSlot {
	private String timeslot;
	private String aname;
	
	public TimeSlot(String aname, String timeslot) {
		this.timeslot = timeslot;
		this.aname = aname;
	}

	public String getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}
	
}
