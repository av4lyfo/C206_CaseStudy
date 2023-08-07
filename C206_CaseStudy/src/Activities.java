public class Activities {
	private String aName;
	private String description;
    private String timeSlot;
    
    public Activities(String aName, String description, String timeSlot) {
    	this.aName = aName;
        this.description = description;
        this.timeSlot = timeSlot;
    }

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
}
