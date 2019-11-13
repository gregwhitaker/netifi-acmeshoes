package acmeshoes.service.inventory.data.model;

/**
 * Inventory information for a single product SKU.
 */
public class SkuInventory {

    private String sku;
    private int units;

    public SkuInventory() {}

    public SkuInventory(String sku, int units) {
        this.sku = sku;
        this.units = units;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
