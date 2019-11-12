package acmeshoes.service.inventory.api;

import acmeshoes.service.inventory.protobuf.InventoryService;
import acmeshoes.service.inventory.protobuf.ProductInventoryRequest;
import acmeshoes.service.inventory.protobuf.ProductInventoryResponse;
import acmeshoes.service.inventory.protobuf.SkuInventoryRequest;
import acmeshoes.service.inventory.protobuf.SkuInventoryResponse;
import io.netty.buffer.ByteBuf;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class InventoryServiceImpl implements InventoryService {

    @Override
    public Mono<ProductInventoryResponse> getProductInventory(ProductInventoryRequest message, ByteBuf metadata) {
        return null;
    }

    @Override
    public Mono<SkuInventoryResponse> getSkuInventory(SkuInventoryRequest message, ByteBuf metadata) {
        return null;
    }
}
