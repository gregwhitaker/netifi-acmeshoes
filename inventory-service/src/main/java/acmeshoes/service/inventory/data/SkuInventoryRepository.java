package acmeshoes.service.inventory.data;

import acmeshoes.service.inventory.data.model.SkuInventory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SkuInventoryRepository {

    Flux<SkuInventory> findAll(String productId);

    Mono<SkuInventory> findOne(String skuId);
}
