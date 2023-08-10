public class RegisterActivity {
	private String activityName;
	private String username;
    private String approvalStatus;
    private String attendance;
    private String timeSlot;

	public RegisterActivity(String activityName, String username, String timeSlot) {
    	this.activityName = activityName;
    	this.username = username;
    	this.timeSlot = timeSlot;
    	this.approvalStatus = "Pending";
    	this.attendance = "";
    }

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

    public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
}
