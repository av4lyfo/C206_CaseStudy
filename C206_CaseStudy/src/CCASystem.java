import java.util.*;

public class CCASystem {
	private static List<User> users = new ArrayList<>();
	private static List<Activity> activities = new ArrayList<>();

	public static void main(String[] args) {
		users.add(new User("John", "Administrator"));
		users.add(new User("Zhi Yang", "Teacher"));
		users.add(new User("Benedict", "Teacher"));
		users.add(new User("Yik Kan", "Student"));

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your username (or 'Leave' to leave): ");
		String name = scanner.nextLine();

		Scanner optionScanner = new Scanner(System.in);

		while (!name.equalsIgnoreCase("Leave")) {
			for (int i = 0; i < users.size(); i++) {
				User login = users.get(i);
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
								// addApprovalStatus();

								break;
							case 5:
								// viewApprovalStatuses();

								break;
							case 6:
								// deleteApprovalStatus();

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
								// updateApprovalStatus();

								break;
							case 5:
								// addAttendance();

								break;
							case 6:
								// viewAttendance();

								break;
							case 7:
								// deleteAttendance();

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

}
