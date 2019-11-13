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

import acmeshoes.service.product.data.model.Product;
import reactor.core.publisher.Mono;

/**
 * Repository that returns product information.
 */
public interface ProductRepository {

    /**
     * Get product information for a single product.
     *
     * @param productId product id
     * @return product information
     */
    Mono<Product> findOne(String productId);
}
