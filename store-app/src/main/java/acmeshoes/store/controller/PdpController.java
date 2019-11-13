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
