import java.util.*;

public class CCASystem {
	private static List<Users> users = new ArrayList<>();
	private static List<Activities> activities = new ArrayList<>();
	private static List<RegisterActivity> registerActivities = new ArrayList<>();

	public static void main(String[] args) {
		users.add(new Users("John", "Administrator", "8765 4321"));
		users.add(new Users("Zhi Yang", "Student", " 9876 5643"));
		users.add(new Users("Benedict", "Teacher", "9254 5432"));
		users.add(new Users("Yik Kan", "Student", "8653 3654"));

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
	
	public static void addUser(ArrayList<Users> users) {
		String name = Helper.readString("Enter user name > ");
		String role = Helper.readString("Enter user role > ");
		String contact = Helper.readString("Enter user contact > ");

		users.add(new Users(name, role, contact));
		
	
		users.get(users.size()-1).display();

	
		System.out.println("*** User has been added ***");


	}
	
	public static void viewUsers(ArrayList<Users> users) {
		String output = String.format("%-10s %-15s %-20s\n", "NAME", "ROLE", "CONTACT");
		
		for (int i = 0; i < users.size(); i++) {
			
			output += String.format("%-10s %-15s %-20s\n", users.get(i).getName(),
					users.get(i).getRole(), users.get(i).getContact());
					
					
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
	
	
	
	
	
	
	
	
	
	// List to store approval statuses
	private static List<String> approvalStatuses = new ArrayList<>();

	// Add approval status method
	private static void addApprovalStatus() {
	  String newStatus = Helper.readString("Enter new approval status: ");
	  approvalStatuses.add(newStatus);
	  System.out.println("Approval status added: " + newStatus); 
	}

	// View approval statuses method
	private static void viewApprovalStatuses() {
	  System.out.println("Approval Statuses:");
	  for (String status : approvalStatuses) {
	    System.out.println(status);
	  }
	}

	// Delete approval status method  
	private static void deleteApprovalStatus() {
	  String statusToDelete = Helper.readString("Enter approval status to delete: ");
	  if (approvalStatuses.contains(statusToDelete)) {
	    approvalStatuses.remove(statusToDelete);
	    System.out.println("Approval status deleted: " + statusToDelete);
	  } else {
	    System.out.println("Approval status not found.");
	  }
	}

	// Update approval status method
	private static void updateApprovalStatus() {
	  String oldStatus = Helper.readString("Enter approval status to update: ");
	  String newStatus = Helper.readString("Enter new approval status: ");
	  
	  int index = approvalStatuses.indexOf(oldStatus);
	  if (index != -1) {
	    approvalStatuses.set(index, newStatus);
	    System.out.println("Approval status updated from " + oldStatus + " to " + newStatus);
	  } else {
	    System.out.println("Approval status not found.");
	  }
	}}
	


	
	



