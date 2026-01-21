

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

