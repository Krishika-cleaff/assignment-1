package Assignment1.model;

public class Employee {

    private String id;
    private String name;
    private Email email;
    private EmployeeStatus status;

    public Employee(String id, String name, Email email, EmployeeStatus status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email=" + email.value() +
                ", status=" + status +
                '}';
    }
}
