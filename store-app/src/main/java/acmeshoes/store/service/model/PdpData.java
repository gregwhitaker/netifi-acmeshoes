/**
 * Copyright 2019 Greg Whitaker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package acmeshoes.store.service.model;

import acmeshoes.service.inventory.protobuf.ProductInventoryResponse;
import acmeshoes.service.inventory.protobuf.SkuInventory;
import acmeshoes.service.product.protobuf.ProductInfoResponse;
import acmeshoes.service.product.protobuf.SkuInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Data required by the PDP page.
 */
public class PdpData {

    /**
     * Creates an instance of {@link PdpData} from the backend service response objects.
     *
     * @param productInfo response from product service
     * @param inventory response from inventory service
     * @return an instance of {@link PdpData}
     */
    public static PdpData from(ProductInfoResponse productInfo, ProductInventoryResponse inventory) {
        PdpData pdpData = new PdpData();
        pdpData.setProductId(productInfo.getProductId());
        pdpData.setActive(productInfo.getActive());
        pdpData.setShortName(productInfo.getShortName());
        pdpData.setLongName(productInfo.getLongName());
        pdpData.setDescription(productInfo.getDescription());

        List<PdpData.Sku> skus = new ArrayList<>();

        for (SkuInfo skuInfo : productInfo.getSkusList()) {
            PdpData.Sku sku = new PdpData.Sku();
            sku.setSku(skuInfo.getSku());
            sku.setActive(skuInfo.getActive());
            sku.setSize(skuInfo.getSize());
            sku.setUnits(0);

            for (SkuInventory skuInv : inventory.getSkusList()) {
                if (skuInv.getSku().equals(skuInfo.getSku())) {
                    sku.setUnits(skuInv.getUnits());
                    break;
                }
            }

            PdpData.Prices prices = new PdpData.Prices();
            prices.setList(skuInfo.getPrices().getFormattedList());
            prices.setMsrp(skuInfo.getPrices().getFormattedMsrp());
            prices.setSale(skuInfo.getPrices().getFormattedSale());

            sku.setPrices(prices);

            skus.add(sku);
        }

        pdpData.setSkus(skus);

        // If all skus do not have any inventory then mark the product sold out
        if (pdpData.getSkus().stream().noneMatch(sku -> sku.getUnits() > 0)) {
            pdpData.setSoldout(true);
        }

        return pdpData;
    }

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
