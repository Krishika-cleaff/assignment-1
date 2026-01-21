package Assignment1.services;

import Assignment1.model.Asset;
import Assignment1.model.Checkout;
import Assignment1.model.Employee;
import Assignment1.model.EmployeeStatus;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CheckoutService {
    Map<String , Checkout> activeCheckout = new HashMap<>();

    private final AssetService assetService;
    private final EmployeeService employeeService;

    public CheckoutService(AssetService assetService, EmployeeService employeeService){
        this.assetService = assetService;
        this.employeeService = employeeService;
    }

    public void issueAsset(String tag, String id, int days){
        Asset asset = assetService.searchByTag(tag);
        Employee emp = employeeService.searchById(id);
        if(asset==null) {
            System.out.println("There is no asset with this tag");
        } else if (!asset.getAvailable()) {
            System.out.println("Asset is not available");
        } else if (emp == null) {
            System.out.println("There is no employee with this id");
        } else if (emp.getStatus()!= EmployeeStatus.ACTIVE) {
            System.out.println("Employee is not active");
        }else {
            if (days <= 0) {
                days = 7;
            }
            LocalDate issueDate = LocalDate.now();
            LocalDate dueDate = issueDate.plusDays(days);

            Checkout c = new Checkout(tag, id, issueDate, dueDate, null);
            activeCheckout.put(tag, c);
            asset.setAvailable(false);
            System.out.println("Asset issued successfully");
        }
    }

    public void returnAsset(String tag){
        Checkout checkout = activeCheckout.get(tag);

        if (checkout == null) {
            System.out.println("Asset is not currently issued");
            return;
        }

        checkout.setReturnDate(LocalDate.now());
        assetService.updateAvailability(tag, true);
        activeCheckout.remove(tag);
        System.out.println("Asset returned successfully");

    }

    public void getStatus(String tag){

        Checkout checkout = activeCheckout.get(tag);

        if (checkout == null) {
            System.out.println("Asset is not currently issued");
            return;
        }

        LocalDate today = LocalDate.now();
        LocalDate dueDate = checkout.getDueDate();

        long overdueDays = 0;
        int lateFee = 0;

        if (today.isAfter(dueDate)) {
            overdueDays = ChronoUnit.DAYS.between(dueDate, today);
            lateFee = (int) overdueDays * 20;
        }

        System.out.println("Asset Tag     : " + tag);
        System.out.println("Employee ID   : " + checkout.getEmployeeId());
        System.out.println("Issue Date    : " + checkout.getIssueDate());
        System.out.println("Due Date      : " + dueDate);
        System.out.println("Overdue Days  : " + overdueDays);
        System.out.println("Late Fee      : ₹" + lateFee);
    }

    public List<Checkout> listCheckouts(String id){
        List<Checkout> checkout = new ArrayList<>();

        for (Checkout c : activeCheckout.values()) {
            if (c.getEmployeeId().equalsIgnoreCase(id)) {
                checkout.add(c);
            }
        }
        return checkout;
    }
}
