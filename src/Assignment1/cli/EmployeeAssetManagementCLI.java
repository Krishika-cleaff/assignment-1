package Assignment1.cli;

import Assignment1.model.*;
import Assignment1.services.*;

import java.util.*;

public class EmployeeAssetManagementCLI {

    private static AssetManagement assetManagement;
    private static EmployeeManagement employeeManagement;
    private static CheckoutManagement checkoutManagement;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AssetService assetService = new AssetService();
        assetManagement = new AssetManagement(assetService);

        EmployeeService employeeService = new EmployeeService();
        employeeManagement = new EmployeeManagement(employeeService);

        CheckoutService checkoutService =
                new CheckoutService(assetService, employeeService);
        checkoutManagement = new CheckoutManagement(checkoutService);

        System.out.println("Asset Management System (type 'exit' to quit)");

        while (true) {
            System.out.print("> ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            if (input.isBlank()) continue;

            try {
                handleCommand(input);
            } catch (Exception e) {
                System.out.println("Invalid command or arguments");
            }
        }
    }

    // ---------------- COMMAND ROUTER ----------------

    private static void handleCommand(String input) {

        String[] tokens = input.split("\\s+");

        if (tokens.length < 2) {
            System.out.println("Invalid command");
            return;
        }

        String entity = tokens[0];
        String action = tokens[1];

        switch (entity.toLowerCase()) {
            case "asset" -> handleAsset(action, tokens);
            case "employee" -> handleEmployee(action, tokens);
            case "checkout" -> handleCheckout(action, tokens);
            default -> System.out.println("Unknown command");
        }
    }

    // ---------------- FLAG PARSER ----------------

    private static Map<String, String> parseFlags(String[] tokens) {
        Map<String, String> map = new HashMap<>();
        for (int i = 2; i < tokens.length - 1; i += 2) {
            map.put(tokens[i], tokens[i + 1]);
        }
        return map;
    }

    // ================= ASSET =================

    private static void handleAsset(String action, String[] tokens) {
        Map<String, String> f = parseFlags(tokens);

        switch (action) {
            case "add" -> assetManagement.add(f);
            case "list" -> assetManagement.list(f);
            case "find" -> assetManagement.find(f);
            case "update" -> assetManagement.update(f);
            case "delete" -> assetManagement.delete(f);
            default -> System.out.println("Invalid asset command");
        }
    }

    private static void handleEmployee(String action, String[] tokens) {

        Map<String, String> f = parseFlags(tokens);

        switch (action) {
            case "add" -> employeeManagement.add(f);
            case "list" -> employeeManagement.list(f);
            case "find" -> employeeManagement.find(f);
            case "update" -> employeeManagement.update(f);
            case "delete" -> employeeManagement.delete(f);
            default -> System.out.println("Invalid employee command");
        }
    }

    private static void handleCheckout(String action, String[] tokens) {

        Map<String, String> f = parseFlags(tokens);

        switch (action) {
            case "issue" -> checkoutManagement.issue(f);
            case "return" -> checkoutManagement.returnAsset(f);
            case "status" -> checkoutManagement.status(f);
            case "list" -> checkoutManagement.list(f);
            default -> System.out.println("Invalid checkout command");
        }
    }
}
