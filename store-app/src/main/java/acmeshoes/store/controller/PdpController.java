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
package acmeshoes.store.controller;

import acmeshoes.store.service.PdpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

/**
 * Controller responsible for aggregating product data from backend services
 * and displaying the PDP page.
 */
@Controller
public class PdpController {

    @Autowired
    private PdpService pdpService;

    /**
     * Display the PDP page for a product.
     *
     * @param productId product id
     * @param model mvc model
     * @return the name of the page to display
     */
    @GetMapping("/product/{productId}")
    public Mono<String> pdp(@PathVariable("productId") String productId,
                            Model model) {
        return pdpService.getProductPage(productId)
                .switchIfEmpty(Mono.fromSupplier(() -> null))
                .map(pdpData -> {
                    model.addAttribute("pdpData", pdpData);
                    return pdpData == null ? "notfound" : "pdp";
                });
    }
}
