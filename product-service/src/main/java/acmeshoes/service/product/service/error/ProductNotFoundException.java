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
package acmeshoes.service.product.service.error;

/**
 * Exception thrown when a product cannot be found.
 */
public class ProductNotFoundException extends RuntimeException {

    private String productId;

    public ProductNotFoundException(final String productId) {
        super("Product not found: " + productId);
    }

    public String getProductId() {
        return productId;
    }
}
