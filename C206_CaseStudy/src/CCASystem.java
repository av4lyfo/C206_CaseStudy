import java.util.*;

public class CCASystem {
	private static List<Users> users = new ArrayList<>();
	private static List<Activities> activities = new ArrayList<>();
	private static List<RegisterActivity> registerActivities = new ArrayList<>();
	private static List<TimeSlot> timeSlots = new ArrayList<>();

	public static void main(String[] args) {
		users.add(new Users("John", "Administrator", "8765 4321"));
		users.add(new Users("Zhi Yang", "Student", " 9876 5643"));
		users.add(new Users("Benedict", "Teacher", "9254 5432"));
		users.add(new Users("Yik Kan", "Student", "8653 3654"));

		activities.add(new Activities("Football", "Join our school's football team!"));
		activities.add(new Activities("Chess Club", "Sharpen your mind with strategic games."));
		activities.add(new Activities("Art Club", "Express your creativity through art."));

		timeSlots.add(new TimeSlot("Football", "0900 - 1100"));
		timeSlots.add(new TimeSlot("Art Club", "1400 - 1600"));
		timeSlots.add(new TimeSlot("Chess Club", "1500 - 1700"));

		registerActivities.add(new RegisterActivity("Football", "Zhi Yang", "0900 - 1100"));
		registerActivities.add(new RegisterActivity("Art Club", "Zhi Yang", "0200 - 0400"));
		registerActivities.add(new RegisterActivity("Chess Club", "Yik Kan", "0300 - 0500"));

		registerActivities.get(2).setApprovalStatus("Approved");

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your username (or 'Leave' to leave): ");
		String name = scanner.nextLine();

		Scanner optionScanner = new Scanner(System.in);

		while (!name.equalsIgnoreCase("Leave")) {
			for (int i = 0; i < users.size(); i++) {
				Users login = users.get(i);
				String roles = login.getRole();
				String username = login.getName();
				if (username.equalsIgnoreCase(name)) {
					if (roles.equalsIgnoreCase("Administrator")) {
						displayAdminMenu();
						int choice = optionScanner.nextInt();
						while (choice != 0) {
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
								viewApprovalStatus();

								break;
							case 6:
								deleteApprovalStatus();

								break;
							case 7:
								// addTimeSlot();

								break;
							case 8:
								// viewTimeSlots();

								break;
							case 9:
								// deleteTimeSlot();

								break;
							case 0:
								System.out.println("Exiting admin menu.");
								return;
							default:
								System.out.println("Invalid choice. Please try again.");
							}
							displayAdminMenu();
							choice = optionScanner.nextInt();
							System.out.println("");
						}

					} else if (roles.equalsIgnoreCase("Teacher")) {
						displayTeacherMenu();
						int choice = optionScanner.nextInt();
						while (choice != 0) {
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
								addApprovalStatus();

								break;
							case 5:
								viewApprovalStatus();

								break;
							case 6:
								deleteApprovalStatus();

								break;
							case 7:
								addAttendance();

								break;
							case 8:
								viewAttendance();

								break;
							case 9:
								deleteAttendance();

								break;
							case 0:
								System.out.println("Exiting teacher menu.");
								return;
							default:
								System.out.println("Invalid choice. Please try again.");
							}
							displayTeacherMenu();
							choice = optionScanner.nextInt();
							System.out.println("");
						}

					} else if (roles.equalsIgnoreCase("Student")) {
						displayStudentMenu();
						int choice = optionScanner.nextInt();
						while (choice != 0) {
							switch (choice) {
							case 1:
								viewAvailableActivities();

								break;
							case 2:
								registerForActivity(login);

								break;
							case 3:
								viewRegisteredActivities(login);

								break;
							case 4:
								leaveActivity(login);

								break;
							case 0:
								System.out.println("Exiting student menu.");
								return;
							default:
								System.out.println("Invalid choice. Please try again.");
							}
							displayStudentMenu();
							choice = optionScanner.nextInt();
							System.out.println("");
						}

					} else {
						System.out.println("Invalid role entered.");
						System.out.print("Enter your username (or 'Leave' to leave): ");
						name = scanner.nextLine();
						System.out.println("");
					}
				}

			}
			System.out.print("\nEnter your username (or 'Leave' to leave): ");
			name = scanner.nextLine();
		}

	}

	private static void displayAdminMenu() {
		System.out.println("\nAdministrator Menu");
		System.out.println("1. Add User");
		System.out.println("2. View Users");
		System.out.println("3. Delete User");
		System.out.println("4. Add Approval Status");
		System.out.println("5. View Approval Status");
		System.out.println("5. Delete Approval Status");
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
		System.out.println("4. Add Approval Status");
		System.out.println("5. View Approval Status");
		System.out.println("6. Delete Approval Status");
		System.out.println("7. Add Attendance");
		System.out.println("8. View Attendance");
		System.out.println("9. Delete Attendance");
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

	public static void addUser() {
		String name = Helper.readString("Enter user name: ");
		boolean exist = false;

		for (int i = 0; i < users.size(); i++) {
			if (name.equalsIgnoreCase(users.get(i).getName())) {
				exist = true;
			}
		}

		String role = Helper.readString("Enter user role(Administrator/Teacher/Student): ");
		boolean arole = false;
		if (role.equalsIgnoreCase("Administrator")) {
			role = "Administrator";
			arole = true;
		} else if (role.equalsIgnoreCase("Teacher")) {
			role = "Teacher";
			arole = true;
		} else if (role.equalsIgnoreCase("Student")) {
			role = "Student";
			arole = true;
		}
		if (arole == true) {
			String contact = Helper.readString("Enter user contact: ");

			if (exist == false) {
				users.add(new Users(name, role, contact));
				users.get(users.size() - 1).display();
				System.out.println("*** User has been added ***");
			} else {
				System.out.println("*** User already exists ***");
			}
		}
	}

	public static void viewUsers() {
		String output = String.format("%-10s %-15s %-20s\n", "NAME", "ROLE", "CONTACT");

		for (int i = 0; i < users.size(); i++) {

			output += String.format("%-10s %-15s %-20s\n", users.get(i).getName(), users.get(i).getRole(),
					users.get(i).getContact());

		}
		System.out.println(output);
	}

	public static void deleteUser() {
		String name = Helper.readString("Enter user name: ");

		for (int i = 0; i < users.size(); i++) {
			if (name.equalsIgnoreCase(users.get(i).getName())) {

				char confirm = Helper.readChar("Confirm deletion (y/n): ");

				if (confirm == 'y') {
					users.remove(i);
					System.out.println("*** User has been deleted ***");
				} else {
					System.out.println("*** User is not deleted ***");
				}

			}

		}

	}

	// done by benedict
	// add activity method
	public static void addActivity() {
		String newActivityName = Helper.readString("Enter activity Name");
		String newActivityDesc = Helper.readString("Enter activity Description");
		boolean exist = false;
		for (int i = 0; i < activities.size(); i++) {
			if (newActivityName.equalsIgnoreCase(activities.get(i).getaName())) {
				exist = true;
			}
		}
		if (exist == false) {
			activities.add(new Activities(newActivityName, newActivityDesc));
		} else {
			System.out.println("*** Activity already exists ***");
		}
	}

	// done by benedict
	// view all activities
	public static void viewActivities() {
		System.out.println("List of All Activities:");
		String output = String.format("%-20s %-40s \n", "ACTIVITY", "DESCRIPTION");
		for (int i = 0; i < activities.size(); i++) {

			output += String.format("%-20s %-40s \n", activities.get(i).getaName(), activities.get(i).getDescription());

		}
		System.out.println(output);
	}

	// done by benedict
	// delete activity
	public static void deleteActivity() {
		String aname = Helper.readString("Enter activity name > ");

		for (int i = 0; i < activities.size(); i++) {
			if (aname.equalsIgnoreCase(activities.get(i).getaName())) {

				char confirm = Helper.readChar("Confirm deletion (y/n) > ");

				if (confirm == 'y') {
					activities.remove(i);
					System.out.println("*** Activity has been deleted ***");
				} else {
					System.out.println("*** Activity is not deleted ***");
				}

			}

		}

	}
	// guys please add your code based on the order of your user story and use cases

	// Done by Avinash
	// View approval statuses method
	private static void addApprovalStatus() {
		String studentName = Helper.readString("Enter student name: ");
		String activityName = Helper.readString("Enter activity name: ");
		String timeslot = Helper.readString("Enter timeslot(start - end): ");
		boolean exist = false;

		for (int i = 0; i < registerActivities.size(); i++) {
			if ((studentName.equalsIgnoreCase(registerActivities.get(i).getUsername()))
					&& (activityName.equalsIgnoreCase(registerActivities.get(i).getActivityName()))
					&& (timeslot.equals(registerActivities.get(i).getTimeSlot()))) {
				exist = true;
				String approval = Helper.readString("Enter new status for registration(Approved/Declined): ");
				if (approval.equalsIgnoreCase("Approved") || approval.equalsIgnoreCase("Declined")) {
					registerActivities.get(i).setAttendance(approval);
					System.out.println("*** Registration updated ***");
				} else if (approval.equalsIgnoreCase("Declined")) {
					registerActivities.get(i).setAttendance("Declined");
					System.out.println("*** Registration updated ***");
				} else {
					System.out.println("*** Invalid approval status ***");
				}
			}
		}

		if (exist == false) {
			System.out.println("*** Registration not found ***");
		}
	}

	// Done by Avinash
	// View approval statuses method
	private static void viewApprovalStatus() {
		String output = String.format("%-10s %-20s %-20s %-10s \n", "STUDENT", "ACTIVITY", "TIMESLOT", "STATUS");
		for (int i = 0; i < registerActivities.size(); i++) {
			output += String.format("%-10s %-20s %-20s %-10s \n", registerActivities.get(i).getUsername(),
					registerActivities.get(i).getActivityName(), registerActivities.get(i).getTimeSlot(),
					registerActivities.get(i).getApprovalStatus());
		}
		System.out.println(output);
	}

	// Done by Avinash
	// Manage registration status
	private static void deleteApprovalStatus() {
		String studentName = Helper.readString("Enter student name: ");
		String activityName = Helper.readString("Enter activity name: ");
		String timeslot = Helper.readString("Enter timeslot(start - end): ");
		boolean exist = false;

		for (int i = 0; i < registerActivities.size(); i++) {
			if ((studentName.equalsIgnoreCase(registerActivities.get(i).getUsername()))
					&& (activityName.equalsIgnoreCase(registerActivities.get(i).getActivityName()))
					&& (timeslot.equals(registerActivities.get(i).getTimeSlot()))) {
				exist = true;
				char confirm = Helper.readChar("Are you sure to delete this Approval Status(y/n): ");
				if (confirm == 'y') {
					registerActivities.get(i).setApprovalStatus("Pending");
					System.out.println("*** Registration has been deleted ***");
				} else {
					System.out.println("*** Cancellation has cancelled ***");
				}
			}
		}

		if (exist == false) {
			System.out.println("*** Registration not found ***");
		}
	}


	// Done by Isaac
	// edit attendance
	private static void addAttendance() {
		String studentName = Helper.readString("Enter student name: ");
		String activityName = Helper.readString("Enter activity name: ");
		String timeslot = Helper.readString("Enter timeslot(start - end): ");
		boolean exist = false;

		for (int i = 0; i < registerActivities.size(); i++) {
			if ((studentName.equalsIgnoreCase(registerActivities.get(i).getUsername()))
					&& (activityName.equalsIgnoreCase(registerActivities.get(i).getActivityName()))
					&& (timeslot.equals(registerActivities.get(i).getTimeSlot()))) {
				exist = true;
				String newStatus = Helper.readString("Enter new attendance status(Present/Absent): ");
				if (newStatus.equalsIgnoreCase("Present") || newStatus.equalsIgnoreCase("Absent")) {
					registerActivities.get(i).setAttendance(newStatus);
					System.out.println("*** Attendance added ***");
				} else if (newStatus.equalsIgnoreCase("Absent")) {
					registerActivities.get(i).setAttendance("Absent");
					System.out.println("*** Attendance added ***");
				} else {
					System.out.println("*** Invalid status ***");
				}
			}
		}

		if (exist == false) {
			System.out.println("*** Registration not found ***");
		}
	}

	// Done by Isaac
	// edit attendance
	private static void viewAttendance() {
		String output = String.format("%-10s %-20s %-20s %-10s \n", "STUDENT", "ACTIVITY", "TIMESLOT", "ATTENDANCE");
		for (int i = 0; i < registerActivities.size(); i++) {
			if (registerActivities.get(i).getApprovalStatus().equalsIgnoreCase("Approved")) {
				output += String.format("%-10s %-20s %-20s %-10s \n", registerActivities.get(i).getUsername(),
						registerActivities.get(i).getActivityName(), registerActivities.get(i).getTimeSlot(),
						registerActivities.get(i).getAttendance());
			}
		}
		System.out.println(output);
	}

	// Done by Isaac
	// edit attendance
	private static void deleteAttendance() {
		String studentName = Helper.readString("Enter student name: ");
		String activityName = Helper.readString("Enter activity name: ");
		String timeslot = Helper.readString("Enter timeslot(start - end): ");
		boolean exist = false;

		for (int i = 0; i < registerActivities.size(); i++) {
			if ((studentName.equalsIgnoreCase(registerActivities.get(i).getUsername()))
					&& (activityName.equalsIgnoreCase(registerActivities.get(i).getActivityName()))
					&& (timeslot.equals(registerActivities.get(i).getTimeSlot()))) {
				exist = true;
				char confirm = Helper.readChar("Are you sure to delete this attendance(y/n): ");
				if (confirm == 'y') {
					registerActivities.get(i).setAttendance("");
					System.out.println("*** Attendance has been deleted ***");
				} else {
					System.out.println("*** Deletion has cancelled ***");
				}
			}
		}

		if (exist == false) {
			System.out.println("*** Registration not found ***");
		}
	}

	// Done by Yik Kan
	// register for an activity
	private static void viewAvailableActivities() {
		System.out.println("Available Activities:");
		String output = String.format("%-15s %-40s %-10s \n", "ACTIVITY", "DESCRIPTION", "TIMESLOT");
		for (int i = 0; i < timeSlots.size(); i++) {
			String actName = timeSlots.get(i).getAname();
			String actDes = "";
			for (int x = 0; x < activities.size(); x++) {
				if (actName.equalsIgnoreCase(activities.get(x).getaName())) {
					actDes = activities.get(x).getDescription();
				}
			}
			output += String.format("%-15s %-40s %-10s \n", actName, actDes, timeSlots.get(i).getTimeslot());
		}
		System.out.println(output);
	}

	// Done by Yik Kan
	// register for an activity
	private static void registerForActivity(Users login) {
		String name = login.getName();
		String activityName = Helper.readString("Enter activity name: ");
		String timeslot = Helper.readString("Enter timeslot(start - end): ");
		for (int i = 0; i < timeSlots.size(); i++) {
			if ((activityName.equalsIgnoreCase(timeSlots.get(i).getAname()))
					&& (timeslot.equalsIgnoreCase(timeSlots.get(i).getTimeslot()))) {
				registerActivities.add(new RegisterActivity(activityName, name, timeslot));
				System.out.println("*** Registration successful ***");
			}
		}
	}

	// Done by Yik Kan
	// register for an activity
	private static void viewRegisteredActivities(Users login) {
		String name = login.getName();
		String output = String.format("%-10s %-20s %-20s %-10s %-10s \n", "STUDENT", "ACTIVITY", "TIMESLOT", "APPROVAL",
				"ATTENDANCE");
		for (int i = 0; i < registerActivities.size(); i++) {
			if (name.equalsIgnoreCase(registerActivities.get(i).getUsername())) {
				output += String.format("%-10s %-20s %-20s %-10s %-10s \n", registerActivities.get(i).getUsername(),
						registerActivities.get(i).getActivityName(), registerActivities.get(i).getTimeSlot(),
						registerActivities.get(i).getApprovalStatus(), registerActivities.get(i).getAttendance());
			}
		}
		System.out.println(output);
	}

	// Done by Yik Kan
	// register for an activity
	private static void leaveActivity(Users login) {
		String name = login.getName();
		String activityName = Helper.readString("Enter activity name: ");
		String timeslot = Helper.readString("Enter timeslot(start - end): ");
		for (int i = 0; i < registerActivities.size(); i++) {
			if ((name.equalsIgnoreCase(registerActivities.get(i).getUsername()))
					&& (activityName.equalsIgnoreCase(registerActivities.get(i).getActivityName()))
					&& (timeslot.equalsIgnoreCase(registerActivities.get(i).getTimeSlot()))) {
				char confirm = Helper.readChar("Are you sure to cancel this registration(y/n): ");
				if (confirm == 'y') {
					registerActivities.remove(i);
					System.out.println("*** Registration has been deleted ***");
				} else {
					System.out.println("*** Cancellation has cancelled ***");
				}
			}
		}
	}
}
