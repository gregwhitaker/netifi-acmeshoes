package acmeshoes.store.service.model;

import java.util.List;

public class PdpData {
    private String productId;
    private boolean active;
    private boolean soldout = false;
    private String shortName;
    private String longName;
    private String description;
    private List<Sku> skus;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isSoldout() {
        return soldout;
    }

    public void setSoldout(boolean soldout) {
        this.soldout = soldout;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public static class Sku {
        private String sku;
        private boolean active;
        private String size;
        private int units;
        private Prices prices;

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public int getUnits() {
            return units;
        }

        public void setUnits(int units) {
            this.units = units;
        }

        public Prices getPrices() {
            return prices;
        }

        public void setPrices(Prices prices) {
            this.prices = prices;
        }
    }

    public static class Prices {
        private String list;
        private String msrp;
        private String sale;

        public String getList() {
            return list;
        }

        public void setList(String list) {
            this.list = list;
        }

        public String getMsrp() {
            return msrp;
        }

        public void setMsrp(String msrp) {
            this.msrp = msrp;
        }

        public String getSale() {
            return sale;
        }

        public void setSale(String sale) {
            this.sale = sale;
        }
    }
}
