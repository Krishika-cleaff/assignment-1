package Assignment1.cli;

import Assignment1.model.Asset;
import Assignment1.model.AssetCategory;
import Assignment1.model.AssetCondition;
import Assignment1.services.AssetService;

import java.util.List;
import java.util.Scanner;

public class AssetManagement {
    private final AssetService assetService;
    private final Scanner sc;

    public AssetManagement(AssetService assetService, Scanner sc) {
        this.assetService = assetService;
        this.sc = sc;
    }
    
    void addAsset(){
        System.out.println("Enter the following details:");

        System.out.println("Serial Tag:");
        String serialTag = sc.nextLine();

        System.out.println("Name:");
        String name = sc.nextLine();

        System.out.println("Category:");
        AssetCategory category = AssetCategory.valueOf(sc.nextLine().toUpperCase());

        System.out.println("Purchase year:");
        int purchaseYear = sc.nextInt();
        sc.nextLine();

        System.out.println("Condition:");
        AssetCondition condition = AssetCondition.valueOf(sc.nextLine().toUpperCase());

        assetService.addAsset(serialTag, name, category,purchaseYear, condition, true);
    }


    void listAssets() {
        System.out.print("Sort by (name/year/none): ");
        String sortBy = sc.nextLine();

        List<Asset> assets =  assetService.listAsset(sortBy);
        for(Asset a: assets){
            System.out.println("Serial Tag:"+a.getSerialTag()+ ", Name:"+ a.getName()+", Category: "+a.getCategory()+ ", Purchase year:"+ a.getPurchaseYear()+", Condition: "+ a.getCondition()+ ", Availability:" + a.getAvailable());
        }
    }

    void searchAssets(){
        System.out.print("Search by: (name / category / serialTag): ");
        String searchBy = sc.nextLine();

        if(searchBy.equalsIgnoreCase("name")){
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            List<Asset> assets =  assetService.searchByName(name);
            for(Asset a: assets){
                System.out.println("Serial Tag:"+a.getSerialTag()+ ", Name:"+ a.getName()+", Category: "+a.getCategory()+ ", Purchase year:"+ a.getPurchaseYear()+", Condition: "+ a.getCondition()+ ", Availability:" + a.getAvailable());
            }
        } else if (searchBy.equalsIgnoreCase("category")) {
            System.out.print("Enter category: ");
            String category = sc.nextLine();
            List<Asset> assets =  assetService.searchByCategory(AssetCategory.valueOf(category.toUpperCase()));
            for(Asset a: assets){
                System.out.println("Serial Tag:"+a.getSerialTag()+ ", Name:"+ a.getName()+", Category: "+a.getCategory()+ ", Purchase year:"+ a.getPurchaseYear()+", Condition: "+ a.getCondition()+ ", Availability:" + a.getAvailable());
            }
        } else if (searchBy.equalsIgnoreCase("serialTag")) {
            System.out.print("Enter Serial Tag: ");
            String serialTag = sc.nextLine();
            Asset a = assetService.searchByTag(serialTag);
            System.out.println("Serial Tag:"+a.getSerialTag()+ ", Name:"+ a.getName()+", Category: "+a.getCategory()+ ", Purchase year:"+ a.getPurchaseYear()+", Condition: "+ a.getCondition()+ ", Availability:" + a.getAvailable());
        } else {
            System.out.println("Enter a valid value");
        }

    }

    void updateAsset() {
        System.out.print(
                "Enter what you want to update: (name / category / year / condition / available): "
        );
        String toUpdate = sc.nextLine();

        System.out.print("Enter serial tag: ");
        String tag = sc.nextLine();

        if (toUpdate.equalsIgnoreCase("name")) {

            System.out.print("Enter updated name: ");
            String name = sc.nextLine();
            assetService.updateName(tag, name);

        } else if (toUpdate.equalsIgnoreCase("category")) {

            System.out.print("Enter updated category: ");
            AssetCategory category =
                    AssetCategory.valueOf(sc.nextLine().toUpperCase());
            assetService.updateCategory(tag, category);

        } else if (toUpdate.equalsIgnoreCase("year")) {

            System.out.print("Enter updated purchase year: ");
            int year = sc.nextInt();
            sc.nextLine();
            assetService.updatePurchaseYear(tag, year);

        } else if (toUpdate.equalsIgnoreCase("condition")) {

            System.out.print("Enter updated condition: ");
            AssetCondition condition =
                    AssetCondition.valueOf(sc.nextLine().toUpperCase());
            assetService.updateCondition(tag, condition);

        } else if (toUpdate.equalsIgnoreCase("available")) {

            System.out.print("Enter availability (true/false): ");
            boolean available = sc.nextBoolean();
            sc.nextLine();
            assetService.updateAvailability(tag, available);

        } else {
            System.out.println("Invalid update option");
            return;
        }

        System.out.println("Asset updated successfully.");
    }

    void deleteAsset(){
        System.out.print("Enter Serial Tag:");
        String tag = sc.nextLine();
        assetService.deleteAsset(tag);
    }

}
