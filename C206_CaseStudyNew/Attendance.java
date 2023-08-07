import java.util.Date;

class Attendance {
    private User student;
    private Activity activity;
    private String status;
    private Date date;

    public Attendance(User student, Activity activity, String status) {
        this.student = student;
        this.activity = activity;
        this.status = status;
        this.date = new Date(); // You can customize how you initialize the date
    }

    public User getStudent() {
        return student;
    }

    public Activity getActivity() {
        return activity;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }
}