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
								// addUser();

								break;
							case 2:
								// viewUsers();

								break;
							case 3:
								// deleteUser();

								break;
							case 4:
								viewRegistrations();

								break;
							case 5:
								editRegistrations();

								break;
							case 6:
								// addTimeSlot();

								break;
							case 7:
								// viewTimeSlots();

								break;
							case 8:
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
						}

					} else if (roles.equalsIgnoreCase("Teacher")) {
						displayTeacherMenu();
						int choice = optionScanner.nextInt();
						while (choice != 0) {
							switch (choice) {
							case 1:
								// addActivity();

								break;
							case 2:
								// viewActivities();

								break;
							case 3:
								// deleteActivity();

								break;
							case 4:
								viewRegistrations();

								break;
							case 5:
								editRegistrations();

								break;
							case 6:
								editAttendance();

								break;
							case 7:
								viewAttendance();

								break;
							case 0:
								System.out.println("Exiting teacher menu.");
								return;
							default:
								System.out.println("Invalid choice. Please try again.");
							}
							displayAdminMenu();
							choice = optionScanner.nextInt();
						}

					} else if (roles.equalsIgnoreCase("Student")) {
						displayStudentMenu();
						int choice = optionScanner.nextInt();
						while (choice != 0) {
							switch (choice) {
							case 1:
								// viewAvailableActivities();

								break;
							case 2:
								// registerForActivity();

								break;
							case 3:
								// viewRegisteredActivities();

								break;
							case 4:
								// leaveActivity();

								break;
							case 0:
								System.out.println("Exiting student menu.");
								return;
							default:
								System.out.println("Invalid choice. Please try again.");
							}
							displayAdminMenu();
							choice = optionScanner.nextInt();
						}

					} else {
						System.out.println("Invalid role entered.");
						System.out.print("Enter your username (or 'Leave' to leave): ");
						name = scanner.nextLine();
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
		System.out.println("4. View Registrations");
		System.out.println("5. Manage Registration Approval");
		System.out.println("6. Add Time Slot");
		System.out.println("7. View Time Slots");
		System.out.println("8. Delete Time Slot");
		System.out.println("0. Exit");
		System.out.print("Enter your choice: ");
	}

	private static void displayTeacherMenu() {
		System.out.println("\nTeacher Menu");
		System.out.println("1. Add Activity");
		System.out.println("2. View Activities");
		System.out.println("3. Delete Activity");
		System.out.println("4. View Registrations");
		System.out.println("5. Manage Registration Approval");
		System.out.println("6. Edit Attendance");
		System.out.println("7. View Attendance");
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

	public static void addUser(ArrayList<Users> users) {
		String name = Helper.readString("Enter user name > ");
		String role = Helper.readString("Enter user role > ");
		String contact = Helper.readString("Enter user contact > ");

		users.add(new Users(name, role, contact));

		users.get(users.size() - 1).display();

		System.out.println("*** User has been added ***");

	}

	public static void viewUsers(ArrayList<Users> users) {
		String output = String.format("%-10s %-15s %-20s\n", "NAME", "ROLE", "CONTACT");

		for (int i = 0; i < users.size(); i++) {

			output += String.format("%-10s %-15s %-20s\n", users.get(i).getName(), users.get(i).getRole(),
					users.get(i).getContact());

		}
		System.out.println(output);
	}

	public static boolean deleteUser(ArrayList<Users> users) {
		String name = Helper.readString("Enter user name > ");

		boolean userfound = false;

		for (int i = 0; i < users.size(); i++) {
			if (name.equalsIgnoreCase(users.get(i).getName())) {
				users.remove(i);

				char confirm = Helper.readChar("Confirm deletion (y/n) > ");

				if (confirm == 'y') {
					userfound = true;
					System.out.println("*** User has been deleted ***");
				} else {
					System.out.println("*** User is not deleted ***");
				}

			}

		}

		return userfound;
	}

	// guys please add your code based on the order of your user story and use cases

	// Done by Avinash
	// View approval statuses method
	private static void viewRegistrations() {
		for (int i = 0; i < registerActivities.size(); i++) {
			System.out.println((i + 1) + ":");
			System.out.println("Student name: " + registerActivities.get(i).getUsername());
			System.out.println("Activity: " + registerActivities.get(i).getActivityName());
			System.out.println("Timeslot: " + registerActivities.get(i).getTimeSlot());
			System.out.println("Registration status: " + registerActivities.get(i).getApprovalStatus());
		}
	}
	
	// Done by Avinash
	// Manage registration status
	private static void editRegistrations() {
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
					System.out.println("Registration updated");
				} else {
					System.out.println("Invalid approval status");
				}
			}
		}
	}

	// Done by Isaac
	// edit attendance
	private static void editAttendance() {
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
					System.out.println("Attendance updated");
				} else {
					System.out.println("Invalid status");
				}
			}
		}

		if (exist == false) {
			System.out.println("Registration not found");
		}
	}

	// Done by Isaac
	// edit attendance
	private static void viewAttendance() {
		for (int i = 0; i < registerActivities.size(); i++) {
			if (registerActivities.get(i).getApprovalStatus().equalsIgnoreCase("Approved")) {
				System.out.println((i + 1) + ":");
				System.out.println("Student name: " + registerActivities.get(i).getUsername());
				System.out.println("Activity: " + registerActivities.get(i).getActivityName());
				System.out.println("Timeslot: " + registerActivities.get(i).getTimeSlot());
				System.out.println("Attendance: " + registerActivities.get(i).getAttendance());
			}
		}
	}
}
