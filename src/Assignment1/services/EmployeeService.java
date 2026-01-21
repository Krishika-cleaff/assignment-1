package Assignment1.services;

import Assignment1.model.Employee;
import Assignment1.model.Email;
import Assignment1.model.EmployeeStatus;

import java.util.*;

public class EmployeeService {

    Map<String, Employee> employeeMap = new HashMap<>();

    public void addEmployee(String id, String name, Email email, EmployeeStatus status) {

        if (id == null || id.isBlank()) {
            System.out.println("Employee ID cannot be empty");
            return;
        }

        if (!id.matches("E\\d{4}")) {
            System.out.println("Employee ID must be in format E0001");
            return;
        }

        if (employeeMap.containsKey(id)) {
            System.out.println("Employee with this ID already exists");
            return;
        }

        if (name == null || name.isBlank()) {
            System.out.println("Employee name cannot be empty");
            return;
        }

        if (email == null) {
            System.out.println("Email cannot be null");
            return;
        }

        if (status == null) {
            System.out.println("Employee status cannot be null");
            return;
        }

        Employee employee = new Employee(id, name, email, status);
        employeeMap.put(id, employee);

        System.out.println("Employee is successfully added");
    }

    public List<Employee> listEmployees() {

        if (employeeMap.isEmpty()) {
            System.out.println("No employees available");
            return new ArrayList<>();
        }

        return new ArrayList<>(employeeMap.values());
    }

    public Employee searchById(String id) {
        Employee employee = employeeMap.get(id);

        if (employee == null) {
            System.out.println("Employee not found with ID: " + id);
        }

        return employee;
    }

    public List<Employee> searchByName(String name) {
        List<Employee> result = new ArrayList<>();

        if (name == null || name.isBlank()) {
            return result;
        }

        for (Employee e : employeeMap.values()) {
            if (e.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(e);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No employees found with name: " + name);
        }

        return result;
    }

    public void updateName(String id, String newName) {
        Employee employee = employeeMap.get(id);

        if (employee == null) {
            System.out.println("Employee not found with ID: " + id);
            return;
        }

        if (newName == null || newName.isBlank()) {
            System.out.println("Name cannot be empty");
            return;
        }

        employee.setName(newName);
        System.out.println("Employee name updated successfully");
    }

    public void updateEmail(String id, Email newEmail) {
        Employee employee = employeeMap.get(id);

        if (employee == null) {
            System.out.println("Employee not found with ID: " + id);
            return;
        }

        if (newEmail == null) {
            System.out.println("Email cannot be null");
            return;
        }

        employee.setEmail(newEmail);
        System.out.println("Employee email updated successfully");
    }

    public void updateStatus(String id, EmployeeStatus status) {
        Employee employee = employeeMap.get(id);

        if (employee == null) {
            System.out.println("Employee not found with ID: " + id);
            return;
        }

        if (status == null) {
            System.out.println("Status cannot be null.");
            return;
        }

        employee.setStatus(status);
        System.out.println("Employee status updated successfully.");
    }

    public void deleteEmployee(String id) {

        if (!employeeMap.containsKey(id)) {
            System.out.println("Employee not found with ID: " + id);
            return;
        }

        employeeMap.remove(id);
        System.out.println("Employee deleted successfully.");
    }
}
