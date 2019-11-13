package acmeshoes.service.inventory.service;

import acmeshoes.service.inventory.data.SkuInventoryRepository;
import acmeshoes.service.inventory.data.model.SkuInventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InventoryService {
    private static final Logger LOG = LoggerFactory.getLogger(InventoryService.class);

    @Autowired
    private SkuInventoryRepository repo;

    public Flux<SkuInventory> getProductInventory(String productId) {
        return getProductInventory(productId, true);
    }

    public Flux<SkuInventory> getProductInventory(String productId, boolean showSoldOut) {
        return repo.findAll(productId)
                .filter(skuInventory -> {
                    // Check to see if we need to filter out skus that are sold out
                    if (skuInventory.getUnits() <= 0) {
                        return showSoldOut;
                    }

                    return true;
                });
    }

    public Mono<SkuInventory> getInventoryForSku(String skuId) {
        return repo.findOne(skuId);
    }
}
