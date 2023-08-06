import java.util.List;

public class Activity {
    private String name;
    private String description;
    private ApprovalStatus approvalStatus;
    private TimeSlot timeSlot;
    private List<Registration> registrations;
    private List<Attendance> attendanceList;

    public Activity(String name, String description, ApprovalStatus approvalStatus, TimeSlot timeSlot) {
        this.name = name;
        this.description = description;
        this.approvalStatus = approvalStatus;
        this.timeSlot = timeSlot;
        this.registrations = new ArrayList<>();
        this.attendanceList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void addRegistration(Registration registration) {
        registrations.add(registration);
    }

    public void removeRegistration(User user) {
        registrations.removeIf(registration -> registration.getStudent().equals(user));
    }

    public boolean isFull() {
        return registrations.size() >= 10; // You can adjust the maximum capacity
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void addAttendance(Attendance attendance) {
        attendanceList.add(attendance);
    }

    public boolean removeAttendance(User student) {
        return attendanceList.removeIf(attendance -> attendance.getStudent().equals(student));
    }
}