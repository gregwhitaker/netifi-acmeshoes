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
package acmeshoes.service.product.data;

import acmeshoes.service.product.data.model.Prices;
import acmeshoes.service.product.data.model.Product;
import acmeshoes.service.product.data.model.Sku;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class DefaultProductRepository implements ProductRepository {
    private static final Random RAND = new Random(System.currentTimeMillis());

    private final Map<String, Product> productInfos = new HashMap<>();

    @PostConstruct
    public void init() {
        for (int i = 1; i <= 10; i++) {
            String productId = String.format("%03d", i);

            Product productInfo = new Product();
            productInfo.setProductId(productId);
            productInfo.setShortName("Simple Shoe " + i);
            productInfo.setLongName("The Simple Shoe - " + i);
            productInfo.setDescription(String.format("This is some type of shoe - %s, that you can't live without!", i));
            productInfo.setActive(true);

            for (int x = 0; x < 3; x++) {
                Prices priceInfo = new Prices();
                priceInfo.setSale(generateDummyPrice(10.0));
                priceInfo.setList(generateDummyPrice(priceInfo.getSale()));
                priceInfo.setMsrp(generateDummyPrice(priceInfo.getList()));

                Sku s = new Sku();
                s.setSku(productId + "-" + String.format("%03d", x));
                s.setActive(true);

                if (x == 0) {
                    s.setSize("Small");
                } else if (x == 1) {
                    s.setSize("Medium");
                } else if (x == 2) {
                    s.setSize("Large");
                } else {
                    s.setSize("One-Size");
                }

                s.setPrices(priceInfo);

                productInfo.addSkuInfo(s);
            }

            productInfos.put(productId, productInfo);
        }
    }

    @Override
    public Mono<Product> getProduct(String productId) {
        return null;
    }

    private double generateDummyPrice(double min) {
        double randomValue = min + RAND.nextDouble();
        double tempRes = Math.floor(randomValue * 10) + 1;
        double price = tempRes/10;

        return price;
    }
}
