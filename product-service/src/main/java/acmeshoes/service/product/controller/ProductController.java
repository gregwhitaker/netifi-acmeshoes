package acmeshoes.service.product.controller;

import acmeshoes.service.product.protobuf.ProductInfoRequest;
import acmeshoes.service.product.protobuf.ProductInfoResponse;
import acmeshoes.service.product.protobuf.ProductService;
import io.netty.buffer.ByteBuf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * Controller responsible for returning product information.
 */
@Component
public class ProductController implements ProductService {

    @Autowired
    private acmeshoes.service.product.service.ProductService ps;

    @Override
    public Mono<ProductInfoResponse> getProductInfo(ProductInfoRequest message, ByteBuf metadata) {
        return null;
    }
}
