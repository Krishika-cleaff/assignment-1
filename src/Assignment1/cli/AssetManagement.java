package Assignment1.cli;

import Assignment1.model.*;
import Assignment1.services.AssetService;

import java.util.Map;

public class AssetManagement {

    private final AssetService assetService;

    public AssetManagement(AssetService assetService) {
        this.assetService = assetService;
    }

    // ADD
    public void add(Map<String, String> f) {
        assetService.addAsset(
                f.get("--tag"),
                f.get("--name"),
                AssetCategory.valueOf(f.get("--category")),
                Integer.parseInt(f.get("--year")),
                AssetCondition.valueOf(f.get("--condition")),
                true
        );
    }

    // LIST
    public void list(Map<String, String> f) {
        assetService
                .listAsset(f.getOrDefault("--sort", "none"))
                .forEach(System.out::println);
    }

    // FIND
    public void find(Map<String, String> f) {
        if (f.containsKey("--tag")) {
            System.out.println(assetService.searchByTag(f.get("--tag")));
        } else if (f.containsKey("--name")) {
            assetService.searchByName(f.get("--name"))
                    .forEach(System.out::println);
        } else if (f.containsKey("--category")) {
            assetService.searchByCategory(
                            AssetCategory.valueOf(f.get("--category")))
                    .forEach(System.out::println);
        } else {
            System.out.println("No valid search flag provided");
        }
    }

    // UPDATE
    public void update(Map<String, String> f) {
        String tag = f.get("--tag");

        if (tag == null) {
            System.out.println("--tag is required for update");
            return;
        }

        if (f.containsKey("--name"))
            assetService.updateName(tag, f.get("--name"));

        if (f.containsKey("--category"))
            assetService.updateCategory(tag,
                    AssetCategory.valueOf(f.get("--category")));

        if (f.containsKey("--year"))
            assetService.updatePurchaseYear(tag,
                    Integer.parseInt(f.get("--year")));

        if (f.containsKey("--condition"))
            assetService.updateCondition(tag,
                    AssetCondition.valueOf(f.get("--condition")));
    }

    // DELETE
    public void delete(Map<String, String> f) {
        assetService.deleteAsset(f.get("--tag"));
    }
}
