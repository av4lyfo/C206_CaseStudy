
public class TimeSlot {
    private String name;
    private String day;
    private String startTime;
    private String endTime;

    public TimeSlot(String name, String day, String startTime, String endTime) {
        this.name = name;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}