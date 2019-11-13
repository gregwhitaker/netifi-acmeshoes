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
package acmeshoes.service.inventory.service;

import acmeshoes.service.inventory.data.SkuInventoryRepository;
import acmeshoes.service.inventory.data.model.SkuInventory;
import acmeshoes.service.inventory.service.error.ProductNotFoundException;
import acmeshoes.service.inventory.service.error.SkuNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service that retrieves inventory information for products and SKUs.
 */
@Service
public class InventoryService {
    private static final Logger LOG = LoggerFactory.getLogger(InventoryService.class);

    @Autowired
    private SkuInventoryRepository repo;

    /**
     * Get the inventory for all SKUs in a product line.
     *
     * @param productId product id
     * @return the inventory of each SKU in the product line
     */
    public Flux<SkuInventory> getProductInventory(String productId) {
        return getProductInventory(productId, true);
    }

    /**
     * Get the inventory for all SKUs in a product line.
     *
     * @param productId product id
     * @param showSoldOut if <code>true</code> then return entries for SKUs that are sold out; otherwise
     *                    they are not returned
     * @return the inventory of each SKU in the product line
     */
    public Flux<SkuInventory> getProductInventory(String productId, boolean showSoldOut) {
        return repo.findAll(productId)
                .switchIfEmpty(s -> s.onError(new ProductNotFoundException(productId)))
                .filter(skuInventory -> {
                    // Check to see if we need to filter out skus that are sold out
                    if (skuInventory.getUnits() <= 0) {
                        return showSoldOut;
                    }

                    return true;
                });
    }

    /**
     * Get the inventory for a single SKU.
     *
     * @param sku sku id
     * @return the inventory of the SKU
     */
    public Mono<SkuInventory> getInventoryForSku(String sku) {
        return repo.findOne(sku)
                .switchIfEmpty(Mono.error(new SkuNotFoundException(sku)));
    }
}
