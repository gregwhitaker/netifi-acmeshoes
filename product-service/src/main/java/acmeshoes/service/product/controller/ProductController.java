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
package acmeshoes.service.product.controller;

import acmeshoes.service.product.protobuf.PriceInfo;
import acmeshoes.service.product.protobuf.ProductInfoRequest;
import acmeshoes.service.product.protobuf.ProductInfoResponse;
import acmeshoes.service.product.protobuf.ProductService;
import acmeshoes.service.product.protobuf.SkuInfo;
import io.netty.buffer.ByteBuf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller responsible for returning product information.
 */
@Component
public class ProductController implements ProductService {

    @Autowired
    private acmeshoes.service.product.service.ProductService ps;

    @Override
    public Mono<ProductInfoResponse> getProductInfo(ProductInfoRequest message, ByteBuf metadata) {
        return ps.getProduct(message.getProductId())
                .map(productInfo -> {
                    List<SkuInfo> skuInfos = new ArrayList<>();
                    productInfo.getSkus().forEach(si -> skuInfos.add(SkuInfo.newBuilder()
                            .setSku(si.getSku())
                            .setActive(si.isActive())
                            .setSize(si.getSize())
                            .setPrices(PriceInfo.newBuilder()
                                    .setList(si.getPrices().getList())
                                    .setMsrp(si.getPrices().getMsrp())
                                    .setSale(si.getPrices().getSale())
                                    .setFormattedList(si.getPrices().getFormattedList())
                                    .setFormattedMsrp(si.getPrices().getFormattedMsrp())
                                    .setFormattedSale(si.getPrices().getFormattedSale())
                                    .build())
                            .build()));

                    return ProductInfoResponse.newBuilder()
                            .setProductId(productInfo.getProductId())
                            .setShortName(productInfo.getShortName())
                            .setLongName(productInfo.getLongName())
                            .setActive(productInfo.isActive())
                            .setDescription(productInfo.getDescription())
                            .addAllSkus(skuInfos)
                            .build();
                });
    }
}
