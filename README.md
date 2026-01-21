

# Employee Asset Management System (CLI – Java)

A **command-line Java application** to manage **Assets**, **Employees**, and **Checkouts**.  

---

## Features

### Asset Management
- Add new assets
- List assets (with optional sorting)
- Search assets by:
  - Name
  - Category
  - Serial Tag
- Update asset details
- Delete assets

---

### Employee Management
- Add employees
- List employees
- Search employees by ID or name
- Update employee details
- Delete employees

---

### Checkout Management
- Issue asset to an employee
- Return an issued asset
- View checkout status
- List all checkouts for an employee

---

## Project Structure
```
src/
└── Assignment1/
  ├── cli/
  │ ├── AssetManagement.java
  │ ├── EmployeeManagement.java
  │ ├── CheckoutManagement.java
  │ └── EmployeeAssetManagementCLI.java
  │
  ├── model/
  │ ├── Asset.java
  │ ├── Employee.java
  │ ├── Checkout.java
  │ ├── Email.java
  │ ├── AssetCategory.java
  │ ├── AssetCondition.java
  │ └── EmployeeStatus.java
  │
  └── services/
    ├── AssetService.java
    ├── EmployeeService.java
    └── CheckoutService.java

```


---

## How to Run

1. Open the project in **IntelliJ IDEA**
2. Navigate to:
```

cli/EmployeeAssetManagementCLI.java

```
3. Run the `main()` method
4. Use the menu to manage assets, employees, and checkouts

---

## Sample Commands
```
asset add --tag A-1001 --name MacBook --category LAPTOP --year 2022 --condition GOOD
asset list --sort name
asset find --tag A-1001
asset update --tag A-1001 --condition DAMAGED
asset delete --tag A-1001

employee add --id E0001 --name krishika --email krishik@ag.com --status ACTIVE
employee list
employee update --id E0001 --status INACTIVE

checkout issue --tag A-1001 --employee E0001 --days 10
checkout status --tag A-1001
checkout return --tag A-1001
checkout list --employee E0001

```

