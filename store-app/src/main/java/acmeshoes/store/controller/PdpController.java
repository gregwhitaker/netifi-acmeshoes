package acmeshoes.store.controller;

import acmeshoes.store.service.PdpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PdpController {

    @Autowired
    private PdpService pdpService;

    @GetMapping("/product/{productId}")
    public String pdp(@PathVariable("productId") String productId,
                      Model model) {
        return null;
    }
}
