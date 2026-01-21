package Assignment1.services;

import Assignment1.model.*;

import java.util.*;

public class AssetService {
    Map<String, Asset> assetMap = new HashMap<>();

    public void addAsset(String serialTag, String name, AssetCategory category,
                         int purchaseYear, AssetCondition condition, boolean available){

        if (serialTag == null) {
            System.out.println("Serial Tag cannot be empty.");
            return;
        }

        if (assetMap.containsKey(serialTag)){
            System.out.println("Asset with this serial tag exists");
            return;
        }

        int currentYear = java.time.Year.now().getValue();
        if (purchaseYear < 2000 || purchaseYear > currentYear) {
            System.out.println("Invalid purchase year.");
            return;
        }

        Asset a1 = new Asset(serialTag, name, category, purchaseYear, condition, available);
        assetMap.put(serialTag, a1);
        System.out.println("Asset is successfully added");
    }

    public List<Asset> listAsset(String sortBy){

        if (assetMap.isEmpty()) {
            System.out.println("No assets available.");
            return new ArrayList<>();
        }

        List<Asset> assets = new ArrayList<>(assetMap.values());

        if(Objects.equals(sortBy, "name")){
            assets.sort(Comparator.comparing(Asset::getName));
        }
        else if(Objects.equals(sortBy, "year")){
            assets.sort(Comparator.comparing(Asset::getPurchaseYear));
        }
        return assets;
    }

    public Asset searchByTag(String tag){
        Asset asset = assetMap.get(tag);
        if (asset == null) {
            System.out.println("No asset found with tag: " + tag);
        }
        return asset;
    }

    public List<Asset> searchByName(String name){
        List<Asset> assets = new ArrayList<>();

        if (name == null || name.trim().isEmpty()) {
            return assets;
        }

        for (Asset asset : assetMap.values()) {
            if (asset.getName().toLowerCase().contains(name.toLowerCase())) {
                assets.add(asset);
            }
        }
        return assets;
    }

    public List<Asset> searchByCategory(AssetCategory category){
        List<Asset> assets = new ArrayList<>();

        for (Asset asset : assetMap.values()) {
            if (asset.getCategory() == category) {
                assets.add(asset);
            }
        }

        if (assets.isEmpty()) {
            System.out.println("No assets found for category: " + category);
        }

        return assets;
    }

    public void updateName(String serialTag, String name) {
        Asset asset = assetMap.get(serialTag);
        if (asset == null) {
            System.out.println("Asset not found with serial tag: " + serialTag);
            return;
        }
        asset.setName(name);
        System.out.println("Asset name updated successfully");
    }

    public void updateCategory(String serialTag, AssetCategory category) {
        Asset asset = assetMap.get(serialTag);
        if (asset == null) {
            System.out.println("Asset not found with serial tag: " + serialTag);
            return;
        }
        asset.setCategory(category);
        System.out.println("Asset category updated successfully");
    }

    public void updatePurchaseYear(String serialTag, int year) {
        Asset asset = assetMap.get(serialTag);
        if (asset == null) {
            System.out.println("Asset not found with serial tag: " + serialTag);
            return;
        }
        asset.setPurchaseYear(year);
        System.out.println("Purchase year updated successfully");
    }

    public void updateCondition(String serialTag, AssetCondition condition) {
        Asset asset = assetMap.get(serialTag);
        if (asset == null) {
            System.out.println("Asset not found with serial tag: " + serialTag);
            return;
        }
        asset.setCondition(condition);
        System.out.println("Asset condition updated successfully");
    }

    public void updateAvailability(String serialTag, boolean available) {
        Asset asset = assetMap.get(serialTag);
        if (asset == null) {
            System.out.println("Asset not found with serial tag: " + serialTag);
            return;
        }
        asset.setAvailable(available);
    }

    public void deleteAsset(String serialTag) {
        if (!assetMap.containsKey(serialTag)) {
            System.out.println("Asset not found with serial tag: " + serialTag);
            return;
        }
        assetMap.remove(serialTag);
        System.out.println("Asset deleted successfully.");
    }

}
