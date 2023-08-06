import java.util.*;
public class CCARegistrationSystem {
    private static List<User> users = new ArrayList<>();
    private static List<Activity> activities = new ArrayList<>();
    private static List<Registration> registrations = new ArrayList<>();
    private static List<ApprovalStatus> approvalStatuses = new ArrayList<>();
    private static List<TimeSlot> timeSlots = new ArrayList<>();
    private static List<Attendance> attendanceRecords = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your role (Administrator/Teacher/Student): ");
        String role = scanner.nextLine();

        if (role.equalsIgnoreCase("Administrator")) {
            adminMenu();
        } else if (role.equalsIgnoreCase("Teacher")) {
            teacherMenu();
        } else if (role.equalsIgnoreCase("Student")) {
            studentMenu();
        } else {
            System.out.println("Invalid role entered.");
        }

        scanner.close();
    }

    private static void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayAdminMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    viewUsers();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    addApprovalStatus();
                    break;
                case 5:
                    viewApprovalStatuses();
                    break;
                case 6:
                    deleteApprovalStatus();
                    break;
                case 7:
                    addTimeSlot();
                    break;
                case 8:
                    viewTimeSlots();
                    break;
                case 9:
                    deleteTimeSlot();
                    break;
                case 0:
                    System.out.println("Exiting admin menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void teacherMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayTeacherMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addActivity();
                    break;
                case 2:
                    viewActivities();
                    break;
                case 3:
                    deleteActivity();
                    break;
                case 4:
                    updateApprovalStatus();
                    break;
                case 5:
                    addAttendance();
                    break;
                case 6:
                    viewAttendance();
                    break;
                case 7:
                    deleteAttendance();
                    break;
                case 0:
                    System.out.println("Exiting teacher menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void studentMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayStudentMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewAvailableActivities();
                    break;
                case 2:
                    registerForActivity();
                    break;
                case 3:
                    viewRegisteredActivities();
                    break;
                case 4:
                    leaveActivity();
                    break;
                case 0:
                    System.out.println("Exiting student menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Additional methods for each menu option...

    private static void initializeData() {
        users.add(new User("John", "Administrator"));
        users.add(new User("Zhi Yang", "Teacher"));
        users.add(new User("Benedict", "Teacher"));
        users.add(new User("Yik Kan", "Student"));

        activities.add(new Activity("Football", "Join our school's football team!"));
        activities.add(new Activity("Chess Club", "Sharpen your mind with strategic games."));
        activities.add(new Activity("Art Club", "Express your creativity through art."));

        approvalStatuses.add(new ApprovalStatus("Pending", "Registration is pending approval."));
        approvalStatuses.add(new ApprovalStatus("Approved", "Registration is approved."));
        approvalStatuses.add(new ApprovalStatus("Rejected", "Registration is rejected."));

        timeSlots.add(new TimeSlot("Slot A", "Monday", "09:00 AM", "11:00 AM"));
        timeSlots.add(new TimeSlot("Slot B", "Wednesday", "02:00 PM", "04:00 PM"));
        timeSlots.add(new TimeSlot("Slot C", "Friday", "03:00 PM", "05:00 PM"));
    }

    // Additional methods for user stories...
    
    // Display methods for different menus...

    private static void displayAdminMenu() {
        System.out.println("\nAdministrator Menu");
        System.out.println("1. Add User");
        System.out.println("2. View Users");
        System.out.println("3. Delete User");
        System.out.println("4. Add Approval Status");
        System.out.println("5. View Approval Statuses");
        System.out.println("6. Delete Approval Status");
        System.out.println("7. Add Time Slot");
        System.out.println("8. View Time Slots");
        System.out.println("9. Delete Time Slot");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void displayTeacherMenu() {
        System.out.println("\nTeacher Menu");
        System.out.println("1. Add Activity");
        System.out.println("2. View Activities");
        System.out.println("3. Delete Activity");
        System.out.println("4. Update Approval Status");
        System.out.println("5. Add Attendance");
        System.out.println("6. View Attendance");
        System.out.println("7. Delete Attendance");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void displayStudentMenu() {
        System.out.println("\nStudent Menu");
        System.out.println("1. View Available Activities");
        System.out.println("2. Register for Activity");
        System.out.println("3. View Registered Activities");
        System.out.println("4. Leave Activity");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        initializeData();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your role (Administrator/Teacher/Student): ");
        String role = scanner.nextLine();

        if (role.equalsIgnoreCase("Administrator")) {
            adminMenu();
        } else if (role.equalsIgnoreCase("Teacher")) {
            teacherMenu();
        } else if (role.equalsIgnoreCase("Student")) {
            studentMenu();
        } else {
            System.out.println("Invalid role entered.");
        }

        scanner.close();
    }

    private static void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayAdminMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    viewUsers();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    addApprovalStatus();
                    break;
                case 5:
                    viewApprovalStatuses();
                    break;
                case 6:
                    deleteApprovalStatus();
                    break;
                case 7:
                    addTimeSlot();
                    break;
                case 8:
                    viewTimeSlots();
                    break;
                case 9:
                    deleteTimeSlot();
                    break;
                case 0:
                    System.out.println("Exiting admin menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void teacherMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayTeacherMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addActivity();
                    break;
                case 2:
                    viewActivities();
                    break;
                case 3:
                    deleteActivity();
                    break;
                case 4:
                    updateApprovalStatus();
                    break;
                case 5:
                    addAttendance();
                    break;
                case 6:
                    viewAttendance();
                    break;
                case 7:
                    deleteAttendance();
                    break;
                case 0:
                    System.out.println("Exiting teacher menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void studentMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayStudentMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewAvailableActivities();
                    break;
                case 2:
                    registerForActivity();
                    break;
                case 3:
                    viewRegisteredActivities();
                    break;
                case 4:
                    leaveActivity();
                    break;
                case 0:
                    System.out.println("Exiting student menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        System.out.print("Enter user role: ");
        String role = scanner.nextLine();
        users.add(new User(name, role));
        System.out.println("User added successfully.");
    }

    private static void viewUsers() {
        System.out.println("\nList of Users:");
        for (User user : users) {
            System.out.println("Name: " + user.getName() + ", Role: " + user.getRole());
        }
    }

    private static void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user name to delete: ");
        String name = scanner.nextLine();
        User userToDelete = null;
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                userToDelete = user;
                break;
            }
        }
        if (userToDelete != null) {
            users.remove(userToDelete);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    private static void addApprovalStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter approval status name: ");
        String name = scanner.nextLine();
        System.out.print("Enter approval status description: ");
        String description = scanner.nextLine();
        approvalStatuses.add(new ApprovalStatus(name, description));
        System.out.println("Approval status added successfully.");
    }

    private static void viewApprovalStatuses() {
        System.out.println("\nList of Approval Statuses:");
        for (ApprovalStatus status : approvalStatuses) {
            System.out.println("Name: " + status.getName() + ", Description: " + status.getDescription());
        }
    }

    private static void deleteApprovalStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter approval status name to delete: ");
        String name = scanner.nextLine();
        ApprovalStatus statusToDelete = null;
        for (ApprovalStatus status : approvalStatuses) {
            if (status.getName().equalsIgnoreCase(name)) {
                statusToDelete = status;
                break;
            }
        }
        if (statusToDelete != null) {
            approvalStatuses.remove(statusToDelete);
            System.out.println("Approval status deleted successfully.");
        } else {
            System.out.println("Approval status not found.");
        }
    }

    private static void addTimeSlot() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time slot name: ");
        String name = scanner.nextLine();
        System.out.print("Enter day: ");
        String day = scanner.nextLine();
        System.out.print("Enter start time: ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time: ");
        String endTime = scanner.nextLine();
        timeSlots.add(new TimeSlot(name, day, startTime, endTime));
        System.out.println("Time slot added successfully.");
    }

    private static void viewTimeSlots() {
        System.out.println("\nList of Time Slots:");
        for (TimeSlot slot : timeSlots) {
            System.out.println("Name: " + slot.getName() + ", Day: " + slot.getDay() +
                    ", Start Time: " + slot.getStartTime() + ", End Time: " + slot.getEndTime());
        }
    }

    private static void deleteTimeSlot() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time slot name to delete: ");
        String name = scanner.nextLine();
        TimeSlot slotToDelete = null;
        for (TimeSlot slot : timeSlots) {
            if (slot.getName().equalsIgnoreCase(name)) {
                slotToDelete = slot;
                break;
            }
        }
        if (slotToDelete != null) {
            timeSlots.remove(slotToDelete);
            System.out.println("Time slot deleted successfully.");
        } else {
            System.out.println("Time slot not found.");
        }
    }

 // Additional methods for Teacher Menu

    private static void addActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter activity name: ");
        String name = scanner.nextLine();
        System.out.print("Enter activity description: ");
        String description = scanner.nextLine();
        System.out.print("Enter approval status name for the activity: ");
        String approvalStatus = scanner.nextLine();
        // Check if the approval status exists
        ApprovalStatus status = getApprovalStatusByName(approvalStatus);
        if (status == null) {
            System.out.println("Approval status not found.");
            return;
        }
        System.out.print("Enter time slot name for the activity: ");
        String timeSlot = scanner.nextLine();
        // Check if the time slot exists
        TimeSlot slot = getTimeSlotByName(timeSlot);
        if (slot == null) {
            System.out.println("Time slot not found.");
            return;
        }
        activities.add(new Activity(name, description, status, slot));
        System.out.println("Activity added successfully.");
    }

    private static void viewActivities() {
        System.out.println("\nList of Activities:");
        for (Activity activity : activities) {
            System.out.println("Name: " + activity.getName() + ", Description: " + activity.getDescription() +
                    ", Approval Status: " + activity.getApprovalStatus().getName() +
                    ", Time Slot: " + activity.getTimeSlot().getName());
        }
    }

    private static void deleteActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter activity name to delete: ");
        String name = scanner.nextLine();
        Activity activityToDelete = null;
        for (Activity activity : activities) {
            if (activity.getName().equalsIgnoreCase(name)) {
                activityToDelete = activity;
                break;
            }
        }
        if (activityToDelete != null) {
            activities.remove(activityToDelete);
            System.out.println("Activity deleted successfully.");
        } else {
            System.out.println("Activity not found.");
        }
    }

    private static void updateApprovalStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter activity name to update approval status: ");
        String activityName = scanner.nextLine();
        Activity activityToUpdate = null;
        for (Activity activity : activities) {
            if (activity.getName().equalsIgnoreCase(activityName)) {
                activityToUpdate = activity;
                break;
            }
        }
        if (activityToUpdate != null) {
            System.out.print("Enter new approval status name: ");
            String newApprovalStatus = scanner.nextLine();
            ApprovalStatus status = getApprovalStatusByName(newApprovalStatus);
            if (status == null) {
                System.out.println("Approval status not found.");
                return;
            }
            activityToUpdate.setApprovalStatus(status);
            System.out.println("Approval status updated successfully.");
        } else {
            System.out.println("Activity not found.");
        }
    }

    private static void addAttendance() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        User student = getUserByName(studentName);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter activity name: ");
        String activityName = scanner.nextLine();
        Activity activity = getActivityByName(activityName);
        if (activity == null) {
            System.out.println("Activity not found.");
            return;
        }
        System.out.print("Enter attendance status (Present/Late/Absent/Excused Absence): ");
        String status = scanner.nextLine();
        if (!isValidAttendanceStatus(status)) {
            System.out.println("Invalid attendance status.");
            return;
        }
        Attendance attendance = new Attendance(student, activity, status);
        activity.addAttendance(attendance);
        System.out.println("Attendance added successfully.");
    }

    private static void viewAttendance() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter activity name to view attendance: ");
        String activityName = scanner.nextLine();
        Activity activity = getActivityByName(activityName);
        if (activity == null) {
            System.out.println("Activity not found.");
            return;
        }
        System.out.println("\nAttendance for Activity '" + activity.getName() + "':");
        List<Attendance> attendanceList = activity.getAttendanceList();
        for (Attendance attendance : attendanceList) {
            System.out.println("Student: " + attendance.getStudent().getName() +
                    ", Status: " + attendance.getStatus());
        }
    }

    private static void deleteAttendance() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter activity name to delete attendance: ");
        String activityName = scanner.nextLine();
        Activity activity = getActivityByName(activityName);
        if (activity == null) {
            System.out.println("Activity not found.");
            return;
        }
        System.out.print("Enter student name to delete attendance: ");
        String studentName = scanner.nextLine();
        User student = getUserByName(studentName);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        boolean removed = activity.removeAttendance(student);
        if (removed) {
            System.out.println("Attendance deleted successfully.");
        } else {
            System.out.println("Attendance not found.");
        }
    }

    // Additional methods for Student Menu

    private static void viewAvailableActivities() {
        System.out.println("\nList of Available Activities:");
        for (Activity activity : activities) {
            if (activity.getApprovalStatus().getName().equalsIgnoreCase("Approved")) {
                System.out.println("Name: " + activity.getName() + ", Description: " + activity.getDescription() +
                        ", Time Slot: " + activity.getTimeSlot().getName());
            }
        }
    }

    private static void registerForActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter activity name to register: ");
        String activityName = scanner.nextLine();
        Activity activity = getActivityByName(activityName);
        if (activity == null) {
            System.out.println("Activity not found.");
            return;
        }
        if (!activity.getApprovalStatus().getName().equalsIgnoreCase("Approved")) {
            System.out.println("Cannot register for unapproved activities.");
            return;
        }
        if (activity.isFull()) {
            System.out.println("Activity is already full.");
            return;
        }
        User currentUser = getUserByName("current_user"); // Replace with actual user name
        Registration registration = new Registration(currentUser, activity);
        currentUser.addRegistration(registration);
        activity.addRegistration(registration);
        System.out.println("Registered successfully for activity '" + activity.getName() + "'.");
    }

    private static void viewRegisteredActivities() {
        User currentUser = getUserByName("current_user"); // Replace with actual user name
        List<Registration> registrations = currentUser.getRegistrations();
        if (registrations.isEmpty()) {
            System.out.println("No registered activities.");
            return;
        }
        System.out.println("\nList of Registered Activities:");
        for (Registration registration : registrations) {
            Activity activity = registration.getActivity();
            System.out.println("Name: " + activity.getName() + ", Description: " + activity.getDescription() +
                    ", Time Slot: " + activity.getTimeSlot().getName() +
                    ", Approval Status: " + activity.getApprovalStatus().getName());
        }
    }

    private static void leaveActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter activity name to leave: ");
        String activityName = scanner.nextLine();
        Activity activity = getActivityByName(activityName);
        if (activity == null) {
            System.out.println("Activity not found.");
            return;
        }
        User currentUser = getUserByName("current_user"); // Replace with actual user name
        boolean removed = currentUser.removeRegistration(activity);
        if (removed) {
            activity.removeRegistration(currentUser);
            System.out.println("Left activity successfully.");
        } else {
            System.out.println("You are not registered for this activity.");
        }
    }

    // Helper methods for Teacher and Student menus...

    private static ApprovalStatus getApprovalStatusByName(String name) {
        for (ApprovalStatus status : approvalStatuses) {
            if (status.getName().equalsIgnoreCase(name)) {
                return status;
            }
        }
        return null;
    }

    private static TimeSlot getTimeSlotByName(String name) {
        for (TimeSlot slot : timeSlots) {
            if (slot.getName().equalsIgnoreCase(name)) {
                return slot;
            }
        }
        return null;
    }

    private static Activity getActivityByName(String name) {
        for (Activity activity : activities) {
            if (activity.getName().equalsIgnoreCase(name)) {
                return activity;
            }
        }
        return null;
    }

    private static User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    private static boolean isValidAttendanceStatus(String status) {
        return status.equalsIgnoreCase("Present") ||
                status.equalsIgnoreCase("Late") ||
                status.equalsIgnoreCase("Absent") ||
                status.equalsIgnoreCase("Excused Absence");
    }
}
