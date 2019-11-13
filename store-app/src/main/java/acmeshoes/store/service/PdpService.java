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
package acmeshoes.store.service;

import acmeshoes.service.inventory.protobuf.InventoryServiceClient;
import acmeshoes.service.product.protobuf.ProductServiceClient;
import acmeshoes.store.service.model.PdpData;
import com.netifi.spring.core.annotation.Group;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Service that calls the backend product services and aggregates the data
 * into a form that can be displayed by the PDP page.
 */
@Service
public class PdpService {

    @Group("acmeshoes.service.product")
    private ProductServiceClient productClient;

    @Group("acmeshoes.service.inventory")
    private InventoryServiceClient inventoryClient;

    public Mono<PdpData> getProductPage(String productId) {
        return null;
    }
}
