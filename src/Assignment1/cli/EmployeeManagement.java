package Assignment1.cli;


import Assignment1.model.Email;
import Assignment1.model.Employee;
import Assignment1.model.EmployeeStatus;
import Assignment1.services.EmployeeService;

import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    private final EmployeeService employeeService;
    private final Scanner sc;

    public EmployeeManagement(EmployeeService employeeService, Scanner sc) {
        this.employeeService = employeeService;
        this.sc = sc;
    }

    public void addEmployee() {

        System.out.print("Enter Employee ID ( Format - E0001): ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String emailInput = sc.nextLine();
        Email email = new Email(emailInput);

        System.out.print("Enter Status (ACTIVE / INACTIVE): ");
        EmployeeStatus status =
                EmployeeStatus.valueOf(sc.nextLine().toUpperCase());

        employeeService.addEmployee(id, name, email, status);
    }

    public void listEmployees() {

        List<Employee> employees = employeeService.listEmployees();

        for (Employee e : employees) {
            System.out.println(
                    "ID: " + e.getId()
                            + ", Name: " + e.getName()
                            + ", Email: " + e.getEmail().value()
                            + ", Status: " + e.getStatus()
            );
        }
    }

    public void searchEmployee() {

        System.out.print("Search by (id / name): ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("id")) {

            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();

            Employee e = employeeService.searchById(id);

            if (e != null) {
                System.out.println(
                        "ID: " + e.getId()
                                + ", Name: " + e.getName()
                                + ", Email: " + e.getEmail().value()
                                + ", Status: " + e.getStatus()
                );
            }

        } else if (choice.equalsIgnoreCase("name")) {

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            List<Employee> employees = employeeService.searchByName(name);

            for (Employee e : employees) {
                System.out.println(
                        "ID: " + e.getId()
                                + ", Name: " + e.getName()
                                + ", Email: " + e.getEmail().value()
                                + ", Status: " + e.getStatus()
                );
            }

        } else {
            System.out.println("Invalid search option");
        }
    }

    public void updateEmployee() {

        System.out.print(
                "Update what? (name / email / status): "
        );
        String choice = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        if (choice.equalsIgnoreCase("name")) {

            System.out.print("Enter new name: ");
            String newName = sc.nextLine();

            employeeService.updateName(id, newName);

        } else if (choice.equalsIgnoreCase("email")) {

            System.out.print("Enter new email: ");
            Email email = new Email(sc.nextLine());

            employeeService.updateEmail(id, email);

        } else if (choice.equalsIgnoreCase("status")) {

            System.out.print("Enter status (ACTIVE / INACTIVE): ");
            EmployeeStatus status =
                    EmployeeStatus.valueOf(sc.nextLine().toUpperCase());

            employeeService.updateStatus(id, status);

        } else {
            System.out.println("Invalid update option");
        }
    }

    public void deleteEmployee() {

        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        employeeService.deleteEmployee(id);
    }
}
