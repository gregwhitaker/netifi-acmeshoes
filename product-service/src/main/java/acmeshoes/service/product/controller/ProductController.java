package acmeshoes.service.product.controller;

import acmeshoes.service.product.protobuf.ProductInfoRequest;
import acmeshoes.service.product.protobuf.ProductInfoResponse;
import acmeshoes.service.product.protobuf.ProductService;
import io.netty.buffer.ByteBuf;
import reactor.core.publisher.Mono;

public class ProductController implements ProductService {

    @Override
    public Mono<ProductInfoResponse> getProductInfo(ProductInfoRequest message, ByteBuf metadata) {
        return null;
    }
}
