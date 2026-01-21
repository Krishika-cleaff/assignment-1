package Assignment1.model;

import java.time.LocalDate;

public class Checkout {
    private String serialTag;
    private String employeeId;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public Checkout(String serialTag, String employeeId, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate){
        this.serialTag = serialTag;
        this.employeeId = employeeId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setSerialTag(String serialTag) {
        this.serialTag = serialTag;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getSerialTag() {
        return serialTag;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "assetTag='" + serialTag + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                '}';
    }

}
