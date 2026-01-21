        package Assignment1.cli;

        import Assignment1.services.AssetService;
        import Assignment1.model.*;
        import Assignment1.services.CheckoutService;
        import Assignment1.services.EmployeeService;

        import java.util.Scanner;

        public class EmployeeAssetManagementCLI {

            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                AssetService assetService = new AssetService();
                EmployeeService employeeService = new EmployeeService();
                CheckoutService checkoutService =
                        new CheckoutService(assetService, employeeService);

                AssetManagement assetCLI = new AssetManagement(assetService, sc);
                EmployeeManagement EmployeeManagement = new EmployeeManagement(employeeService, sc);
                CheckoutManagement CheckoutManagement = new CheckoutManagement(checkoutService, sc);


                while (true) {
                    System.out.println("\nASSET MANAGEMENT SYSTEM");
                    System.out.println("1. Asset Menu");
                    System.out.println("2. Employee Menu");
                    System.out.println("3. Checkout Menu");
                    System.out.println("0. Exit");

                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1 -> assetMenu(assetCLI, sc);
                        case 2 -> employeeMenu(EmployeeManagement, sc);
                        case 3 -> checkoutMenu(CheckoutManagement, sc);
                        case 0 -> {
                            System.out.println("Goodbye!");
                            return;
                        }
                        default -> System.out.println("Invalid choice");
                    }
                }
            }

            private static void assetMenu(AssetManagement cli, Scanner sc) {
                System.out.println("1. Add  2. List  3. Search  4. Update  5. Delete");
                int c = sc.nextInt();
                sc.nextLine();

                switch (c) {
                    case 1 -> cli.addAsset();
                    case 2 -> cli.listAssets();
                    case 3 -> cli.searchAssets();
                    case 4 -> cli.updateAsset();
                    case 5 -> cli.deleteAsset();
                    default -> System.out.println("Invalid choice");
                }
            }

            private static void employeeMenu(EmployeeManagement cli, Scanner sc) {
               System.out.println("1. Add  2. List  3. Search  4. Update  5. Delete");
                int c = sc.nextInt();
                sc.nextLine();
                 switch (c) {
                    case 1 -> cli.addEmployee();
                    case 2 -> cli.listEmployees();
                    case 3 -> cli.searchEmployee();
                    case 4 -> cli.updateEmployee();
                    case 5 -> cli.deleteEmployee();
                     default -> System.out.println("Invalid choice");
                    }
                }
                private static void checkoutMenu(CheckoutManagement cli, Scanner sc) {
                    System.out.println("1. Issue  2. Return  3. Status  4. List ");

                    int c = sc.nextInt();
                    sc.nextLine();

                    switch (c) {
                        case 1 -> cli.issueAsset();
                        case 2 -> cli.returnAsset();
                        case 3 -> cli.checkStatus();
                        case 4 -> cli.listEmployeeCheckouts();
                        default -> System.out.println("Invalid choice");
                    }
                }
        }
