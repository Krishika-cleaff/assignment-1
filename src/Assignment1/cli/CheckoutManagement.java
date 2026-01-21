package Assignment1.cli;

import Assignment1.services.CheckoutService;

import java.util.Map;

public class CheckoutManagement {

    private final CheckoutService checkoutService;

    public CheckoutManagement(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    // ISSUE
    public void issue(Map<String, String> f) {

        String tag = f.get("--tag");
        String empId = f.get("--employee");
        int days = Integer.parseInt(
                f.getOrDefault("--days", "7")
        );

        if (tag == null || empId == null) {
            System.out.println("--tag and --employee are required");
            return;
        }

        checkoutService.issueAsset(tag, empId, days);
    }

    // RETURN
    public void returnAsset(Map<String, String> f) {

        String tag = f.get("--tag");

        if (tag == null) {
            System.out.println("--tag is required");
            return;
        }

        checkoutService.returnAsset(tag);
    }

    // STATUS
    public void status(Map<String, String> f) {

        String tag = f.get("--tag");

        if (tag == null) {
            System.out.println("--tag is required");
            return;
        }

        checkoutService.getStatus(tag);
    }

    // LIST
    public void list(Map<String, String> f) {

        String empId = f.get("--employee");

        if (empId == null) {
            System.out.println("--employee is required");
            return;
        }

        checkoutService
                .listCheckouts(empId)
                .forEach(System.out::println);
    }
}
