package acmeshoes.service.inventory.data;

import acmeshoes.service.inventory.data.model.SkuInventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DefaultSkuInventoryRepository implements SkuInventoryRepository {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultSkuInventoryRepository.class);

    @Override
    public Flux<SkuInventory> findAll(String productId) {
        return null;
    }

    @Override
    public Mono<SkuInventory> findOne(String skuId) {
        return null;
    }
}
