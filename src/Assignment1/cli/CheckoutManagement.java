package Assignment1.cli;

import Assignment1.services.CheckoutService;
import Assignment1.model.Checkout;

import java.util.List;
import java.util.Scanner;

public class CheckoutManagement {

    private final CheckoutService checkoutService;
    private final Scanner sc;

    public CheckoutManagement(CheckoutService checkoutService, Scanner sc) {
        this.checkoutService = checkoutService;
        this.sc = sc;
    }

    public void issueAsset() {
        System.out.print("Enter Asset Tag: ");
        String tag = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        String empId = sc.nextLine();

        System.out.print("Enter number of days: ");
        int days = sc.nextInt();
        sc.nextLine();

        checkoutService.issueAsset(tag, empId, days);
    }

    public void returnAsset() {
        System.out.print("Enter Asset Tag: ");
        String tag = sc.nextLine();

        checkoutService.returnAsset(tag);
    }

    public void checkStatus() {
        System.out.print("Enter Asset Tag: ");
        String tag = sc.nextLine();

        checkoutService.getStatus(tag);
    }

    public void listEmployeeCheckouts() {
        System.out.print("Enter Employee ID: ");
        String empId = sc.nextLine();

        List<Checkout> list = checkoutService.listCheckouts(empId);

        if (list.isEmpty()) {
            System.out.println("No active checkouts for this employee");
            return;
        }

        for (Checkout c : list) {
            System.out.println("Asset Tag  : " + c.getSerialTag()+", Issue Date : " + c.getIssueDate() +", Due Date : " + c.getDueDate());
        }
    }
}
