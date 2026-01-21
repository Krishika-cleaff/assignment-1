package Assignment1.cli;

import Assignment1.model.*;
import Assignment1.services.EmployeeService;

import java.util.Map;

public class EmployeeManagement {

    private final EmployeeService employeeService;

    public EmployeeManagement(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ADD
    public void add(Map<String, String> f) {
        employeeService.addEmployee(
                f.get("--id"),
                f.get("--name"),
                new Email(f.get("--email")),
                EmployeeStatus.valueOf(
                        f.getOrDefault("--status", "ACTIVE")
                                .toUpperCase()
                )
        );
    }

    // LIST
    public void list(Map<String, String> f) {
        employeeService.listEmployees()
                .forEach(System.out::println);
    }

    // FIND
    public void find(Map<String, String> f) {

        if (f.containsKey("--id")) {
            System.out.println(
                    employeeService.searchById(f.get("--id"))
            );

        } else if (f.containsKey("--name")) {
            employeeService.searchByName(f.get("--name"))
                    .forEach(System.out::println);

        } else {
            System.out.println("Provide --id or --name to search");
        }
    }

    // UPDATE
    public void update(Map<String, String> f) {

        String id = f.get("--id");
        if (id == null) {
            System.out.println("--id is required for update");
            return;
        }

        if (f.containsKey("--name"))
            employeeService.updateName(id, f.get("--name"));

        if (f.containsKey("--email"))
            employeeService.updateEmail(id,
                    new Email(f.get("--email")));

        if (f.containsKey("--status"))
            employeeService.updateStatus(id,
                    EmployeeStatus.valueOf(
                            f.get("--status").toUpperCase()
                    ));

    }

    // DELETE
    public void delete(Map<String, String> f) {
        employeeService.deleteEmployee(f.get("--id"));
        System.out.println("Employee deleted successfully");
    }
}
