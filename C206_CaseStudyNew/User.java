import java.util.*;

public class User {
    private String name;
    private String role;
    private List<Registration> registrations;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
        this.registrations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void addRegistration(Registration registration) {
        registrations.add(registration);
    }

    public boolean removeRegistration(Activity activity) {
        Registration registrationToRemove = null;
        for (Registration registration : registrations) {
            if (registration.getActivity().equals(activity)) {
                registrationToRemove = registration;
                break;
            }
        }
        if (registrationToRemove != null) {
            registrations.remove(registrationToRemove);
            return true;
        }
        return false;
    }
}