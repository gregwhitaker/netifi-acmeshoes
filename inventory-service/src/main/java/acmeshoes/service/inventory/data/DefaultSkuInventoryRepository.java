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
package acmeshoes.service.inventory.data;

import acmeshoes.service.inventory.data.model.SkuInventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
public class DefaultSkuInventoryRepository implements SkuInventoryRepository {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultSkuInventoryRepository.class);

    private final Map<String, List<SkuInventory>> productInventory = new HashMap<>();
    private final Map<String, SkuInventory> skuInventory = new HashMap<>();

    @PostConstruct
    public void init() {
        LOG.info("Initializing Dummy Products...");

        final Random rand = new Random(System.currentTimeMillis());

        // Initialize the inventory with 10 dummy products
        for (int i = 1; i <= 10; i++) {
            final List<SkuInventory> invs = new ArrayList<>();
            final String productId = String.format("%03d", i);

            LOG.info("Initializing Product: {}", productId);

            for (int x = 0; x < 3; x++) {
                SkuInventory s = new SkuInventory();
                s.setSku(productId + "-" + String.format("%03d", x));
                s.setUnits(rand.nextInt((100) + 1));

                invs.add(s);
                skuInventory.put(s.getSku(), s);
            }

            productInventory.put(productId, invs);
        }

        LOG.info("Initialization Complete");
    }

    @Override
    public Flux<SkuInventory> findAll(String productId) {
        if (productInventory.containsKey(productId)) {
            return Flux.fromIterable(productInventory.get(productId));
        } else {
            return Flux.empty();
        }
    }

    @Override
    public Mono<SkuInventory> findOne(String sku) {
        if (skuInventory.containsKey(sku)) {
            return Mono.fromSupplier(() -> skuInventory.get(sku));
        } else {
            return Mono.empty();
        }
    }
}
