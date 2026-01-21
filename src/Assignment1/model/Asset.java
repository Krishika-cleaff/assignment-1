package Assignment1.model;

public class Asset {
    private String serialTag;
    private String name;
    private AssetCategory category;
    private int purchaseYear;
    private AssetCondition condition;
    private boolean available;

    public Asset(String serialTag, String name, AssetCategory category,
                 int purchaseYear, AssetCondition condition, boolean available) {
        this.serialTag = serialTag;
        this.name = name;
        this.category = category;
        this.purchaseYear = purchaseYear;
        this.condition = condition;
        this.available = available;
    }

    // getters
    public String getSerialTag() {
        return serialTag;
    }

    public String getName() {
        return name;
    }

    public AssetCategory getCategory() {
        return category;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

    public AssetCondition getCondition() {
        return condition;
    }

    public boolean getAvailable() {
        return available;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(AssetCategory category) {
        this.category = category;
    }

    public void setPurchaseYear(int purchaseYear) {
        this.purchaseYear = purchaseYear;
    }

    public void setCondition(AssetCondition condition) {
        this.condition = condition;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "serialTag='" + serialTag + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", purchaseYear=" + purchaseYear +
                ", condition=" + condition +
                ", available=" + available +
                '}';
    }

}

