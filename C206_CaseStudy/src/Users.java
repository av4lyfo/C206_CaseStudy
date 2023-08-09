	public class Users {	
	private String name;
    private String role;
    private String contact;

    public Users(String name, String role, String contact) {
        this.name = name;
        this.role = role;
        this.contact = contact;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Role: " + role);
		System.out.println("Contact: "+ contact);
		
	}
		
}
