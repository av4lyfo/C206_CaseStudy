class Registration {
    private User student;
    private Activity activity;

    public Registration(User student, Activity activity) {
        this.student = student;
        this.activity = activity;
    }

    public User getStudent() {
        return student;
    }

    public Activity getActivity() {
        return activity;
    }
}

class ApprovalStatus {
    private String name;
    private String description;

    public ApprovalStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}